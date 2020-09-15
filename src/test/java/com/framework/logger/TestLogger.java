package com.framework.logger;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.configurations.Configuration;
import com.framework.init.ExtentInitializer;
import org.testng.Reporter;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 * <p>
 * This class is used different logger methods for the loggin the results in the reports.
 */

public class TestLogger extends ExtentInitializer implements Configuration {

    /**
     * To log the Test Message in report
     *
     * @param log Log Message
     */
    private static void log(String log) {
        System.out.println(log.replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br>" + log);
    }

    /**
     * To log the Test Case Name in report
     *
     * @param log Log Message
     */
    protected static void testCaseLog(String log) {
        logger = extent.createTest(log);
        logger.assignAuthor("Rutu Shah");
        log("<strong>" + log + "</strong>");
    }

    /**
     * To log the information passed during the test execution in report
     *
     * @param key   Key/Log Message
     * @param value Value/Entered Details
     */
    public static void testInfoLog(String key, String value) {
        logger.info(key + " - " + value);
        log("<strong>" + key + " - </strong><font color=#9400D3>" + value + "</font>");
    }

    /**
     * To log the test steps in the report.
     *
     * @param logStep Step Number
     * @param log     Step Information
     */
    public static void testStepsLog(int logStep, String log) {
        logger.info(log);
        log("Step " + logStep + " : " + log);
    }

    /**
     * To log the test verification steps
     *
     * @param log Verification Message
     */
    protected static void testVerifyLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
        log("<font color=#000080>" + log + "</font>");
    }

    /**
     * To log the Validation Message comes during the test
     *
     * @param log Validation Message
     */
    protected static void testValidationLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.PINK));
        log("Validation Message : <Strong><font color=#ff0000>" + log + "</strong></font>");
    }

    /**
     * To log the Confirmation Message comes during the test
     *
     * @param log Confirmation Message
     */
    protected static void testConfirmationLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.TEAL));
        log("Confirmation Message : <Strong><font color=#008000>" + log + "</strong></font>");
    }

    /**
     * To log the Warning Message comes during the test
     *
     * @param log Warning Message
     */
    protected static void testWarningLog(String log) {
        logger.warning(MarkupHelper.createLabel(log, ExtentColor.AMBER));
        log("Warning Message : <Strong><font color=#FF1870>" + log + "</strong></font>");
    }

    /**
     * To log the test verification step is passed successfully
     */
    protected static void success() {
        logger.pass(MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
        System.out.println("<Strong><font color=#008000>Pass</font></strong>".replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br><Strong><font color=#008000>Pass</font></strong>");
    }

    /**
     * To log test verification is failed
     */
    public static void failure() {
        logger.fail(MarkupHelper.createLabel("FAIL", ExtentColor.RED));
        System.out.println("<Strong><font color=#ff0000>Fail</font></strong>".replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br><Strong><font color=#ff0000>Fail</font></strong>");
    }

}
