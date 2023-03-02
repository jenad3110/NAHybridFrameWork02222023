package com.tutorialsninja.qa.base;

import com.tutorialsninja.qa.config.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonAPI {


    public WebDriver getDriver() {
        return driver;
    }

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
    }

    @AfterMethod
    public void tearUp(ITestResult result) {
       // driver.quit();
    }


    public static  Properties loadProperties() {

        Properties config = new Properties();

                try {
                    FileInputStream fis = new FileInputStream("C:\\Users\\sron4\\Downloads\\HybridFrameWork02222023\\src\\test\\resources\\Properties\\Config.Properties");
                    config.load(fis);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



        return config;
    }

    public void click(WebElement element ){

        element.click();

    }






}
