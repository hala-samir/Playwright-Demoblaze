package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.demoblaze.PlaywrightFactory.takeScreenshot;

public class ExtentReportListener implements ITestListener {
    private static final String OUTPUT_FOLDER = "./reports";
    private static final String REPORT_FILE_NAME = "HTML-ExecutionReport.html";

    private static ExtentReports extent = init();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static ExtentReports init(){
        Path path = Paths.get(OUTPUT_FOLDER);
        if(!Files.exists(path)){
            try{
                Files.createDirectories(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        // Define the report file path
        String reportFilePath = OUTPUT_FOLDER + "/" + REPORT_FILE_NAME;

        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);

        // Configure the report
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Extent Report Example");
        sparkReporter.config().setTheme(Theme.DARK);

        // Attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system/environment details
        extent.setSystemInfo("Tester", "Hala Samir");
        extent.setSystemInfo("Environment", "QA Env.");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        return extent;
    }

    // Initialize ExtentReports
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution has started!");
    }

    // Close ExtentReports
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution has finished!");
        extent.flush(); // Write everything to the report
    }

    // When a test case starts
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    // When a test case passes
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    // When a test case fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + "Failed!!");
        test.get().fail("Test Failed: " + result.getThrowable());
        // Optionally, add a screenshot to the report
        test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
    }

    // When a test case is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped: " + result.getThrowable());
        test.get().skip(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
    }

    // When a test case is partially successful (not common but TestNG supports it)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.get().warning("Test Partially Passed");
    }
}
