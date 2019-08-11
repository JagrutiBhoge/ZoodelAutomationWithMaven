package zoodel.testcase;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zoodel.base.TestBase;
import zoodel.testdata.*;


public class TestCase_Login extends TestBase {
	private static final Logger log = Logger.getLogger(TestCase_Login.class.getName());
	// define an Excel Work Book
	HSSFWorkbook workbook;
	// define an Excel Work sheet
	HSSFSheet sheet;
	
	// define a test result data object
	public Map<String, Object[]> testresultdata;

	@BeforeClass(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) {

		// create a new work book
		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("Test Result");
		testresultdata = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		testresultdata.put("1", new Object[] { "Test Step Id", "Action", "Expected Result", "Actual Result" });
	}

	// It will execute before every test execution
	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeMethodInitialization() throws Exception {
		log.info("Close adverting popup when advertising popup is  display on screen.");
		pageMethods.closeAdvertisingPopup();
		Thread.sleep(3000);
	}

	// It will execute after every test execution
	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus() || ITestResult.SKIP == result.getStatus()) {
			testUtilityHelper.captureScreenshot(driver, result.getName());
		}

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void userSuccessfullyLoggedIn() throws Exception {
		Thread.sleep(1000);
		log.info("Call login function.");
		pageMethods.loggedIn(testDataLogin.userEmail, testDataLogin.userPassword);
		Thread.sleep(1000);
		// driver.navigate().refresh();
		Assert.fail("User is not login sucessfully");
		Thread.sleep(1000);
		log.info("Verify the user is login.");
		boolean result = driver.findElement(pageControlsLogin.loginName).isDisplayed();
		// frameworkMethods.IsPresentLocator(pageControlsLogin.loginName);
		Assert.assertEquals(result, true, "User does not logged In.");
	
	}

	//@Test(priority = 2, groups = { "Smoke" })
	public void userSuccessfullyLoggedOut() throws Exception {
		pageMethods.loggedOut();
		Thread.sleep(2000);
		log.info("Verify the user is logged out.");
		Assert.assertEquals(frameworkMethods.IsPresentLocator(pageControlsLogin.lnkLogin), true,
				"User does not logged out.");

	}

	//@Test(priority = 3, groups = { "Regression" })
	public void userInvalidLoginAttempt() throws Exception {
		Thread.sleep(3000);
		pageMethods.loggedIn(testDataLogin.invalidEmailInLogin, "password");
		frameworkMethods.waitTillElementAppears(pageControlsCommon.errorMessage);
		log.info("Verify Invalid login message....");
		Assert.assertEquals(frameworkMethods.get_LableText(pageControlsCommon.errorMessage),
				enum_validationMessage.invalidLogin.getValue(lang), "Invalid login message does not match...");

	}

	// Verify enter key is working or not
	//@Test(priority = 4, groups = { "Regression" })
	public void verifyLoginWithEnterKey() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(5000);

		log.info("Click on login link.");
		frameworkMethods.clickOnLink(pageControlsLogin.lnkLogin);
		Thread.sleep(2000);
		log.info("Enter the email id." + testDataLogin.userEmail);
		frameworkMethods.clear_Text(pageControlsLogin.txtEmail);
		frameworkMethods.enter_Text(pageControlsLogin.txtEmail, testDataLogin.userEmail);
		Thread.sleep(3000);
		log.info("Enter the password." + testDataLogin.userPassword);
		frameworkMethods.clear_Text(pageControlsLogin.txtPassword);
		frameworkMethods.enter_Text(pageControlsLogin.txtPassword, testDataLogin.userPassword);
		Thread.sleep(2000);
		log.info("Login with Enter Key.");
		driver.findElement(pageControlsLogin.btnLogin).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		log.info("Verify the user is login.");
		boolean _result = frameworkMethods.IsPresentLocator(pageControlsLogin.loginName);
		Assert.assertEquals(_result, true, "Enter Key does not work..");

	}

	

}
