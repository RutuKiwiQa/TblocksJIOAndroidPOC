package com.Jio;

import com.framework.init.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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



    //------------------------Method Declaration----------------------------------

    public boolean verifyJioHomeScreen(){
        return isElementDisplay(mobileTab) && isElementDisplay(jioFiberTab) &&
                isElementDisplay(jioFiTab) && isElementDisplay(jioLinkTab) &&
                isElementDisplay(txtMobileNumber) && isElementDisplay(btnGenerateOTP) &&
                isElementDisplay(loginWithQR) && isElementDisplay(notJioUser);
    }
}
