package zoodel.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.relevantcodes.extentreports.LogStatus;

import zoodel.base.TestBase;
//import zoodel.utilities.MonitoringMail;
//import zoodel.utilities.TestConfig;
import zoodel.utilities.TestUtilityHelper;

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Inside Test Start");
		//extenttest = extentreport.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Inside Test Success");
		//extenttest.log(LogStatus.PASS, result.getName().toUpperCase()+ " PASSED.");
		//extentreport.endTest(extenttest);
		//extentreport.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		TestUtilityHelper.captureScreenshot(driver, result.getName());
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+System.getProperty("user.dir")+"/Screenshots/"+result.getName() +".png >Screenshot for fail Test</a>");
		//Reporter.log("<a target=\"_blank\" href=\"././Screenshots/"+result.getName() +".png\">Screenshot for fail Test</a>");
		System.out.println(result.getName());
		Reporter.log("<br>");
		Reporter.log("<br>");
		//Reporter.log("<a target=\"_blank\" href=\"././Screenshots/"+result.getName()+".png\"><img src=\"././Screenshots/"+result.getName()+".png\" height=200 width=200></img></a>");
		Reporter.log("<a target=\"_blank\" href="+System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png><img src="+System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png height=200 width=200></img></a>");
		
		//extenttest.log(LogStatus.FAIL, result.getName().toUpperCase()+ " FAILED.");
		//extenttest.log(LogStatus.FAIL, extenttest.addScreenCapture(TestUtil.screenshotName));
		//extentreport.endTest(extenttest);
		//extentreport.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtilityHelper.captureScreenshot(driver, result.getName());
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=\"./Screenshots/"+result.getName() +".png\">Screenshot for Skip Test</a>");
		System.out.println(result.getName());
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"./Screenshots/"+result.getName()+".png\"><img src=\"./Screenshots/"+result.getName()+".png\" height=200 width=200></img></a>");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		String hostName = "";
		String messageBody = "";
		try {
			hostName = InetAddress.getLocalHost().getHostAddress();
			messageBody = "http://"+ hostName + ":8080/job/DataDrivenLiveProject/Extent_20Report/";
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* MonitoringMail mail = new MonitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		
	}

}
