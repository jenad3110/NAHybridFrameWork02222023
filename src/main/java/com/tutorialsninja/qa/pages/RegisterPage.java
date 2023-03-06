package com.tutorialsninja.qa.pages;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.properties.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonAPI {


    @FindBy(name = "email")
    WebElement emailField;


    public RegisterPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    public void enterEmail() {

        Test test = new Test();
        emailField.sendKeys(test.generateEmailsWithCurrentTime());


    }


}
