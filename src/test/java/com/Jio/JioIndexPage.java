package com.Jio;

import com.framework.init.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 */

public class JioIndexPage extends AbstractPage {
    public JioIndexPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    //------------------------Variables Definition-------------------------------

    public static String _contactNo = "";

    //------------------------Locators Definition---------------------------------

    @AndroidFindBy(id = "com.jio.myjio:id/iv_close_permission_dialog")
    private WebElement btnClose;

    @AndroidFindBy(id = "com.jio.myjio:id/et_jio_number")
    private WebElement txtMobileNumber;

    @AndroidFindBy(id = "com.jio.myjio:id/button_generate_otp")
    private WebElement btnGenerateOTP;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement btnAllow;

    //------------------------Method Declaration----------------------------------

    public JioVerification skipIntroduction(){
        try {
            testStepsLog(_logStep++,"Click on close button to skip introduction.");
            clickOn(androidDriver,btnClose);
            pause(3);

        } catch (Exception e) {
            testValidationLog("Introduction screen skipped already.");
        }
        return new JioVerification(androidDriver);
    }

    public JioVerification enterMobileNumber(String contactNo){
        _contactNo = contactNo;
        testInfoLog("Mobile Number", _contactNo);
        type(txtMobileNumber, _contactNo);
        pause(2);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnGenerateOTPButton(){
        testStepsLog(_logStep++,"Click on Generate OTP button.");
        clickOn(androidDriver,btnGenerateOTP);
       // pause(5);
        return new JioVerification(androidDriver);
    }

    public void permissions(){
        try{
        testStepsLog(_logStep++,"Click on allow permission button.");
        clickOn(androidDriver,btnAllow);
        pause(2);
        }catch (Exception e){
            testValidationLog("Already given permissions.");
        }
    }
}
