//package com.booksWagon.utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExcelUtils {
//    private static Workbook workbook;
//
//    public static Map<String, String> getLoginData(String filePath, String sheetName) throws IOException {
//        Map<String, String> loginData = new HashMap<>();
//        FileInputStream file = new FileInputStream(filePath);
//        workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        for (Row row : sheet) {
//            Cell keyCell = row.getCell(0);
//            Cell valueCell = row.getCell(1);
//
//            if (keyCell != null && valueCell != null) {
//                String key = getCellValueAsString(keyCell);
//                String value = getCellValueAsString(valueCell);
//                loginData.put(key, value);
//            }
//        }
//        file.close();
//        return loginData;
//    }
//
//    private static String getCellValueAsString(Cell cell) {
//        if (cell.getCellType() == CellType.NUMERIC) {
//            return String.valueOf((int) cell.getNumericCellValue()); // Convert numeric to string
//        } else {
//            return cell.getStringCellValue();
//        }
//    }
//}




package com.booksWagon.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    public static Map<String, String> getTestData(String filePath, String sheetName) throws IOException {
        Map<String, String> testData = new HashMap<>();
        
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {
             
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " not found in file " + filePath);
            }

            for (Row row : sheet) {
                if (row == null) continue;

                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (keyCell != null && valueCell != null) {
                    String key = getCellValueAsString(keyCell);
                    String value = getCellValueAsString(valueCell);
                    testData.put(key, value);
                }
            }
        }
        return testData;
    }

    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
