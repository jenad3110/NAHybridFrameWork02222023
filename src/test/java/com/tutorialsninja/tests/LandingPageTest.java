package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.LandingPage;
import com.tutorialsninja.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends CommonAPI {


    @Test
    public void test() {

        Assert.fail();

    }

    @Test
    public void accessLoginPage() {

        LandingPage homePage = new LandingPage(getDriver());
        homePage.clickMyAccountDropDown();
        homePage.clickLoginOption();
        LoginPage loginPage = homePage.clickLoginButton();
        String actualResult = loginPage.loginPageAssertion();
        String expectedResult = dataProp.getProperty("test1");
        Assert.assertEquals(actualResult, expectedResult);


    }
}
