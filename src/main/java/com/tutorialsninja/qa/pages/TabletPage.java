package com.tutorialsninja.qa.pages;

import com.tutorialsninja.qa.base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// void is still return type even it is not returning any value
// get current url is method that return string

public class TabletPage extends CommonAPI {

    WebDriver driver;
    public TabletPage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);
    }



@FindBy (linkText = "Samsung Galaxy Tab 10.1")
    WebElement samsungGalaxyTabText;

public void clickSamsungGalaxyTabText(){
    samsungGalaxyTabText.click();

}





}
