
package zoodel.testcase;

import java.lang.reflect.Method;
import java.util.Arrays;
// 
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import zoodel.base.TestBase;
import zoodel.testdata.enum_staticPage;
import zoodel.utilities.TestUtilityHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase_HomePageLink extends TestBase {

	public static final Logger log = Logger.getLogger(TestCase_HomePageLink.class.getName());

	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeMethodInitialization(Method m) throws Exception {

		test = extent.createTest(m.getName());

		Thread.sleep(2000);
		log.info("Click on Logo .");
		frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");

			String failureLogg = "TEST CASE FAILED";
			Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			test.log(Status.FAIL, m);
			

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  SKIPPED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.skip(m);
			test.skip(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);

		}

	}

	@Test(dataProviderClass = TestUtilityHelper.class, dataProvider = "Link", enabled = false)
	public void CheckTitleOfHomePageLink(Hashtable<String, String> data) throws Exception {
		// test = extent.createTest("HOme page Title");
		SoftAssert sa = new SoftAssert();
		log.info("Click on link");
		log.debug("Click on menu linksssssssssss");
		driver.findElement(By.linkText(data.get("Link"))).click();
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectTitle = data.get("Title");
		log.debug("Actual Title: " + actualTitle);

		System.out.println("Title :" + actualTitle);
		Thread.sleep(1000);

		Assert.assertEquals(expectTitle, actualTitle, "Title is not matching.");
		// sa.assertEquals(expectTitle, actualTitle,"Title is not match");
		// sa.assertAll();

	}

	@Test(dataProviderClass = TestUtilityHelper.class, dataProvider = "Link", enabled = false)
	public void CheckTitleOfHomePageLink2(Hashtable<String, String> data) throws Exception {

		SoftAssert sa = new SoftAssert();
		log.info("Click on link");
		log.debug("Click on menu linksssssssssss");
		driver.findElement(By.linkText(data.get("Link"))).click();
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectTitle = data.get("Title");
		log.debug("Actual Title: " + actualTitle);

		System.out.println("Title :" + actualTitle);
		Thread.sleep(1000);

		Assert.assertEquals(expectTitle, actualTitle, "Title is not matching.");
		// sa.assertEquals(expectTitle, actualTitle,"Title is not match");
		// sa.assertAll();

	}

	@Test(dataProviderClass = TestUtilityHelper.class, dataProvider = "staticLink", enabled = false)
	public void CheckStaticLinks(Hashtable<String, String> data) throws Exception {
		test = extent.createTest("Static links");
		Thread.sleep(1000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		Thread.sleep(3000);
		log.info("=========Footer Link====================");
		log.info("Click on link.");
		System.out.println(data.get("Expected Data"));
		// frameworkMethods.clickOnLink(By.linkText(data.get("staticLink")));
		driver.findElement(By.linkText(data.get("Expected Data"))).click();
		Thread.sleep(4000);
		log.info("Get page title .");

		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, data.get("Expected Data"), "" + data.get("Expected Data") + " page is not open");

		Thread.sleep(4000);

	}

	// @Test
	public void SoftAssertTest() throws Exception {
		SoftAssert sa = new SoftAssert();
		System.out.println("Click on link");
		System.out.println("Before assert false");

		sa.assertFalse(false, "1st failure incedent");
		System.out.println("After Assert False");

		System.out.println("Before 2nd Assert False");
		sa.assertFalse(true, "2nd failure incedent");
		System.out.println("After 2nd Assert False");

		// sa.assertEquals(expectTitle, actualTitle,"Title is not match");
		sa.assertAll();

		System.out.println("Before 3rd Assert False");
		sa.assertFalse(true, "3rd failure incedent");
		System.out.println("After 3rd Assert False");

	}

	@Test
	public void checkBackground() throws Exception
	{
		
		String textColor = driver.findElement(By.xpath("//section[@id = 'features']//h2/span")).getCssValue("color");
	    String bkgColor = driver.findElement(By.xpath("//footer[@id='newFooter']")).getCssValue("background-color");
	    System.out.println("TextColor : " + textColor );
	    System.out.println("Background Color : " + bkgColor);
	}

}
