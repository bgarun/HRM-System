package com.HRMSystem.Generic_Libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
	Java_Utilities ja=new Java_Utilities();
	ExtentReports repo;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = repo.createTest(MethodName);
		Reporter.log(MethodName+"==Testscript execution Started==");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"==Passed");
		Reporter.log(MethodName+"==Script Executed successfully==");
	}

	public void onTestFailure(ITestResult result) {
		String Failedscript = result.getMethod().getMethodName();
		
		String date = Failedscript+new Java_Utilities().getSystemDateInFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"==Script Skipped==");
		
	}

	public void onStart(ITestContext context) {
		
		//Execution Start here
		//Configure the report
		ExtentSparkReporter report = new ExtentSparkReporter("./ExtentReport/report.html");
		report.config().setDocumentTitle("HRM System Excecution Report");
		report.config().setTheme(Theme.STANDARD);
		report.config().setReportName("HRM Excecution Report");
		
		  repo = new ExtentReports();
		 repo.attachReporter(report);
		 repo.setSystemInfo("Base_Browser", "Chrome");
		 repo.setSystemInfo("OS", "WIN 10");
		 repo.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/HRM_System/");
		 repo.setSystemInfo("Reporter_Name", "Arunkumar");
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameters and generate the report
		repo.flush();
	}

	
	
	
	
}
