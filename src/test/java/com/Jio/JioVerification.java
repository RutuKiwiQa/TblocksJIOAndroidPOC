package com.Jio;

import com.framework.init.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JioVerification extends AbstractPage {
    public JioVerification(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    //------------------------Locators Definition---------------------------------

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.TabWidget/android.widget.RelativeLayout[1]")
    private WebElement mobileTab;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.TabWidget/android.widget.RelativeLayout[2]")
    private WebElement jioFiberTab;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.TabWidget/android.widget.RelativeLayout[3]")
    private WebElement jioFiTab;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.TabWidget/android.widget.RelativeLayout[4]")
    private WebElement jioLinkTab;

    @AndroidFindBy(id = "com.jio.myjio:id/et_jio_number")
    private WebElement txtMobileNumber;

    @AndroidFindBy(id = "com.jio.myjio:id/button_generate_otp")
    private WebElement btnGenerateOTP;

    @AndroidFindBy(id = "com.jio.myjio:id/constraint_login_with_qr")
    private WebElement loginWithQR;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_not_a_jio_user_question")
    private WebElement notJioUser;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_service_id")
    private WebElement lblUserNumberDashboard;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    private WebElement teleComTab;

    @AndroidFindBy(id = "com.jio.myjio:id/main_btn")
    private WebElement btnRecharge;

    @AndroidFindBy(id = "com.jio.myjio:id/bt_dashboard_inside_menu_drawer")
    private WebElement btnMenu;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_current_service_id")
    private WebElement lblUserNumber;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")
    private WebElement lblCurrentPlanDetail;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]")
    private WebElement totalSMS;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]")
    private WebElement remainingSMS;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]")
    private WebElement dataLeft;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]")
    private WebElement nonJioVoiceMins;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View[2]")
    private WebElement omnet;

    @AndroidFindBy(id = "com.jio.myjio:id/lnr_profile")
    private WebElement loggedInUserName;

    @AndroidFindBy(id = "com.jio.myjio:id/button_submit")
    private WebElement btnProceed;

    @AndroidFindBy(id = "com.jio.myjio:id/jio_number_error_tv")
    private WebElement lblInValidMessage;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_cancle")
    private WebElement btnNo;

    @AndroidFindBy(id = "com.jio.myjio:id/tv_confirm")
    private WebElement btnYes;





//


    //------------------------Method Declaration----------------------------------

    public boolean verifyJioHomeScreen(){
        return isElementDisplay(mobileTab) && isElementDisplay(jioFiberTab) &&
                isElementDisplay(jioFiTab) && isElementDisplay(jioLinkTab) &&
                isElementDisplay(txtMobileNumber) && isElementDisplay(btnGenerateOTP) &&
                isElementDisplay(loginWithQR) && isElementDisplay(notJioUser);
    }

    public boolean verifyDashboardScreen(){
        testInfoLog("Logged in user Number : " ,JioIndexPage._contactNo);
        testInfoLog("Registered user number : ", getText(lblUserNumberDashboard));
        return getText(lblUserNumberDashboard).equalsIgnoreCase(JioIndexPage._contactNo)
                && isElementDisplay(btnMenu) && isElementDisplay(btnRecharge);
    }

    public boolean verifyTelecomScreen(){
        testInfoLog("Logged in user Number : " ,JioIndexPage._contactNo);
        testInfoLog("Registered user number : ", getText(lblUserNumber));
        return getText(lblUserNumber).equalsIgnoreCase(JioIndexPage._contactNo) &&
                isElementDisplay(teleComTab);
    }

    public boolean verifyCurrentPlanScreen(){
        testInfoLog("Current Plan Details : ", getText(lblCurrentPlanDetail));
        testInfoLog("Total SMS : ", getText(totalSMS));
        testInfoLog("Remaining SMS : ", getText(remainingSMS));
        testInfoLog("Remaining Data Left : ", getText(dataLeft));
        testInfoLog("Voice - Non Jio : ", getText(nonJioVoiceMins));
        testInfoLog("Unlimited Omnet : ",getText(omnet));

        return  getText(lblCurrentPlanDetail).contains(JioIndexPage._currentPlanPrice) &&
                getText(dataLeft).contains(JioIndexPage._currentPlanData);
    }

    public boolean verifyMenuScreen(){
        testInfoLog("User Name : ",getText(loggedInUserName));

        return isElementDisplay(loggedInUserName);
    }

    public boolean verifyRechargeForFriendScreen(){
        return isElementDisplay(txtMobileNumber) && isElementDisplay(btnProceed);
    }

    public boolean verifyInvalidNumberValidation(){
        return isElementDisplay(lblInValidMessage);
    }

    public boolean verifyLogoutPopup(){
        return isElementDisplay(btnNo) && isElementDisplay(btnYes);
    }
}
