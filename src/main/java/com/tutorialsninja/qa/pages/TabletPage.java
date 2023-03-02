package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletPage {
    WebDriver driver;
    @FindBy ( linkText = "Tablets")
    WebElement tabletButton;
    public TabletPage(WebDriver driver){
        driver.getTitle();
        driver.getCurrentUrl();
        driver.findElement(By.linkText("Tablets")).click();
    }

}
