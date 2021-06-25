package com.prestashop.tests.base.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.prestashop.core.utils.DateTimeUtil;
import org.testng.ITestResult;

import java.util.Arrays;

public class ExtentReportsUtil {

    private static final String REPORT_EXTENSION = ".html";

    public static ExtentReports getInstance(){
        String reportName = DateTimeUtil.generateTimeStamp("report") + REPORT_EXTENSION;
        String reportPath = System.getProperty("user.dir") + "\\output\\reports\\" + reportName;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Prestashop Reports");
        sparkReporter.config().setDocumentTitle("Prestashop Test Reports");
        sparkReporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports = new ExtentReports();
        extentReports.setSystemInfo("Organization", "JetBrains");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.attachReporter(sparkReporter);

        return extentReports;
    }

    public static Markup getTestPassedSuccessfullyMarkup(ITestResult iTestResult) {
        String extentLogMessage = "<b>Test " + iTestResult.getMethod().getMethodName() + " passed successfully.</b>";
        return MarkupHelper.createLabel(extentLogMessage, ExtentColor.GREEN);
    }

    public static Markup getTestSkippedMarkup(ITestResult iTestResult) {
        String extentLogMessage = "<b>Test " + iTestResult.getMethod().getMethodName() + " skipped.</b>";
        return MarkupHelper.createLabel(extentLogMessage, ExtentColor.ORANGE);
    }

    public static String getTestFailMessageForExtentReport(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        String exceptionMessage = iTestResult.getThrowable().getMessage();
        String exceptionStackTrace = Arrays.toString(iTestResult.getThrowable().getStackTrace()).replaceAll(",", "<br>");
        return "<details>" +
                    "<summary><b><font color=red>Test failed. Click to see details.</font></b></summary>" +
                    exceptionMessage +
                    "<details>" +
                        "<summary><b><font color=orange>Click to see StackTrace.</font></b></summary>" +
                        exceptionStackTrace +
                    "</details>" +
                "</details> \n";
    }
}
