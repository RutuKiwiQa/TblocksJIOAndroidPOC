package com.framework.init;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.configurations.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 * <p>
 * This class is initializing and using the Extent Report
 * configurations to generate report once the test execution is completed
 */
public class ExtentInitializer implements Configuration {

    protected static ExtentReports extent;
    protected static ExtentTest logger;

    /**
     * To initialize the Extent Report instance before starting the execution
     *
     * @param suiteName - Test Suite Name for the report
     */
    static void initializeReport(String suiteName) {

        Map<String, String> deviceProp = new HashMap<>();

        File directory = new File(PROJECT_DIR + File.separator + "ExtentReports");

        if (!directory.exists()) if (directory.mkdir()) System.out.println("Extent Reports directory created.");

        ExtentHtmlReporter htmlReporter;
        htmlReporter = new ExtentHtmlReporter(PROJECT_DIR + File.separator + "ExtentReports" +
                File.separator + "Report_" + suiteName  + ".html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        if (APPIUM_HUB.equalsIgnoreCase("localhost") || APPIUM_HUB.equalsIgnoreCase("0.0.0.0")) {

            String temp, value, deviceID = "";

            Runtime rt = Runtime.getRuntime();

            ArrayList<String> propKey = new ArrayList<String>() {
                {
                    add("ro.product.manufacturer");
                    add("ro.product.model");
                    add("ro.build.software.version");
                    add("persist.sys.timezone");
                    add("gsm.operator.alpha");
                }
            };

            try {
                Process p = rt.exec("adb devices");
                InputStream is = p.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                while ((temp = reader.readLine()) != null) {
                    if (temp.endsWith("device")) {
                        deviceID = temp.replaceAll("device", "").trim();
                        break;
                    }
                }

                for (String key : propKey) {
                    p = rt.exec("adb -s " + deviceID + " shell getprop " + key);
                    is = p.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is));

                    while ((value = reader.readLine()) != null) deviceProp.put(key, value);
                }

                is.close();

                System.out.println("Running " + deviceProp.get("ro.product.manufacturer") + " " +
                        deviceProp.get("ro.product.model") + " with Android OS : " +
                        deviceProp.get("ro.build.software.version"));

            } catch (Exception e) {
                System.out.println("ADB Exception failed");
            }
        }


        extent.setSystemInfo("OS : ", System.getProperty("os.name"));
        extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
        extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
        extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
        extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));

        if (APPIUM_HUB.equalsIgnoreCase("localhost") || APPIUM_HUB.equalsIgnoreCase("0.0.0.0")) {
            extent.setSystemInfo("Device Manufacturer : ", deviceProp.get("ro.product.manufacturer"));
            extent.setSystemInfo("Device Model : ", deviceProp.get("ro.product.model"));
            extent.setSystemInfo("Android Model : ", deviceProp.get("ro.build.software.version"));
            extent.setSystemInfo("Device Timezone : ", deviceProp.get("persist.sys.timezone"));
            extent.setSystemInfo("Device SIM Operators : ", deviceProp.get("gsm.operator.alpha"));
        }

        extent.setAnalysisStrategy(AnalysisStrategy.TEST);

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Jio Android App POC Test Automation Report");
        htmlReporter.config().setReportName("Jio POC Test Report");
        htmlReporter.config().setReportName("<img src='https://www.kiwiqa.com/wp-content/uploads/2017/06/KiwiQA_option2.png' " +
                "width='auto' height='40' style='margin-top: 5px;' align='center'/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" );
    }

    /**
     * To flush the Extent Report after test suite is completed
     */
    static void flushReport() {
        extent.flush();
    }

}
