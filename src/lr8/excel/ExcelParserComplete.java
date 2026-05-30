package lr8.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExcelParserComplete {
    private static final String FILE_PATH = "src/Ir8/recources/data.xlsx";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("         EXCEL ПАРСЕР - МЕНЮ");
            System.out.println("1. Прочитать Excel файл");
            System.out.println("2. Создать Excel файл");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> readExcelFile();
                case 2 -> createExcelFile();
                case 3 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static void readExcelFile() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.err.println("Файл не существует! Сначала создайте его (пункт 2)");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook;
            if (FILE_PATH.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new HSSFWorkbook(fis);
            }

            if (workbook.getNumberOfSheets() == 0) {
                System.err.println("Нет листов в файле!");
                return;
            }

            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("\n=== СОДЕРЖИМОЕ ЛИСТА: " + sheet.getSheetName() + " ===");

            boolean hasData = false;
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String value = getCellValue(cell);
                    System.out.print(value + "\t");
                    hasData = true;
                }
                System.out.println();
            }

            if (!hasData) System.out.println("Файл пуст!");

            workbook.close();

        } catch (Exception e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }

    private static void createExcelFile() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Данные");

            Row header = sheet.createRow(0);
            String[] headers = {"ID", "Имя", "Возраст", "Город"};
            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            Object[][] data = {
                    {1, "Иван Иванов", 25, "Москва"},
                    {2, "Петр Петров", 30, "СПб"},
                    {3, "Мария Сидорова", 28, "Екб"}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue((Integer) rowData[0]);
                row.createCell(1).setCellValue((String) rowData[1]);
                row.createCell(2).setCellValue((Integer) rowData[2]);
                row.createCell(3).setCellValue((String) rowData[3]);
            }

            for (int i = 0; i < headers.length; i++) sheet.autoSizeColumn(i);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
                System.out.println("Excel файл создан: " + FILE_PATH);
            }
        } catch (IOException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }
}