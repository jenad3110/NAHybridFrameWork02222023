package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {


    public CheckOutPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement ShoppingCart;


}
