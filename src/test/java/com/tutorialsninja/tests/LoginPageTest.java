package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {


    @Test
    public void enterUserNameAndPassword() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickMyAccountDropDown();
        homePage.clickLoginOption();

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.emailAddressTextFieldNacersWay("arun.selenium@gmail.com");
        loginPage.passwordField().sendKeys("Second@123");
        loginPage.loginButton().click();

    }
}
