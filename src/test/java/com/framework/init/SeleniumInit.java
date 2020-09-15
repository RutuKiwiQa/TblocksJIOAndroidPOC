package com.framework.init;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.common.Generics;
import com.framework.configurations.Configuration;
import com.framework.logger.TestLogger;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 */

public class SeleniumInit extends Generics implements Configuration {

    protected AndroidDriver<MobileElement> androidDriver;

    private DesiredCapabilities capability = new DesiredCapabilities();



    @BeforeSuite(alwaysRun = true)
    public void startReport(ITestContext testContext) {
        ExtentInitializer.initializeReport(testContext.getCurrentXmlTest().getSuite().getName());
    }

    /**
     * To initialize the driver before executing the test cases
     *
     * @param method Test Method Instance
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {



        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_ID);
        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
        capability.setCapability(MobileCapabilityType.FULL_RESET, false);
        capability.setCapability(MobileCapabilityType.NO_RESET, true);
        capability.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, JIO_APK);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, JIO_APP_PACKAGE);
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, JIO_APP_ACTIVITY);
        capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capability.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

        androidDriver = new AndroidDriver<>(Configuration.getRemoteGridURL(), capability);
        implicitWaitOf(androidDriver, 10);

        System.out.println("Session ID : " + androidDriver.getSessionId());

    }

    /**
     * To close the resources once the test execution is completed
     *
     * @param testResult Test Result
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {

        String testName;

        ITestContext ex = testResult.getTestContext();

        captureLog(androidDriver, testResult.getName());

        try {
            testName = testResult.getName();
            if (testResult.getStatus() == ITestResult.FAILURE) {

                logger.log(Status.FAIL, MarkupHelper.createLabel(testName + " - Test Case Failed", ExtentColor.RED));
                logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
                String screenshotPath = getExtentScreenShot(androidDriver, testName);
                logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

                System.out.println("TEST FAILED - " + testName + "\n");
                System.out.println("ERROR MESSAGE: " + testResult.getThrowable() + "\n");

                Reporter.setCurrentTestResult(testResult);

                String screenshotName = getCurrentTimeStampString() + testName;

                makeScreenshot(androidDriver, screenshotName);
                TestLogger.failure();

                getShortException(ex.getFailedTests());

            } else if ((testResult.getStatus() == ITestResult.SUCCESS)) {
                logger.log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case PASSED", ExtentColor.GREEN));
                System.out.println("TEST PASSED - " + testName + "\n");
            } else if ((testResult.getStatus() == ITestResult.SKIP)) {
                logger.log(Status.SKIP, MarkupHelper.createLabel(testName + " - Test Case Skipped", ExtentColor.ORANGE));
            }

            capability.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false);
            capability.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);



        } catch (Exception throwable) {
            System.err.println("System Exception Caught ::\n" + throwable);
        }
    }

    /**
     * To flush the extent report details.
     */
    @AfterSuite(alwaysRun = true)
    public void endReport() {
        ExtentInitializer.flushReport();
    }

}