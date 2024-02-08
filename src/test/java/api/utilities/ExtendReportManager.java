package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtendReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
        repName = "Test-Report-" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);//Specify the location of the report

        sparkReporter.config().setDocumentTitle("RestAssureedAutomationProject");//Title of report
        sparkReporter.config().setReportName("Petstore USER API");//Name of report
        sparkReporter.config().setTheme(Theme.DARK);//Title of report

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Pet Store USer API");
        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","testuser");

    }
//    public void onTestSuccess(ITestListener result)
//    {
//        test=extent.createTest(result.getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.createNode(result.getName());
//        test.log(Status.PASS, "Test Passed");
//    }

    public  void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
    }
    public void onTestSkiped(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }
    public void onFinish(ITestResult testContext)
    {
        extent.flush();
    }
}

