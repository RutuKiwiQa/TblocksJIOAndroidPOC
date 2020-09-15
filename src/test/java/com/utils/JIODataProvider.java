package com.utils;

import com.framework.configurations.Configuration;
import com.framework.init.SeleniumInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 */

public class JIODataProvider extends SeleniumInit implements Configuration {
//public class JIODataProvider implements Configuration{

    @Test(dataProvider = "Jio")
    public void test1(String contactNo){
        System.out.println(contactNo
        );
    }

    /**Testng data providers.*/
    @DataProvider(name = "Jio")
    public Object[][] getData() throws IOException {
        Object data[][] = testData(WORKBOOK,"JIO");
        return data;
    }


    /**This is excel data provider function.*/
    public  Object[][] testData(String excelPath, String sheetName) throws IOException {

        ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
        int rowCount =  excelUtils.getRowCount();
        int colCount = excelUtils.getColumnCount();


        Object data[][] = new Object[rowCount-1][colCount];

        for (int i =1; i<rowCount; i++){
            for (int j = 0; j<colCount; j++){
                String cellData = excelUtils.getCellDataString(i,j);
              //  System.out.print(cellData + " | ");
                data[i-1][j] = cellData;
            }
          //  System.out.println();
        }
        return data;
    }

}
