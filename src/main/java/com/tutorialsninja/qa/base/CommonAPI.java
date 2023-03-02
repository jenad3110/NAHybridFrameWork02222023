package com.tutorialsninja.qa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

import static com.tutorialsninja.qa.utilities.ConfigProperties.loadProperties;

public class CommonAPI {


    public WebDriver getDriver() {
        return driver;
    }
    public static Logger log = LogManager.getLogger(CommonAPI.class.getName());


    WebDriver driver;

    Properties prop = loadProperties();
    String url = prop.getProperty("url");

    public String newCustomer = prop.getProperty("test1");
    public String ShoppingCart= prop.getProperty("test2");


    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.debug("url starting");
    }

    @AfterMethod
    public void tearUp(ITestResult result) {
       driver.quit();
    }




    public void click(WebElement element ){

        element.click();

    }






}
