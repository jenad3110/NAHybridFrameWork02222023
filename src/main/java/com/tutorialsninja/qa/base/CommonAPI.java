package com.tutorialsninja.qa.base;

import com.tutorialsninja.qa.utilities.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static com.tutorialsninja.qa.utilities.ConfigProperties.loadDataTestProperties;
import static com.tutorialsninja.qa.utilities.ConfigProperties.loadProperties;

public class CommonAPI {


    /**  Log4J setup **/

    public static Logger log = LogManager.getLogger(CommonAPI.class.getName());

    /** get data from Config.Properties file **/

    public Properties dataProp = loadDataTestProperties();
    Properties prop = loadProperties();
    String url = prop.getProperty("url");
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");
    String saucelabsUsername = prop.getProperty("saucelabs.username");
    String saucelabsPassword = prop.getProperty("saucelabs.password");

    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Parameters({"useCloudEnv", "envName", "os", "osVersion", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(String useCloudEnv, String envName, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {

        if (useCloudEnv.equalsIgnoreCase("true")) {
            initializeCloudDriver(envName, os, osVersion, browserName, browserVersion);

        } else {
            initializeLocalDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.debug("url starting");
    }


    public void initializeCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {

        log.debug("Cloud environment is used");
        if (envName.equalsIgnoreCase("browserstack")) {
            log.debug("browser stack is selected");
            getCloudDriver(envName, Utility.decode(browserstackUsername), Utility.decode(browserstackPassword), os, osVersion, browserName, browserVersion);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            getCloudDriver(envName, saucelabsUsername, saucelabsPassword, os, osVersion, browserName, browserVersion);
        }

    }

    public void getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey + "@ondemand.saucelabs.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
        }
    }

    public void initializeLocalDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearUp(ITestResult result) {
        if (result.getStatus() == result.FAILURE) {
            new Utility(getDriver()).ScreenShot(result);
        }
        driver.quit();
    }


    public void click(WebElement element) {

        element.click();

    }

    public void ScrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");


    }

}
