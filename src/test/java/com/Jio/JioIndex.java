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
    public void jioTestScenario(String contactNo){

        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("Jio_TestScenario :: To verify user can login into jio application, verify dashboard, current jio plan and " +
                "perform recharge for a friend.");

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

//        jioIndexPage.permissions();

      //  pause(5);







        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");

    }

}
