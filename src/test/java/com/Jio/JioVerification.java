package com.Jio;

import com.framework.init.AbstractPage;
import com.utils.JIODataProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class JioVerification extends AbstractPage {
    public JioVerification(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    //------------------------------Variables Declaration-------------------------

    public static String _598PlansFromExcel;
    public static String _598ValidityFromExcel;
    public static String _598BenefitsFromExcel;

    public static String _2599PlansFromExcel;
    public static String _2599ValidityFromExcel;
    public static String _2599BenefitsFromExcel;

    public static String _2399PlansFromExcel;
    public static String _2399ValidityFromExcel;
    public static String _2399BenefitsFromExcel;

    public static String _599PlansFromExcel;
    public static String _599ValidityFromExcel;
    public static String _599BenefitsFromExcel;

    public static String _444PlansFromExcel;
    public static String _444ValidityFromExcel;
    public static String _444BenefitsFromExcel;

    public static String _249PlansFromExcel;
    public static String _249ValidityFromExcel;
    public static String _249BenefitsFromExcel;

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

    @AndroidFindBy(id = "RechargePlansBuyBtn")
    private WebElement btnBuy;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[2]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl2599Plan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement lbl2599Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl2599Benefits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl2399Plan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement lbl2399Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl2399Benefits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[4]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl599Plan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement lbl599Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[4]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl599Benefits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[5]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl598Plan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[5]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl598Benefits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[5]/android.view.View[3]/android.view.View")
    private WebElement lbl598Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[6]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl444Plans;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[6]/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement lbl444Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[6]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl444Benefits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[7]/android.view.View[2]/android.view.View[2]")
    private WebElement lbl249Plan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[7]/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement lbl249Validity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.GridView/android.view.View[7]/android.view.View[4]/android.view.View/android.view.View[2]")
    private WebElement lbl249Benefits;

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

    public boolean verify2GBPerDayFirstPlansPricing() throws IOException {
        _2599PlansFromExcel = JIODataProvider.getCellData("JioPlans",2,0);
        _2599ValidityFromExcel = JIODataProvider.getCellData("JioPlans",2,1);
        _2599BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",2,2);


        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("First Plan Price : " , getText(lbl2599Plan) );
        testInfoLog("First Plan Validity : ",  getText(lbl2599Validity));
        testInfoLog("First Plan Benefits : ", getText(lbl2599Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("First plan price : " ,_2599PlansFromExcel);
        testInfoLog("First plan validity : " ,_2599ValidityFromExcel);
        testInfoLog("First Plan Benefits : ",_2599BenefitsFromExcel);

        testVerifyLog("Verify first plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl2599Plan).trim().contains(_2599PlansFromExcel.trim()) &&
                getText(lbl2599Validity).trim().contains(_2599ValidityFromExcel.trim()) &&
                getText(lbl2599Benefits).trim().contains(_2599BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDaySecondPlansPricing() throws IOException {
        _2399PlansFromExcel = JIODataProvider.getCellData("JioPlans",3,0);
        _2399ValidityFromExcel = JIODataProvider.getCellData("JioPlans",3,1);
        _2399BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",3,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Second Plan Price : " , getText(lbl2399Plan) );
        testInfoLog("Second Plan Validity : ",  getText(lbl2399Validity));
        testInfoLog("Second Plan Benefits : ", getText(lbl2399Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Second plan price : " ,_2399PlansFromExcel);
        testInfoLog("Second plan validity : " ,_2399ValidityFromExcel);
        testInfoLog("Second Plan Benefits : ",_2399BenefitsFromExcel);

        testVerifyLog("Verify Second plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl2399Plan).trim().contains(_2399PlansFromExcel.trim()) &&
                getText(lbl2399Validity).trim().contains(_2399ValidityFromExcel.trim()) &&
                getText(lbl2399Benefits).trim().contains(_2399BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayThirdPlansPricing() throws IOException {
        _599PlansFromExcel = JIODataProvider.getCellData("JioPlans",4,0);
        _599ValidityFromExcel = JIODataProvider.getCellData("JioPlans",4,1);
        _599BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",4,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Third Plan Price : " , getText(lbl599Plan) );
        testInfoLog("Third Plan Validity : ", getText(lbl599Validity));
        testInfoLog("Third Plan Benefits : ", getText(lbl599Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Third plan price : " ,_599PlansFromExcel);
        testInfoLog("Third plan validity : " ,_599ValidityFromExcel);
        testInfoLog("Third Plan Benefits : ",_599BenefitsFromExcel);

        testVerifyLog("Verify Third plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl599Plan).trim().contains(_599PlansFromExcel.trim()) &&
                getText(lbl599Validity).trim().contains(_599ValidityFromExcel.trim()) &&
                getText(lbl599Benefits).trim().contains(_599BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayForthPlansPricing() throws IOException {
        _598PlansFromExcel = JIODataProvider.getCellData("JioPlans",1,0);
        _598ValidityFromExcel = JIODataProvider.getCellData("JioPlans",1,1);
        _598BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",1,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Forth Plan Price : " , getText(lbl598Plan));
        testInfoLog("Forth Plan Validity : ", getText(lbl598Validity));
        testInfoLog("Forth Plan Benefits : ", getText(lbl598Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Forth plan price : " ,_598PlansFromExcel);
        testInfoLog("Forth plan validity : " ,_598ValidityFromExcel);
        testInfoLog("Forth Plan Benefits : ",_598BenefitsFromExcel);

        testVerifyLog("Verify Forth plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl598Plan).trim().contains(_598PlansFromExcel.trim()) &&
                getText(lbl598Validity).trim().contains(_598ValidityFromExcel.trim()) &&
                getText(lbl598Benefits).trim().contains(_598BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayFifthPlansPricing() throws IOException {
        _444PlansFromExcel = JIODataProvider.getCellData("JioPlans",5,0);
        _444ValidityFromExcel = JIODataProvider.getCellData("JioPlans",5,1);
        _444BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",5,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Fifth Plan Price : " , getText(lbl444Plans));
        testInfoLog("Fifth Plan Validity : ", getText(lbl444Validity));
        testInfoLog("Fifth Plan Benefits : ", getText(lbl444Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Fifth plan price : " ,_444PlansFromExcel);
        testInfoLog("Fifth plan validity : " ,_444ValidityFromExcel);
        testInfoLog("Fifth Plan Benefits : ",_444BenefitsFromExcel);

        testVerifyLog("Verify Fifth plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl444Plans).trim().contains(_444PlansFromExcel.trim()) &&
                getText(lbl444Validity).trim().contains(_444ValidityFromExcel.trim()) &&
                getText(lbl444Benefits).trim().contains(_444BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDaySixthPlansPricing() throws IOException {
        _249PlansFromExcel = JIODataProvider.getCellData("JioPlans",6,0);
        _249ValidityFromExcel = JIODataProvider.getCellData("JioPlans",6,1);
        _249BenefitsFromExcel= JIODataProvider.getCellData("JioPlans",6,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Sixth Plan Price : " , getText(lbl249Plan));
        testInfoLog("Sixth Plan Validity : ", getText(lbl249Validity));
        testInfoLog("Sixth Plan Benefits : ", getText(lbl249Benefits));

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Sixth plan price : " ,_249PlansFromExcel);
        testInfoLog("Sixth plan validity : " ,_249ValidityFromExcel);
        testInfoLog("Sixth Plan Benefits : ",_249BenefitsFromExcel);

        testVerifyLog("Verify Sixth plan 2GB/Day details are same on screen and excel sheet.");

        return getText(lbl249Plan).trim().contains(_249PlansFromExcel.trim()) &&
                getText(lbl249Validity).trim().contains(_249ValidityFromExcel.trim()) &&
                getText(lbl249Benefits).trim().contains(_249BenefitsFromExcel.trim());


    }
}
