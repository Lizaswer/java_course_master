package lr8.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCreateExample {
    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Товары");

            // Заголовки
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Название товара");
            headerRow.createCell(1).setCellValue("Характеристики");
            headerRow.createCell(2).setCellValue("Стоимость");

            // Данные
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Книга Java");
            row1.createCell(1).setCellValue("512 стр.");
            row1.createCell(2).setCellValue(1500);

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("Ноутбук");
            row2.createCell(1).setCellValue("16GB RAM");
            row2.createCell(2).setCellValue(45000);

            for (int i = 0; i < 3; i++) sheet.autoSizeColumn(i);

            try (FileOutputStream out = new FileOutputStream("src/Ir8/recources/data.xlsx")) {
                workbook.write(out);
                System.out.println(" Excel файл создан: src/Ir8/recources/data.xlsx");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}