package com.prestashop.tests.base.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.prestashop.core.utils.DateTimeUtil;

import java.io.File;

public class ExtentReportsUtil {

    public static ExtentReports getInstance(){
        String reportName = DateTimeUtil.generateTimeStamp("report") + ".html";
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
}
