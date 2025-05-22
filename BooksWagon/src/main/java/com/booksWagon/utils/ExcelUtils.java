//package com.booksWagon.utils;
//
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//
//public class ExcelUtils {
//
//    private static Workbook workbook;
//    private static Sheet sheet;
//
//    public static void setExcelFile(String excelPath, String sheetName) {
//        try {
//            FileInputStream fis = new FileInputStream(excelPath);
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheet(sheetName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getCellData(int rowNum, int colNum) {
//        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//    }
//
//    public static void setCellData(String data, int rowNum, int colNum, String excelPath) {
//        try {
//            Row row = sheet.getRow(rowNum);
//            Cell cell = row.createCell(colNum);
//            cell.setCellValue(data);
//
//            FileOutputStream fos = new FileOutputStream(excelPath);
//            workbook.write(fos);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
////