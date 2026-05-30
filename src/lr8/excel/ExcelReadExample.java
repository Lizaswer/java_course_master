package lr8.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadExample {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("src/Ir8/recources/data.xlsx");
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.out.println("Лист 'Товары' не найден!");
                return;
            }

            System.out.println("=== СОДЕРЖИМОЕ EXCEL ===");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                        case NUMERIC -> System.out.print((long) cell.getNumericCellValue() + "\t");
                        default -> System.out.print(" \t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}