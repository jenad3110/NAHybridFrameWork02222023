package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.LandingPage;
import com.tutorialsninja.qa.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterPageTest extends CommonAPI {


    @Test
    public void enterEmail() throws InterruptedException {

        LandingPage homePage = new LandingPage(getDriver());
        homePage.clickMyAccountDropDown();
        homePage.clickRegisterOption();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.enterEmail();
        Thread.sleep(10000);



    }










}
