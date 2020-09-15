package com.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    /**
     * Created by Rutu Shah.
     * Date: 2020-09-15
     * Time:
     * Project Name: JIO_ANDROID_POC
     */

    static  XSSFWorkbook workbook;
    static XSSFSheet sheet;

    /**A constructor.*/
    public ExcelUtils(String excelPath, String sheetName) throws IOException {

        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);

    }

    public static void main(String[] args) throws IOException {
        getRowCount();
        getColumnCount();
    }

    /** To get row count of current sheet */
    public static int getRowCount() throws IOException {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();  //method which gives numbers of rows.
          // System.out.println("No of rows : "  + rowCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
           // e.printStackTrace();
        }
        return rowCount;
    }

    /** To get column count of current sheet */
    public static int getColumnCount() throws IOException {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();  //method which gives numbers of rows.
         //   System.out.println("No of columns : "  + colCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
        return colCount;
    }

    public static String  getCellDataString(int rowNum, int colNum) throws IOException {
        Object value = null;
        try {
            //getcelldata
            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            System.out.println("Cell Data : " + value);
        //    System.out.println(cellData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
        return (String) value;
    }

    public static void getCellDataNumber(int rowNum, int colNum) throws IOException {
        try {

            //getcelldata
            Double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue(); //this will store in a string value
         //   System.out.println(cellData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
    }


}
