package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/h2")
    WebElement newCostumer;



    @FindBy(id = "input-email")
    WebElement emailAddressTextField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(css = "input[value='Login']")
    WebElement loginButton;

    @FindBy (linkText = "Continue")
    WebElement continueButton;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

//    public WebElement emailAddressTextField() {
//
//        return emailAddressTextField;
//    }

    public void emailAddressTextFieldNacersWay(String Text) {
        emailAddressTextField.sendKeys(Text);
    }


    public WebElement passwordField() {

        return passwordField;

    }

    public WebElement loginButton() {

        return loginButton;
    }

    public String loginPageAssertion() {

        return newCostumer.getText();
    }

    public WebElement continueButton() {

        return continueButton;
    }


}
