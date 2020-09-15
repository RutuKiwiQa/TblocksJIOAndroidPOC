package com.framework.configurations;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public interface Configuration {

    Properties configProp = new Properties();
    Properties userProp = new Properties();

    String configurationPath = "Resources/config.properties";
    String JioList = "Resources/jio.properties";

    String JIO = "Jio";

    String PROJECT_DIR = getProjectDir();

    String DEVICE_ID = getProperty("deviceID");


    String JIO_APK = PROJECT_DIR + File.separator + "Resources" + File.separator + "apks" + File.separator
            + getUserProperty("jio_apk");
    String JIO_APP_PACKAGE = getUserProperty("jio_appPackage");
    String JIO_APP_ACTIVITY = getUserProperty("jio_appActivity");

    String APPIUM_HUB = getProperty("appium_hub");
    String APPIUM_PORT = getProperty("appium_port");

    String FILE_DOWNLOAD_PATH = PROJECT_DIR + File.separator + "download";

    String WORKBOOK = PROJECT_DIR + File.separator + "Resources" + File.separator + "TestData.xlsx";


    static URL getRemoteGridURL() {

        URL REMOTE_GRID_URL = null;

        try {
            REMOTE_GRID_URL = new URL("http://" + APPIUM_HUB + ":" + APPIUM_PORT + "/wd/hub");
        } catch (MalformedURLException ex) {
            System.err.println("Error occurred in Remote Grid URL.");
        }

        return REMOTE_GRID_URL;
    }

    /**
     * To get the current project directory path
     *
     * @return Project Directory path
     */
    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

    /**
     * To get the Test Configuration Property values
     *
     * @param key Key
     * @return Value of Key
     */
    static String getProperty(String key) {
        try {
            configProp.load(new FileInputStream(configurationPath));
        } catch (Exception e) {
            System.err.println("Error occurred while reading the file.");
        }
        return configProp.getProperty(key);
    }

    /**
     * To get the User Configuration Property values
     *
     * @param key Key
     * @return Value of Key
     */
    static String getUserProperty(String key) {
        try {
            userProp.clear();
            userProp.load(new FileInputStream(JioList));
        } catch (Exception e) {
            System.err.println("Error occurred while reading the file.");
        }
        return userProp.getProperty(key);
    }

    static void writeProperty(String key, String value) {
        try {
            userProp.setProperty(key, value);
            userProp.store(new FileOutputStream(JioList), null);
        } catch (Exception e) {
            System.err.println("Error occurred while reading the file.");
        }
    }

}