package com.framework.common;

import com.framework.configurations.Configuration;
import com.framework.logger.TestLogger;
import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Generics extends TestLogger {

    protected static int _logStep = 1;

    private static Faker faker = new Faker(new Locale("en-IND"));

    /**
     * Pause for passed seconds
     *
     * @param secs Time in Seconds
     */
    public static void pause(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException interruptedException) {
            System.out.println("Failure in Pause.");
        }
    }

    /**
     * To clear and send the value to the text field
     *
     * @param webElement WebElement
     * @param value      String Value
     */
    public static void type(WebElement webElement, String value) {
        if (!getText(webElement).isEmpty()) {
            clear(webElement);
        }
        pause(1);
        webElement.sendKeys(value);
    }

    /**
     * To clear the value from the text field
     *
     * @param webElement WebElement
     */
    public static void clear(WebElement webElement) {
        webElement.clear();
    }

    /**
     * To click on particular WebElement
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void clickOn(WebDriver driver, WebElement element) {
        pause(1);
        try {
            element.click();
        } catch (ElementClickInterceptedException ex) {
            clickOnJS(driver, element);
        }
    }

    public static void clickOnJS(WebDriver driver, WebElement element) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class).
                until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getText(WebElement element) {
        //wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return element.getText().trim();
    }

    /**
     * To check if element is available in page or not
     *
     * @param element WebElement
     * @return if web element display or not
     */
    public static boolean isElementDisplay(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * To get the random number from 10000 to 99999
     *
     * @return Random Number
     */
    public static int getRandomNumber() {
        return faker.number().numberBetween(10000, 99999);
    }

    public static int sizeOf(List list) {
        return list.size();
    }

    public static int getIntegerFromString(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9.]+", ""));
    }

    /**
     * To get the failure exception in single line
     *
     * @param tests Test Result
     */
    public static void getShortException(IResultMap tests) {

        for (ITestResult result : tests.getAllResults()) {

            Throwable exception = result.getThrowable();
            List<String> msgs = Reporter.getOutput(result);
            boolean hasReporterOutput = msgs.size() > 0;
            boolean hasThrowable = exception != null;
            if (hasThrowable) {
                boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
                if (hasReporterOutput) {
                    testInfoLog((wantsMinimalOutput ? "Expected Exception" : "Failure Reason:"), "");
                }

                String str = Utils.shortStackTrace(exception, true);
                System.out.println(str);
                Scanner scanner = new Scanner(str);
                String firstLine = scanner.nextLine();
                testValidationLog(firstLine);
            }
        }
    }

    public static void makeScreenshot(WebDriver driver, String screenshotName) {

        WebDriver augmentedDriver = new Augmenter().augment(driver);

        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtension = screenshotName + ".png";

        try {
            String reportFolder = "test-output" + File.separator;
            String screenshotsFolder = "screenshots";
            File screenshotFolder = new File(reportFolder + screenshotsFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot,
                    new File(screenshotFolder + File.separator + nameWithExtension).getAbsoluteFile());
        } catch (IOException e) {
            testWarningLog("Failed to capture screenshot: " + e.getMessage());
        }
        testInfoLog("Step Failure<br>Please check attached screenshot : <br><br>", getScreenshotLink(nameWithExtension));
    }

    public static String getScreenshotLink(String screenshot_name) {
        return "<img src='../test-output/screenshots/" + screenshot_name + "' width='380' height='640'/>";
    }

    public static String getExtentScreenShot(WebDriver driver, String screenshot_name) {
        String destination = "";
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = System.getProperty("user.dir") + "/Screenshots/" + screenshot_name + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String getCurrentTimeStampString() {

        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(cal);
        return sd.format(date);
    }

    public void stepFailure(WebDriver driver) {
        makeScreenshot(driver, getCurrentTimeStampString());
        TestLogger.failure();
    }

    public void stepPassed() {
        success();
    }

    public void implicitWaitOf(AndroidDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected static void captureLog(AndroidDriver driver, String testName) {
        String reportDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMMyyyy_HHmmss"));

        File directory = new File(PROJECT_DIR + File.separator + "logcat");

        if (!directory.exists()) if (directory.mkdir()) System.out.println("Logcat directory created.");

        System.out.println("_____________________________________________________________________________");
        System.out.println("Saving device log for Session : " + driver.getSessionId());

        List<LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
        File logFile = new File(directory + File.separator + reportDate + "_" + testName + ".log");

        try {
            PrintWriter logWriter = new PrintWriter(logFile);
            logEntries.forEach(logWriter::println);
            logWriter.flush();
            System.out.println("Logcat logs saved for session : " + driver.getSessionId() + " - located at");
            System.out.println(logFile);
            System.out.println("_____________________________________________________________________________");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}