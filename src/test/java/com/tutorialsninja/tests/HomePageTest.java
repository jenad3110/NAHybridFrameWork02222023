package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends CommonAPI {

    @Test
    public void accessLoginPage() {

        HomePage homePage = new HomePage(getDriver());

        homePage.clickMyAccountDropDown();
        homePage.clickLoginOption();

        LoginPage loginPage = homePage.clickLoginButton() ;



        String actualResult = loginPage.loginPageAssertion();
        String expectedResult = newCustomer;
        Assert.assertEquals(actualResult, expectedResult);


    }




}
