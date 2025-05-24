//package com.booksWagon.utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExcelUtils {
//    private static final String FILE_PATH = "src/test/resources/testingData/TestData.xlsx";
//
//    public static List<String[]> readTestData() {
//        List<String[]> testData = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheet("LoginData");
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row
//                Row row = sheet.getRow(i);
//                String mobile = row.getCell(0).getStringCellValue();
//                String password = row.getCell(1).getStringCellValue();
//                String otp = row.getCell(2).getStringCellValue();
//                String expectedResult = row.getCell(3).getStringCellValue();
//                testData.add(new String[]{mobile, password, otp, expectedResult});
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return testData;
//    }
//
//    public static void writeTestResult(int rowIndex, String actualResult) {
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheet("LoginData");
//            Row row = sheet.getRow(rowIndex);
//            Cell resultCell = row.createCell(4, CellType.STRING);
//            resultCell.setCellValue(actualResult);
//
//            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
//                workbook.write(fos);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
////


package com.booksWagon.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
    
    private static FileInputStream fi;
    private static FileOutputStream fo;
    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static int getRowCount(String filePath, String sheetName) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount + 1;
    }

    public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        
        String data = (cell == null) ? "" : cell.toString();
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        
        fo = new FileOutputStream(filePath);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
