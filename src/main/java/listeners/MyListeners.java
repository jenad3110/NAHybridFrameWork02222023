package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
    public void onTestStart(ITestResult  iTestResult) {


        extentTest = extentReport.createTest(iTestResult.getName()+" execution started");
        extentTest.log(Status.INFO, iTestResult.getName() + " Started Executing");



    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS, iTestResult.getName() + " Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        extentTest.log(Status.FAIL, iTestResult.getName() + " Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        extentTest.log(Status.SKIP, iTestResult.getName() + " Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        extentReport = ExtentReporter.getExtentReport();

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReport.flush();

    }
}
