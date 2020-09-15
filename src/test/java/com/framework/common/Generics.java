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
     * To find element by given xpath locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static MobileElement findElementByXPath(AndroidDriver<MobileElement> driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    /**
     * To find element list by given xpath locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static List<MobileElement> findElementsByXPath(AndroidDriver<MobileElement> driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * To find element by given Name locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static WebElement findElementByName(WebDriver driver, String locator) {
        return driver.findElement(By.name(locator));
    }

    /**
     * To find element list by given Name locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static List<WebElement> findElementsByName(WebDriver driver, String locator) {
        return driver.findElements(By.name(locator));
    }

    /**
     * To find element by given ID locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static MobileElement findElementByID(AndroidDriver<MobileElement> driver, String locator) {
        return driver.findElementById(locator);
    }

    /**
     * To find element list by given ID locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static List<MobileElement> findElementsByID(AndroidDriver<MobileElement> driver, String locator) {
        return driver.findElements(By.id(locator));
    }

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

    public static void sendKeys(WebElement webElement, String value) {
        webElement.sendKeys(value);
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
     * To get last 4 digits of the number ...
     * * * @param string Input String * @return four digit number
     */
    public static String getLastFourDigits(String string) {
        return string.substring(string.length() - 4);
    }

    /**
     * To get last 4 digits of the number ...
     * * * @param string Input String * @return four digit number
     */

    public static String getLastSevenDigits(String string) {
        return string.substring(string.length() - 7);
    }


    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getTextJS(WebDriver driver, WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return $(arguments[0]).text();", element).toString();
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
     * To check if element is available in page or not
     *
     * @param element WebElement
     * @return if web element display or not
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    public static boolean isElementPresent(AndroidDriver<MobileElement> driver, String locator) {
        try {
            return findElementByID(driver, locator).isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    public static boolean isElementPresentByXpath(AndroidDriver<MobileElement> driver, String locator) {
        try {
            return findElementByXPath(driver, locator).isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    /**
     * @param driver WebDriver
     * @param text   Search Text
     */
    public static void scrollToElement(AndroidDriver<MobileElement> driver, String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"" + text + "\"));");
    }

    /**
     * To get string with the random characters for with the passed characters length limit
     *
     * @param length String length
     * @return Random string
     */
    public static String getRandomCharacters(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


    /**
     * To get the random number from 10000 to 99999
     *
     * @return Random Number
     */
    public static int getRandomNumber() {
        return faker.number().numberBetween(10000, 99999);
    }

    /**
     * To get the random number from 10000 to 99999
     *
     * @return Random Number
     */
    public static int getRandomNumberBetween(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    /**
     * To check if the list is empty or not
     *
     * @param list List
     * @return true if list is empty
     */
    public static boolean isListEmpty(List list) {
        return list.size() == 0;
    }

    public static int sizeOf(List list) {
        return list.size();
    }

    public static int lastIndexOf(List list) {
        return sizeOf(list) - 1;
    }

    public static int getIntegerFromString(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9.]+", ""));
    }

    public static long getLongFromString(String str) {
        return Long.parseLong(str.replaceAll("[^0-9.]+", ""));
    }

    public static double getDoubleFromString(String str) {
        return Double.parseDouble(str.replaceAll("[^0-9.]+", ""));
    }

    public static double formatTwoDecimal(double num) {
        DecimalFormat format = new DecimalFormat("0.00");
        return getDoubleFromString(format.format(num));
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


    public static String getPropertyValueOf(String key) {
        return Configuration.getUserProperty(key);
    }

    public static void setAttribute(WebDriver driver, String id, String attr) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('" + id + "').setAttribute('attr', '" + attr + "')");
    }

    public static long getMonthDifferenceBetween(LocalDate joinMonthYear, LocalDate currentMonthYear) {
        return ChronoUnit.MONTHS.between(
                joinMonthYear.withDayOfMonth(1),
                currentMonthYear.withDayOfMonth(1));
    }

    public static void deleteDownloadDirectory() {
        try {
            FileUtils.deleteDirectory(new File(FILE_DOWNLOAD_PATH));
        } catch (IOException io) {
            testValidationLog("Failed to delete the folder.");
        }
    }

    public static Double findMin(List<Double> list) {
        if (list == null || list.size() == 0) {
            return Double.MAX_VALUE;
        }
        return Collections.min(list);
    }

    public static Double findMax(List<Double> list) {
        if (list == null || list.size() == 0) {
            return Double.MIN_VALUE;
        }
        return Collections.max(list);
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

    public static int getRandomIndex(List list) {
        return getRandomNumberBetween(0, lastIndexOf(list));
    }

    public static LinkedHashMap<String, String> getTestLoginDetails(String wb, String st, String tc) {

        XSSFWorkbook workbook;

        LinkedHashMap<String, String> testData = new LinkedHashMap<String, String>();
        LinkedList<String> data = new LinkedList<String>();

        try {
            workbook = new XSSFWorkbook(new FileInputStream(wb));

            String value = "";

            int noOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < noOfSheets; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase(st)) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    for (int rowNumber = 0; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                        XSSFRow row = sheet.getRow(rowNumber);
                        if (row.getCell(1).getStringCellValue().equalsIgnoreCase(tc)) {
                            for (int columnNumber = 0; columnNumber < row.getLastCellNum(); columnNumber++) {
                                XSSFCell c = row.getCell(columnNumber);
                                if (c != null) {
                                    switch (c.getCellType()) {
                                        case NUMERIC:
                                            if (DateUtil.isCellDateFormatted(c)) {
                                                value = (new SimpleDateFormat(
                                                        "dd-MM-yyyy").format(
                                                        c.getDateCellValue()));
                                                data.add(value);
                                            } else {
                                                value = (long) (c.getNumericCellValue()) + "";
                                                data.add(value);
                                            }
                                            break;
                                        case STRING:
                                            value = c.getStringCellValue();
                                            data.add(value);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            testValidationLog("Failed to load Excel Sheet.");
        }

        testData.put("Consumer Number", data.get(2));
        testData.put("Consumer PIN", data.get(3));
        testData.put("External User Number", data.get(4));
        testData.put("External User PIN", data.get(5));
        testData.put("External User Email", data.get(6));
        testData.put("External User Password", data.get(7));

        System.out.println("Test Name : " + tc);
        System.out.println("Test Data : " + testData);

        return testData;
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