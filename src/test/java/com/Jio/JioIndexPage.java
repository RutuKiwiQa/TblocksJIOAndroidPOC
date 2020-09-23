package com.Jio;

import com.framework.init.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Map;

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
    public static int _otp;
    public static String _currentPlanPrice = "";
    public static String _currentPlanData = "";
    public static int _invalidNumber;

    //------------------------Locators Definition---------------------------------

    @AndroidFindBy(id = "com.jio.myjio:id/iv_close_permission_dialog")
    private WebElement btnClose;

    @AndroidFindBy(id = "com.jio.myjio:id/et_jio_number")
    private WebElement txtMobileNumber;

    @AndroidFindBy(id = "com.jio.myjio:id/button_generate_otp")
    private WebElement btnGenerateOTP;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement btnAllow;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.jio.myjio:id/et_otp_')]")
    private List<WebElement> lstOTP;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_service_id")
    private WebElement lblUserNumberDashboard;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    private WebElement teleComTab;

    @AndroidFindBy(id = "com.jio.myjio:id/main_btn")
    private WebElement btnRecharge;

    @AndroidFindBy(id = "com.jio.myjio:id/bt_dashboard_inside_menu_drawer")
    private WebElement btnMenu;

    @AndroidFindBy(id = "com.jio.myjio:id/close_btn")
    private WebElement closeNews;

    @AndroidFindAll(value = {
            @AndroidBy(id = "com.jio.myjio:id/bucket_header")})
    private List<MobileElement> lstCurrentPlan;

    @AndroidFindAll(value = {
            @AndroidBy(id = "com.jio.myjio:id/tv_plan_data")})
    private List<MobileElement> lstCurrentPlanData;

    @AndroidFindBy(id = "com.jio.myjio:id/bt_dashboard_inside_menu_drawer")
    private WebElement btnBack;

    @AndroidFindAll(value = {
            @AndroidBy(id = "com.jio.myjio:id/list_item_dynamic_burger_menu")})
    private List<MobileElement> lstMenuItems;

    @AndroidFindBy(id = "com.jio.myjio:id/button_submit")
    private WebElement btnProceed;

   @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
   private WebElement btnLogout;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_confirm")
    private WebElement btnYes;


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

    public JioVerification clickOnTeleComTab(){
        testStepsLog(_logStep++,"Click on telecom Tab.");
        clickOn(androidDriver,teleComTab);
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnCloseNews(){
        try{
        testStepsLog(_logStep++,"Click on Close \"Explore Now\" advertisement.");
        clickOn(androidDriver,closeNews);
        pause(3);
        }catch (Exception e){
            testValidationLog("Already closed \"Explore Now\" advertisement. ");
        }

        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnCurrentPlan(){
        testStepsLog(_logStep++,"Click on Current Plan button.");
        clickOn(androidDriver,lstCurrentPlan.get(0));
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification getDetailsOfCurrentPlan(){
        _currentPlanPrice = getText(lstCurrentPlanData.get(0));
        _currentPlanData =  getText(lstCurrentPlanData.get(1));

        testInfoLog("Current Plan Amount : ", _currentPlanPrice);
        testInfoLog("Current Plan Data : ", _currentPlanData);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnBackButton(){
        testStepsLog(_logStep++,"Click on back button from current plan details screen.");
        clickOn(androidDriver,btnBack);
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnMenuButton(){
        testStepsLog(_logStep++,"Click on Menu button.");
        clickOn(androidDriver,btnMenu);
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnRechargeForFriendButton(){
        testStepsLog(_logStep++,"Click on Recharge for a friend.");
        clickOn(androidDriver,lstMenuItems.get(3));
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification enterInvalidMobileNumber(){
        _invalidNumber = getRandomNumber() + getRandomNumber();
        testInfoLog("Mobile Number", String.valueOf(_invalidNumber));
        type(txtMobileNumber, String.valueOf(_invalidNumber));
        pause(2);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnProceedButton(){
        testStepsLog(_logStep++,"Click on Proceed Button.");
        clickOn(androidDriver,btnProceed);
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnBackButtonFromRechargeFriendScreen(){
        testStepsLog(_logStep++,"Click on Back button.");
        clickOn(androidDriver,btnBack);
        pause(3);
        return new JioVerification(androidDriver);
    }



    public JioVerification clickOnBackFromRechargeScreen(){
        testStepsLog(_logStep++,"Click on Back button from recharge for a friend screen.");
        clickOn(androidDriver,btnBack);
        pause(3);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnSettings(){
        testStepsLog(_logStep++,"Click on Settings Button.");
        clickOn(androidDriver,lstMenuItems.get(10));
        pause(3);
        return new JioVerification(androidDriver);
    }

    private void scrollToBottom() {
        new TouchAction<>(androidDriver).press(PointOption.point(100, (androidDriver.manage().window().getSize().height * 85) / 100)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
                moveTo(PointOption.point(100, (androidDriver.manage().window().getSize().height * 10) / 100)).release().perform();
    }

    public JioVerification clickOnLogoutButton(){
        scrollToBottom();
        testStepsLog(_logStep++,"Click on Logout Button.");
        clickOn(androidDriver,btnLogout);
        pause(2);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnYesButton(){
        testStepsLog(_logStep++,"Click on Yes Button.");
        clickOn(androidDriver,btnYes);
        pause(2);
        return new JioVerification(androidDriver);
    }

    public JioVerification clickOnRechargeButton(){
        testStepsLog(_logStep++,"Click on Recharge Button.");
        clickOn(androidDriver,btnRecharge);
        pause(2);
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


    @SuppressWarnings("unchecked")
    public void getOTPFromNotification() {
        for (Map<String, Object> notification : (List<Map<String, Object>>) ((Map<String, Object>)
                androidDriver.executeScript("mobile: getNotifications")).
                get("statusBarNotifications")) {
            String notificationText = ((Map<String, String>) notification.get("notification")).get("text");
            if (notificationText.contains("Team Jio")) {
                _otp = getIntegerFromString(notificationText);
                break;
            }
        }
        for (int i = 0; i < sizeOf(lstOTP); i++) lstOTP.get(i).sendKeys(String.valueOf(_otp).split("")[i]);
    }
}
