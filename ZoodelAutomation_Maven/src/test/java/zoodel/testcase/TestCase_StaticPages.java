package zoodel.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zoodel.base.*;
import zoodel.testdata.*;

public class TestCase_StaticPages extends TestBase {
	private static final Logger log = Logger.getLogger(TestCase_StaticPages.class.getName());

	// It will execute before every test execution
	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeMethodInitialization() throws Exception {
		log.info("Close adverting popup when advertising popup is  display on screen.");
		pageMethods.closeAdvertisingPopup();
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		log.info("Click on Logo .");
		frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
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

	// Use ClassCleanup to run code after all tests in a class have run
	@AfterClass(alwaysRun = true)
	public static void cleanUpAfterClass() throws Exception {
		log.info("Scroll UP");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();

	}

	// ========== Header static link===================

	// Verify about us link is working or not;
	@Test(priority = 1, groups = { "Smoke" })
	public void aboutusHeaderLink() throws Exception {
		Thread.sleep(5000);
		log.info("=========Header Link====================");
		log.info("Click on about us link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkAboutusHeader);
		Thread.sleep(4000);
		log.info("Get page title .");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.aboutUsTitle.getValue(lang), "About us page is not open");
		Thread.sleep(4000);
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify Create Your Web store link is working or not (without login)
	@Test(priority = 2, groups = { "Smoke" })
	public void createYourWebstoreWithoutLoginInHeaderLink() throws Exception {
		Thread.sleep(2000);
		log.info("Click on drop down");
		frameworkMethods.clickOnLink(pageControlsStaticPages.ddlSeller);

		Thread.sleep(2000);
		log.info("Click on Create Your Webstore link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkCreateWebStore);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.btnCreateYourWebstoreNow);
		Assert.assertEquals(strlLabel, enum_staticPage.createYourWebstoreNOW.getValue(lang),
				"Create Your Webstore Now page is not open");
		Thread.sleep(4000);
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.click_On_Button(pageControlsStaticPages.logo);
		 */
	}

	// Verify Post Your Products Free link is working or not
	@Test(priority = 3, groups = { "Smoke" })
	public void postYourProductsFreeHeaderLink() throws Exception {
		Thread.sleep(2000);
		log.info("Click on drop down");
		frameworkMethods.clickOnLink(pageControlsStaticPages.ddlSeller);
		log.info("Click on Post your product free link.");
		Thread.sleep(2000);
		frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkPostYourProductFree);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblListYourProduct);
		Assert.assertEquals(strlLabel, enum_staticPage.postYourProductsFree.getValue(lang),
				"Post Your Products Free page is not open");
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify Post Your Products Free link is working or not
	@Test(priority = 4, groups = { "Smoke" })
	public void ViewTendersWithoutLoginInHeaderLink() throws Exception {
		frameworkMethods.waitTillElementAppears(pageControlsStaticPages.ddlSeller);
		log.info("Click on drop down");
		frameworkMethods.clickOnLink(pageControlsStaticPages.ddlSeller);
		Thread.sleep(2000);
		log.info("Click on View tenders link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkViewTenders);
		// Thread.sleep(5000);
		frameworkMethods.waitTillElementAppears(pageControlsStaticPages.tenderBreadCum);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tenderBreadCum);
		Assert.assertEquals(strlLabel, enum_staticPage.tenders.getValue(lang), "View tender page is not open");
		Thread.sleep(2000);
	}

	// Verify Contact us link is working or not;
	@Test(priority = 5, groups = { "Smoke" })
	public void ContactusHeaderLink() throws Exception {
		Thread.sleep(5000);
		log.info("Click on Contact us link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkContactUs);
		Thread.sleep(4000);
		log.info("Get page title .");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblContactUs);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.contactUsTitle.getValue(lang), "Contact us page is not open");
		Thread.sleep(2000);
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify login link is working or not;
	@Test(priority = 6, groups = { "Smoke" })
	public void LoginHeaderLink() throws Exception {
		try {
			Thread.sleep(5000);
			log.info("Click on Login link.");
			frameworkMethods.clickOnLink(pageControlsLogin.lnkLogin);
			Thread.sleep(4000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Login popup is not open");

		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// Verify Register link is working or not;
	@Test(priority = 7, groups = { "Smoke" })
	public void RegisterHeaderLink() throws Exception {
		Thread.sleep(5000);
		try {
			log.info("Click on Register link.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.hrLnkRegister);
			Thread.sleep(4000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open");
			Thread.sleep(1000);

		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// Verify Request quote link is working or not;
	@Test(priority = 8, groups = { "Smoke" })
	public void RequestQuoteHeaderLink() throws Exception {
		Thread.sleep(5000);
		log.info("Click on Request Quote button.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.requestQuoteCommonHeader);
		Thread.sleep(4000);
		log.info("Get page title .");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblrequestQuote);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.postBuyRequirementsTitle.getValue(lang),
				"Request quote page is not open");
		Thread.sleep(3000);
	}

	// =================== Footer Static link=======================
	// Verify about us link is working or not;
	@Test(priority = 9, groups = { "Smoke" })
	public void aboutusFooterLink() throws Exception {
		log.info("=========Footer  Link====================");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on about us link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkAboutUs);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.aboutUsTitle.getValue(lang), "About us page is not open");

	}

	// Verify help us link is working or no;
	@Test(priority = 10, groups = { "Smoke" })
	public void helpLink() throws Exception {

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblHelp);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.helpTitle.getValue(lang), "About us page is not open");

	}

	// Verify How it works link is working or not
	@Test(priority = 11, groups = { "Smoke" })
	public void howItWorksLink() throws Exception {

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on How it works link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHowItWorks);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tabSellerhowitworks); // Verify
		// seller tab is present or not
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.seller.getValue(lang), "How it works page is not open");

		boolean activeSellerTab = driver.findElement(pageControlsStaticPages.sellertabActive).getAttribute("class")
				.contains("active");
		Assert.assertEquals(activeSellerTab, true, "Seller tab is not displayed as active.");

	}

	// Verify Our Partner link is working or not
	@Test(priority = 12, groups = { "Smoke" })
	public void ourPartnerLink() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on our partner link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPartnerWithUs);
		log.info("Verify page title");
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.partnerWithUsTitle.getValue(lang),
				"Our Partner page is not open");

	}

	// Verify News link is working or not;
	@Test(priority = 13, groups = { "Smoke" })
	public void newsLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on News  link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkNews);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.newsTitle.getValue(lang), "News page is not open");

	}

	// Verify Contact Us link is working or not;
	@Test(priority = 14, groups = { "Smoke" })
	public void contactUsLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Contact us  link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkContactUs);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblContactUs);
		Assert.assertEquals(strlLabel, enum_staticPage.contactUsTitle.getValue(lang), "Contact Us page is not open");

	}

	// Verify Terms & Conditions link is working or not;
	@Test(priority = 15, groups = { "Smoke" })
	public void termsConditionsLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Terms & Conditions  link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkTermsConditions);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.termsConditionsTitle.getValue(lang),
				"Terms & Conditions page is not open");

	}

	// Verify Zoodel Academy link is working or not;
	@Test(priority = 16, groups = { "Smoke" })
	public void zoodelAcademyLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Zoodel Academy link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkZoodelAcademy);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.zoodelAcademyTitle.getValue(lang),
				"Zoodel Academy page is not open");
	}

	// Verify Iran Exporters Conference link is working or not;
	@Test(priority = 17, groups = { "Smoke" })
	public void iranExportersConferenceLink() throws Exception {
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		String strActualUrl = "";
		log.info("Click on Iran Exporters Conference  link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkIranSMEExportConf);
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			strActualUrl = driver.getCurrentUrl();
		}
		log.info("Close driver in another tab");
		driver.close();
		log.info("Switch main window");
		Assert.assertEquals(strActualUrl, enum_staticPage.iranSMEExportConf.getValue(lang),
				"Iran SMEs Export Conference page is not open");
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		Thread.sleep(4000);
	}

	// Verify ZoodPay (Escrow) link is working or not;
	@Test(priority = 18, groups = { "Smoke" })
	public void zoodPayLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on ZoodPay (Escrow) link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkZoodPay);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.zoodPayTitle.getValue(lang),
				"ZoodPay (Escrow) page is not open");

	}

	// Verify Business Verified link is working or not;
	@Test(priority = 19, groups = { "Smoke" })
	public void businessVerifiedLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Business Verified link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkBusinessVerified);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.businessVerifiedTitle.getValue(lang),
				"Business Verified page is not open");

	}

	// Verify Identity Verified link is working or not;
	@Test(priority = 20, groups = { "Smoke" })
	public void identityVerifiedLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Identity Verified link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkIdentityVerified);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.identityVerifiedTitle.getValue(lang),
				"Identity Verified page is not open");

	}

	// Verify Premium Memberships link is working or not;
	@Test(priority = 21, groups = { "Smoke" })
	public void premiumMembershipsLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Premium Memberships link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPremiumMemberships);
		Thread.sleep(3000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPricePage);
		Assert.assertEquals(strlLabel, enum_staticPage.premiumMembershipsTitle.getValue(lang),
				"Premium Memberships page is not open");
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */

	}

	// Verify Zoodel Finance link is working or not.
	@Test(priority = 22, groups = { "Smoke" })
	public void zoodelFinanceLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Zoodel Finance link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkZoodelFinance);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.zoodelFinaceBreadCum);
		Assert.assertEquals(strlLabel, enum_staticPage.zoodelFinance.getValue(lang),
				"Post Buy Requirements page is not open");
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify Request Quote link is working or not;
	@Test(priority = 23, groups = { "Smoke" })
	public void requestQuoteLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Request  Quote link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkRequestQuote);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblrequestQuote);
		Assert.assertEquals(strlLabel, enum_staticPage.postBuyRequirementsTitle.getValue(lang),
				"Post Buy Requirements page is not open");
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify Search Products and Sellers link is working or not
	@Test(priority = 24, groups = { "Smoke" })
	public void searchProductsAndSellersLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		log.info("Click on Search Products and Sellers link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkSearchProductsAndSellers);
		Thread.sleep(5000);
		log.info("Verify tab (product)");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tabProduct);
		Assert.assertEquals(strlLabel, enum_staticPage.product.getValue(lang),
				"Search Products and Sellers page is not open");
		Thread.sleep(2000);
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */
	}

	// Verify Create Your Web store link is working or not (without login)
	@Test(priority = 25, groups = { "Smoke" })
	public void createYourWebstoreWithoutLoginLink() throws Exception {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(4000);

		log.info("Click on Create Your Webstore link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkCreateYourWebstore);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.btnCreateYourWebstoreNow);
		Assert.assertEquals(strlLabel, enum_staticPage.createYourWebstoreNOW.getValue(lang),
				"Create Your Webstore Now page is not open");

	}

	// Verify Post Your Products Free link is working or not
	@Test(priority = 26, groups = { "Smoke" })
	public void postYourProductsFreeLink() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on Post Your Products Free link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPostYourProductsFree);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblListYourProduct);
		log.info("Verify page title");
		Assert.assertEquals(strlLabel, enum_staticPage.postYourProductsFree.getValue(lang),
				"Post Your Products Free page is not open");
		Thread.sleep(3000);
		/*
		 * log.info("Click on Logo .");
		 * frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		 */

	}

	// verify Exhibition Services
	@Test(priority = 27, groups = { "Smoke" })
	public void exhibitionServices() throws Exception {
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on Exhibition Services link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkExhibitionServices);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.breadcumExhibitionService);
		log.info("Verify page title");
		Assert.assertEquals(strlLabel, enum_staticPage.exhibitionServices.getValue(lang),
				"Exhibition Service page is not open");
		Thread.sleep(3000);
	}

	//Verify Market Research link is working or not.
	@Test(priority = 27, groups = { "Smoke" })
	public void marketResearchLink() throws Exception
	{
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on Market Research link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkMarketReasearch);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.breadcrumMareketResearch);
		log.info("Verify page title");
		Assert.assertEquals(strlLabel, enum_staticPage.marketResearch.getValue(lang),
				"Market research page is not open");
		Thread.sleep(3000);
	}
	
	
	// =======About us page ========
	// Verify Free joins us button in About us page.
	@Test(priority = 28, groups = { "Smoke" })
	public void verifyFreeJoinUsNowButtonInAboutUs() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on about us link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkAboutUs);
		Thread.sleep(3000);
		try {
			log.info("Click on Free joins now button.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinUsNow);
			Thread.sleep(4000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open(For About us page)");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// Verify 'How It Works' button is working or not
	@Test(priority = 29, groups = { "Smoke" })
	public void VerifyHowItWorksBtnInAboutUs() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on about us link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkAboutUs);
		Thread.sleep(3000);
		log.info("Click on 'How It Works' button.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.btnHowItWorks);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tabSellerhowitworks); // Verify
		// seller tab is present or not
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.seller.getValue(lang),
				"How it works page is not open(For About us page)");

	}

	// ======== Help========
	// verify 'Create Your Web Store' link is working or not.
	@Test(priority = 30, groups = { "Smoke" })
	public void VerifyCreateYourWebStoreInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Create Your Webstore link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkCreateYourwebstoreInHelp);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.btnCreateYourWebstoreNow);
		Assert.assertEquals(strlLabel, enum_staticPage.createYourWebstoreNOW.getValue(lang),
				"Create Your Webstore Now page is not open (For help page)");

	}

	// verify 'Post Your Products' link is working or not.
	@Test(priority = 31, groups = { "Smoke" })
	public void VerifyPostYourProductsInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Post Your Products Free link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPostYourProductInHelp);
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblListYourProduct);
		log.info("Verify page title");
		Assert.assertEquals(strlLabel, enum_staticPage.postYourProductsFree.getValue(lang),
				"Post Your Products Free page is not open (For help page)");

	}

	// verify 'Request Quote' link is working or not.
	@Test(priority = 32, groups = { "Smoke" })
	public void VerifyRequestQuoteInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Request  Quote link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkRequestQuoteInHelp);
		Thread.sleep(2000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblrequestQuote);
		Assert.assertEquals(strlLabel, enum_staticPage.postBuyRequirementsTitle.getValue(lang),
				"RequestQuote page is not open (For help page)");
	}

	// verify 'Search Products / Sellers' link is working or not.
	@Test(priority = 33, groups = { "Smoke" })
	public void VerifySearchProductSellerInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Search Products and Sellers link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkSearchProductSellerInHelp);
		Thread.sleep(5000);
		log.info("Verify tab (product)");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tabProduct);
		Assert.assertEquals(strlLabel, enum_staticPage.product.getValue(lang),
				"Search Products and Sellers page is not open (For help page)");
	}

	// verify 'Our Partners' link is working or not.
	@Test(priority = 34, groups = { "Smoke" })
	public void VerifyOurpartnersInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Our Partner link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkOurPartnerInHelp);
		log.info("Verify page title");
		Thread.sleep(2000);
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPageTitle);
		Assert.assertEquals(strlLabel, enum_staticPage.partnerWithUsTitle.getValue(lang),
				"Partner With Us page is not open (For help page)");
	}

	// verify 'Premium Memberships' link is working or not.
	@Test(priority = 35, groups = { "Smoke" })
	public void VerifyPremiumMembershipsInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on Premium Memberships link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPremiumMembershipsInHelp);
		Thread.sleep(3000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblPricePage);
		Assert.assertEquals(strlLabel, enum_staticPage.premiumMembershipsTitle.getValue(lang),
				"Premium Memberships page is not open (For help page)");
	}

	// Verify 'How It Works' button is working or not in help
	@Test(priority = 36, groups = { "Smoke" })
	public void VerifyHowItWorksInHelp() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		log.info("Click on Help link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHelp);
		Thread.sleep(4000);
		log.info("Click on 'How It Works' button.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.btnHowItWorksInHelp);
		Thread.sleep(4000);
		log.info("Verify page title");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.tabSellerhowitworks); // Verify
		// seller tab is present or not
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.seller.getValue(lang),
				"How it works page is not open (For help page)");

	}

	// =======How it Works=======
	// Verify 'Free join us Now' button on 'How it works' page
	@Test(priority = 37, groups = { "Smoke" })
	public void verifyFreeJoinUsNowButtonInHowitWorks() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on How it works link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHowItWorks);
		Thread.sleep(3000);
		try {
			log.info("Click on Free joins now button.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinUsNowHowItWork);
			Thread.sleep(4000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open in How it Works");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// Verify 'Buyer ' tab on 'How it works' page
	@Test(priority = 38, groups = { "Smoke" })
	public void verifyBuyerTabInHowitWorks() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on How it works link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkHowItWorks);
		Thread.sleep(3000);
		log.info("Click on Buyer tab.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.buyerTab);
		Thread.sleep(4000);
		log.info("Buyer tab is active or not.");
		boolean activeBuyerTab = driver.findElement(pageControlsStaticPages.buyertabActive).getAttribute("class")
				.contains("active");
		Assert.assertEquals(activeBuyerTab, true, "Buyer tab is not displayed as active in 'How it works' page ");
	}

	// ===========ZoodPay (Escrow)==========
	// Verify 'Free! join us Now ' button on 'ZoodPay (Escrow)' page
	@Test(priority = 39, groups = { "Smoke" })
	public void verifyFreeJoinUsNowInZoodPay() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on ZoodPay (Escrow) link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkZoodPay);
		Thread.sleep(3000);
		try {
			log.info("Click on Free! join us Now in ZoodPay (Escrow).");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinUsNowHowItWork);
			Thread.sleep(3000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open in ZoodPay (Escrow)");
			Thread.sleep(1000);

		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// ===========Business Verified==========
	// Verify 'Free! join us Now ' button on 'Business Verified' page
	@Test(priority = 40, groups = { "Smoke" })
	public void verifyFreeJoinUsNowInBusinessVerified() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on Business Verified link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkBusinessVerified);
		Thread.sleep(3000);
		try {
			log.info("Click on Free! join us Now in Business Verified.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinUsNowHowItWork);
			Thread.sleep(3000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open in Business Verified");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// ===========Identity Verified==========
	// Verify 'Free! join us Now ' button on 'Identity Verified' page
	@Test(priority = 41, groups = { "Smoke" })
	public void verifyFreeJoinUsNowInIdentityVerified() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on Identity Verified link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkIdentityVerified);
		Thread.sleep(3000);
		try {
			log.info("Click on Free! join us Now in Identity Verified.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinUsNowHowItWork);
			Thread.sleep(3000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open (For Identity Verified page)");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// =======Premium Membership========
	// Verify 'Free! join us Now ' button on 'Premium Membership' page
	@Test(priority = 42, groups = { "Smoke" })
	public void verifyFreeJoinUsNowInPremiumMembership() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on Premium Membership link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPremiumMemberships);
		Thread.sleep(3000);
		try {
			log.info("Click on Free! join us Now in Premium Membership.");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnFreeJoinNowInPremium);
			Thread.sleep(3000);
			log.info("Get page title .");
			String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
			System.out.println("Title ::  " + strlLabel);
			Thread.sleep(2000);
			Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
					"Register popup is not open (For Premium Membership page)");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Exception ::" + e);
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// Verify 'Yearly - Subscription' button in 'Premium Membership' page
	@Test(priority = 43, groups = { "Smoke" })
	public void verifyYearlySubscriptionInPremiumMembership() throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		log.info("Click on Premium Membership link in footer.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkPremiumMemberships);
		Thread.sleep(3000);
		log.info("Click on Yearly - Subscription in Premium Membership.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.btnYearlySubscription);
		Thread.sleep(3000);
		log.info("Get page title .");
		boolean _blnLoginTab = driver.findElement(pageControlsLogin.tabLogin).getAttribute("class").contains("active");
		Assert.assertEquals(_blnLoginTab, true, "Login tab is not active.");
		/*
		 * String strlLabel =
		 * frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle)
		 * ; System.out.println("Title ::  " + strlLabel); Thread.sleep(2000);
		 * Assert.assertEquals(strlLabel,
		 * enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
		 * "Login popup is not open (For Premium Membership page)");
		 */
		Thread.sleep(1000);
	}

	// Verify Facebook link is working or not
	@Test(priority = 49, groups = { "Smoke" })
	public void facebookLink() throws Exception {
		driver.navigate().refresh();
		String winHandleBefore1 = driver.getWindowHandle();
		String strActualUrl1 = "";
		Thread.sleep(3000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		log.info("Click on Facebook link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkFacebook);
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(2000);
			driver.switchTo().window(winHandle);
			Thread.sleep(2000);
			strActualUrl1 = driver.getCurrentUrl();
		}
		System.out.println("Facebook  ::" + strActualUrl1);
		log.info("Verify url");
		Assert.assertEquals(strActualUrl1, enum_staticPage.faceBook.getValue(lang), "Facebook page is not open");
		log.info("Close tab driver");
		driver.close();
		// Switch back to original browser (first window)
		log.info("Switch main window");
		driver.switchTo().window(winHandleBefore1);

	}

	// Verify Twitter link is working or not
	@Test(priority = 50, groups = { "Smoke" })
	public void twitterLink() throws Exception {
		String winHandleBefore2 = driver.getWindowHandle();
		String strActualUrl2 = "";
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on Twitter link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkTwitter);
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(2000);
			strActualUrl2 = driver.getCurrentUrl();
		}

		System.out.println("Twitter  ::" + strActualUrl2);
		log.info("Verify url");
		Assert.assertEquals(strActualUrl2, enum_staticPage.twitter.getValue(lang), "Twitter page is not open");
		log.info("Close driver in another tab");
		driver.close();
		log.info("Switch main window");
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);

	}

	// Verify Linkedin link is working or not
	@Test(priority = 51, groups = { "Smoke" })
	public void linkedinLink() throws Exception {
		String winHandleBefore3 = driver.getWindowHandle();
		String strActualUrl3 = "";
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on linkedin link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkLinkedin);
		Thread.sleep(4000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(2000);
			strActualUrl3 = driver.getCurrentUrl();
		}
		Thread.sleep(2000);
		System.out.println("Linkdin  ::" + strActualUrl3);
		log.info("Verify url");
		Assert.assertEquals(strActualUrl3, enum_staticPage.linkdin.getValue(lang), "Linkdin page is not open");
		// Switch back to original browser (first window)
		log.info("Close driver in another tab");
		driver.close();
		log.info("Switch main window");
		driver.switchTo().window(winHandleBefore3);

	}

	// Verify Telegram link is working or not
	@Test(priority = 52, groups = { "Smoke" })
	public void telegramLink()  throws Exception {
		driver.navigate().refresh();
		String winHandleBefore3 = driver.getWindowHandle();
		String strActualUrl3 = "";
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		log.info("Click on telegram link.");
		frameworkMethods.clickOnLink(pageControlsStaticPages.lnkTelegram);
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(2000);
			strActualUrl3 = driver.getCurrentUrl();
		}
		Thread.sleep(2000);
		System.out.println("Telegram  ::" + strActualUrl3);
		log.info("Verify url");
		Assert.assertEquals(strActualUrl3, enum_staticPage.telegram.getValue(lang), "Telegram page is not open");
		// Switch back to original browser (first window)
		log.info("Close driver in another tab");
		driver.close();
		log.info("Switch main window");
		driver.switchTo().window(winHandleBefore3);

	}

}
