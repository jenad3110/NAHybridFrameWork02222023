package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath="//span[text()='Checkout']")
    WebElement checkoutButton;
    @FindBy(xpath = "//a[text()='My Account']")
    WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    WebElement loginOption;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void clickMyAccountDropDown() {

        myAccountDropdown.click();
    }

    public void clickLoginOption() {

        loginOption.click();
    }

    public LoginPage clickLoginButton(){

        loginOption.click();


        return new LoginPage(driver);
    }


    public CheckOutPage clickCheckOutButton(){

        checkoutButton.click();

        return new CheckOutPage(driver);
    }



}
