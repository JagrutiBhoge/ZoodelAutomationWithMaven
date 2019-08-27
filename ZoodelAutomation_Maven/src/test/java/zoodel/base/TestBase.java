package zoodel.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import zoodel.objectRepository.*;
import zoodel.testdata.*;

import zoodel.utilities.*;
import zoodel.helpers.*;

public class TestBase {

	public static WebDriver driver;
	//public static HtmlUnitDriver driver1;
	public static RemoteWebDriver driver2;
	private static Logger log = Logger.getLogger(TestBase.class.getName());
	//private static Logger log = Logger.getLogger("devpinoyLogger");
	public static enum_language lang;
	
	// ========================= pageControls objects =========================
	public static PageControls_Common pageControlsCommon = new PageControls_Common();
	public static PageControls_Login pageControlsLogin = new PageControls_Login();
	public static PageControls_Search pageControlsSearch = new PageControls_Search();
	public static PageControls_StaticPages pageControlsStaticPages = new PageControls_StaticPages();
	public static PageControls_AllPopups pageControlAllPopups = new PageControls_AllPopups();
	public static PageControls_HomePage pageControlsHomePage = new PageControls_HomePage();
	public static PageControls_AddProduct pageControlsAddProduct = new PageControls_AddProduct();

	// ========================= pageMethods objects =========================
	public static Page_Methods pageMethods = new Page_Methods();
	public static Framework_Methods frameworkMethods = new Framework_Methods();
	public static PageMethod_SearchPage pageMethodSearchPage = new PageMethod_SearchPage();
	
	// ========================= pageTest data objects =========================
	public static TestData_Common testDataCommon = new TestData_Common();
	public static TestData_Login testDataLogin = new TestData_Login();
	//=========== Common ======================
	public TestUtilityHelper testUtilityHelper = new TestUtilityHelper();

	// @BeforeSuite annotation describes this method has to run before all
	// suites
	@BeforeSuite
	public void setUpForScript() throws Exception {
		log.info("Delete file for screenshot folder.");
		pageMethods.deleteFileInFolder();
		Thread.sleep(3000);
	}

	// Use Test Initialize to run code before running each test
	@BeforeTest(alwaysRun = true)
	@Parameters({ "browser", "language" })
	public void openBrowser(@Optional String strBrowser, @Optional String strLang) throws Exception {
		log.info(" Open the browser.");
		if (strBrowser == null) {
			strBrowser = "chrome";
		}
		getBrowser(strBrowser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info(" Maximize the browser.");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		log.info("Open URL function.");
		OpenUrl(testDataCommon.url_staging);
		Thread.sleep(5000);
		/*log.info("Close adverting popup when advertising popup is  display on screen.");
		//pageMethods.closeAdvertisingPopup();
		Thread.sleep(3000);
		log.info("Language selection");
	
		if (strLang == null) {
			strLang = "en";
		}
		lang = getEnum_Language(strLang);
		System.out.println("Language :--" + lang);
		Thread.sleep(2000);
		
		log.info("Select language from public side");
		pageMethods.LanguageSelectionInPublic();
		Thread.sleep(3000);*/
		
	}

	// Use TestCleanup to run code after each test has run
	@AfterTest(alwaysRun = true)
	public void closeBrowser() throws Exception {
		if (driver != null) {
			log.info("Close the browser.");
			driver.quit();
			Thread.sleep(1000);
		}

	}

	public void OpenUrl(String Url) throws Exception {
		log.info("Open the URL." + Url);
		// driver.get(Url);
		driver.navigate().to(Url);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Select browser
	public static WebDriver getBrowser(String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			return driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./FirefoxDriver/geckodriver-v0.17.0-win32/geckodriver.exe");
			Thread.sleep(2000);
			return driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities1 = DesiredCapabilities.internetExplorer();
			// Method and Description - void setCapability(java.lang.String
			// capabilityName, boolean value)
			//capabilities1.setCapability("nativeEvents", false);    
			//capabilities1.setCapability("unexpectedAlertBehaviour", "accept");
			//capabilities1.setCapability("ignoreProtectedModeSettings", true);
			//capabilities1.setCapability("disable-popup-blocking", true);
			//capabilities1.setCapability("enablePersistentHover", true);

			capabilities1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities1.setJavascriptEnabled(true);
			capabilities1.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			capabilities1.setCapability("version", "11");
			capabilities1.setCapability("ie.fileUploadDialogTimeout", 10000);
			capabilities1.setCapability("platform", Platform.WIN10);
			// capabilities1.setCapability("video", "True");
			// capabilities1.setCapability("requireWindowFocus", true);
			
			// Among the facilities provided by the System class are standard
			// input, standard output, and error output streams; access to
			// externally defined "properties"; a means of loading files and
			// libraries; and a utility method for quickly copying a portion of
			// an array.
			System.setProperty("webdriver.ie.driver", "./IEDriver/IEDriverServer.exe");
			// InternetExplorerDriver(Capabilities capabilities)
			// driver2.setFileDetector(new LocalFileDetector());
			// driver = driver2;
			return driver = new InternetExplorerDriver(capabilities1);
		
		} else if (browserName.equalsIgnoreCase("edge")) {
			Thread.sleep(2000);
			System.setProperty("webdriver.edge.driver", "./edgeDriver/MicrosoftWebDriver.exe");
			EdgeOptions option = new EdgeOptions();
			option.setPageLoadStrategy("eager");
			driver = new EdgeDriver(option);
			return driver;
		} else {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			return driver = new ChromeDriver();
		}
	}

	// Select enum language language
	public static enum_language getEnum_Language(String strlLang) {
		if (strlLang.equalsIgnoreCase("en")) {
			lang = enum_language.en;
		} else if (strlLang.equalsIgnoreCase("fa")) {
			lang = enum_language.fa;
		} else if (strlLang.equalsIgnoreCase("tr")) {
			lang = enum_language.tr;
		} else if (strlLang.equalsIgnoreCase("ru")) {
			lang = enum_language.ru;
		} else if (strlLang.equalsIgnoreCase("ar")) {
			lang = enum_language.ar;
		} else if (strlLang.equalsIgnoreCase("cn")) {
			lang = enum_language.cn;
		}
		return lang;
	}

}
