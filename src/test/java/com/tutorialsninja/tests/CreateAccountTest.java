package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.CreateAccountPage;
import com.tutorialsninja.qa.pages.LandingPage;
import com.tutorialsninja.qa.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class CreateAccountTest extends CommonAPI {

    @Test
    public void CreateAccountUsingDataFromDataBase() throws InterruptedException, SQLException, IOException, ClassNotFoundException {


        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.myAccountDropdown().click();
        landingPage.loginOption().click();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.continueButton().click();

        Thread.sleep(3000);

        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        createAccountPage.enterFirstName("");
//       createAccountPage.enterFirstNameFromDB();
//       createAccountPage.enterLastNameFromDB();
//       createAccountPage.enterTelephoneFromDB();


    }
}
