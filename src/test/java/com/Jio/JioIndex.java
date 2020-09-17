package com.Jio;

import com.utils.JIODataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Rutu Shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: JIO_ANDROID_POC
 */

public class JioIndex extends JIODataProvider {

    @Test(dataProvider = "Jio")
    public void verifyLogin_currentPlan_rechargeForFriend(String contactNo){

        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("TS_MOB_001 :: To verify user can login into jio application, verify dashboard, current jio plan and perform recharge for a friend.");

        pause(2);

        jioIndexPage.skipIntroduction();

        testVerifyLog("Verify user can see Home Screen of \"Jio Application \" with following fields" +
                "<br> 1. Mobile Tab." +
                "<br> 2. JioFiber Tab." +
                "<br> 3. Jiofi Tab. " +
                "<br> 4. JioLink Tab." +
                "<br> 5. Enter mobile number text field." +
                "<br> 6. Generate OTP button." +
                "<br> 7. Login with QR." +
                "<br> 8. Not a jio user Button.");
        if (jioVerification.verifyJioHomeScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.enterMobileNumber(contactNo);

        jioVerification = jioIndexPage.clickOnGenerateOTPButton();

       // jioIndexPage.getOTPFromNotification();

//        jioIndexPage.permissions();

        pause(5);

        jioVerification = jioIndexPage.clickOnCloseNews();

        testVerifyLog("4. Verify user is redirected to dashboard of My jio application after successful login.\n.");
        if (jioVerification.verifyDashboardScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnTeleComTab();

        testVerifyLog("Verify user can see telecom tab screen.");
        if (jioVerification.verifyTelecomScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.getDetailsOfCurrentPlan();

        jioVerification = jioIndexPage.clickOnCurrentPlan();

        testVerifyLog("Verify current plan screen with its details present.");
        if (jioVerification.verifyCurrentPlanScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnBackButton();

        testVerifyLog("Verify user is redirected to telecom screen, after user clicks on back button from current plan screen.");
        if (jioVerification.verifyTelecomScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnMenuButton();

        testVerifyLog("Verify user can see Menu Screen.");
        if (jioVerification.verifyMenuScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnRechargeForFriendButton();

        testVerifyLog("Verify user can see recharge for a friend screen.");
        if (jioVerification.verifyRechargeForFriendScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.enterInvalidMobileNumber();

        jioVerification = jioIndexPage.clickOnProceedButton();

        testVerifyLog("Verify user can see validation message for \"Please enter a valid Jio Number\"");
        if (jioVerification.verifyInvalidNumberValidation()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnBackButtonFromRechargeFriendScreen();

        jioVerification = jioIndexPage.clickOnMenuButton();

        jioVerification = jioIndexPage.clickOnSettings();

        jioVerification = jioIndexPage.clickOnLogoutButton();

        testVerifyLog("Verify user can see Logout Popup.");
        if (jioVerification.verifyLogoutPopup()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        jioVerification = jioIndexPage.clickOnYesButton();

        testVerifyLog("Verify user is logged out successfully.");
        if (jioVerification.verifyJioHomeScreen()){
            stepPassed();
        }else {
            stepFailure(androidDriver);
            numOfFailedSteps++;
        }

        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");

    }

}
