package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.utilities.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners extends CommonAPI implements ITestListener {
    WebDriver driver;
    ExtentReports extentReport;
    ExtentTest extentTest;


    @Override
    public void onTestStart(ITestResult  ITestResult) {
       extentReport = ExtentReporter.getExtentReport();


//        extentTest = extentReport.createTest(result.getName()+" execution started");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
