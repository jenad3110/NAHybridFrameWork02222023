package com.tutorialsninja.qa.pages;

import connectExternalData.database.ConnectToSQL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.SQLException;

public class CreateAccountPage {

    WebDriver driver;


    ConnectToSQL connect = new ConnectToSQL();
    @FindBy(name = "firstname")
    WebElement firstNameField;
    @FindBy(name = "lastname")
    WebElement lastNameField;
    @FindBy(name = "telephone")
    WebElement telephoneField;

    public CreateAccountPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void enterFirstName(String s) throws SQLException, IOException, ClassNotFoundException {

        firstNameField.sendKeys(s);

        connect.executeQueries("INSERT INTO login (FirstName) VALUES ('" + s + "');");
    }


    public void enterFirstNameFromDB() throws SQLException, IOException, ClassNotFoundException {

        firstNameField.sendKeys(connect.selectQueries("login", "FirstName"));
    }

    public void enterLastNameFromDB() throws SQLException, IOException, ClassNotFoundException {

        lastNameField.sendKeys(connect.selectQueries("login", "LastName"));

    }

    public void enterTelephoneFromDB() throws SQLException, IOException, ClassNotFoundException {

        telephoneField.sendKeys(connect.selectQueries("login", "Telephone"));

    }


}
