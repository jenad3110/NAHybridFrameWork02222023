package com.tutorialsninja.qa.utilities;

import com.tutorialsninja.qa.base.CommonAPI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class Utility extends CommonAPI {

    WebDriver driver;

    public Utility(WebDriver driver){

        this.driver=driver;
    }


    public  void ScreenShot(ITestResult result) {
        String name = result.getName();
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmmssa");
        Date date = new Date();
        df.format(date);
        File file;


                  file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/failedTests/" + name + " " + df.format(date) + ".jpeg"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
