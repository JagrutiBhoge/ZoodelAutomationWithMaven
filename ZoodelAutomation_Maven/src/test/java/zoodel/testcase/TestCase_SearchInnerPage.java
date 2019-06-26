package zoodel.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zoodel.base.*;
import zoodel.testdata.*;


public class TestCase_SearchInnerPage extends TestBase {
	private static final Logger log = Logger.getLogger(TestCase_SearchInnerPage.class.getName());
	public static int prevRowIndex = 1;

	String strcompanyName = "Garden Fresco EN";  //strcompanyName
	String strProductName1 ="";
	@BeforeClass
	public void setUpClassInitialization() throws Exception {
		String strProductName = strProductName1;//enum_addProduct.productName.getValue(lang);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		log.info("Close adverting popup when advertising popup is  display on screen.");
		pageMethods.closeAdvertisingPopup();
		Thread.sleep(2000);
		log.info("Select language from public side");
		pageMethods.LanguageSelectionInPublic();
		Thread.sleep(3000);
		log.info("Call Login  method");
		pageMethods.loggedIn(testDataLogin.userEmail, testDataLogin.userPassword);
		Thread.sleep(3000);
		log.info("Go to My account");
		pageMethods.goToMyAccount();
		Thread.sleep(3000);
		log.info("Click on Seller Tools (Menu)");
		frameworkMethods.clickOnLink(pageControlsSellerTools.menuSeller);
		Thread.sleep(2000);
		log.info("Verify product status  (call to getStatus function).");
		pageMethodSellerTool.getProductStatusAndPublishProduct(strProductName);
		Thread.sleep(2000);
	}

	// It will execute before every test execution
	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeMethodInitialization() throws Exception {
		Thread.sleep(3000);
		log.info("Close adverting popup when advertising popup is  display on screen.");
		pageMethods.closeAdvertisingPopup();
		Thread.sleep(2000);
		log.info("Scroll down");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		log.info("Click on Logo .");
		frameworkMethods.clickOnLink(pageControlsStaticPages.logo);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		log.info("Click on search button at home page.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchHome);
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

	// Click on view more 2 time
	public void viewMoreClick_2() throws Exception {
		for (int i = 1; i <= 2; i++) {
			boolean flag = driver.findElements(pageControlsSearch.btnViewMore).size() != 0;
			Thread.sleep(5000);
			if (flag == true) {
				Thread.sleep(3000);
				System.out.println("Status ::" + flag);
				log.info("Click on view more button.");
				frameworkMethods.clickOnLink(pageControlsSearch.btnViewMore);
			} else {
				break;
			}

		}
	}

	// Click on Agriculture & Animals sub category at left side in search page
	public void clickOnAgricultureAnimalsLeftSide() throws Exception {
		Thread.sleep(2000);
		log.info("Find Agriculture & Animals sub category.");
		List<WebElement> listCategory = driver.findElements(pageControlsSearch.listLeftSideCategory);
		System.out.println(listCategory.size());
		for (WebElement webElement : listCategory) {
			Thread.sleep(1000);
			WebElement lblCategory = webElement.findElement(By.tagName("h5"));
			Thread.sleep(1000);
			if (lblCategory.getText().equals(enum_addProduct.subCategory1.getValue(lang))) {
				Thread.sleep(1000);
				log.info("Click on Agriculture & Animals sub category.");
				lblCategory.click();
				break;
			}
		}
	}

	// Search with only select product at inner search page
	@Test(priority = 1, groups = { "Smoke" })
	public void searchWithOnlySelectProductAtInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button at Inner page.");
		frameworkMethods.click_On_Button(pageControlsSearch.btnSearchInner);
		Thread.sleep(2000);
		log.info("Verify products tab active.");
		boolean tabActive = pageMethods.ActiveTab(pageControlsSearch.tabProduct);
		Assert.assertEquals(tabActive, true, "Products tab does not active.");
	}

	// Search with Main category name and select product at inner search page
	@Test(priority = 2, groups = { "Regression" })
	public void searchWithMainCatgoryNameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(4000);
		log.info("Select Product ");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(3000);
		log.info("Enter the Main catgory name - Agriculture & Food  - in search textbox."
				+ enum_addProduct.category.getValue(lang));
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.category.getValue(lang));
		Thread.sleep(5000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");

	}

	// Search with sub category 1 name and select product at inner search page
	@Test(priority = 3, groups = { "Regression" })
	public void searchWithSubCatgory1NameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(5000);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		Thread.sleep(5000);
		log.info("Enter the sub catgory name - Agriculture & Animals - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory1.getValue(lang));
		Thread.sleep(5000);
		log.info("Select Product ");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with sub category 2 name and select product at inner search page
	@Test(priority = 4, groups = { "Regression" })
	public void searchWithSubCatgory2NameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		// frameworkMethods.clear_Text(By.xpath("(//input[@id='txtSearch'])[2]"));
		Thread.sleep(1000);
		log.info("Enter the sub catgory name - Beans, Grains & Cereals - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory2.getValue(lang));
		Thread.sleep(1000);
		log.info("Select Product ");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with sub category 3 name and select product at inner search page
	@Test(priority = 5, groups = { "Regression" })
	public void searchWithSubCatgory3NameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		Thread.sleep(1000);
		log.info("Enter the sub catgory name - Beans - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory3.getValue(lang));
		Thread.sleep(1000);
		log.info("Select Product ");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with class name and select product at inner search page
	@Test(priority = 6, groups = { "Regression" })
	public void searchWithClassNameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		Thread.sleep(1000);
		log.info("Enter the class name - Broad Beans - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner, enum_addProduct.class1.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with product name and select product at inner search page
	@Test(priority = 7, groups = { "Smoke" })
	public void searchWithProductNameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		Thread.sleep(1000);
		log.info("Enter the product name - Green Broad Beans EN - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.productName.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(3000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with seller name and select product at inner search page
	@Test(priority = 8, groups = { "Smoke" })
	public void searchWithSellerNameAndSelectProductAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Clear search text box.");
		frameworkMethods.clear_Text(pageControlsSearch.txtSearchInner);
		Thread.sleep(1000);
		log.info("Enter the seller name - Garden Fresco EN - in search textbox.");
		String strcompanyName = "Garden Fresco EN";
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,strcompanyName);
				//strcompanyName);
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(6000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search with only select seller at inner search page
	@Test(priority = 9, groups = { "Smoke" })
	public void searchWithOnlySelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(2000);
		log.info("Verify seller tab active.");
		boolean tabActive = pageMethods.ActiveTab(pageControlsSearch.tabSeller);
		Assert.assertEquals(tabActive, true, "Seller tab does not active.");

	}

	// Search with Main category name and select seller at inner search page
	@Test(priority = 10, groups = { "Regression" })
	public void searchWithMainCatgoryNameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the Main catgory name - Agriculture, Animals, Food & Beverage - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.category.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapny not found...");
	}

	// Search with sub category 1 name and select seller at inner search page
	@Test(priority = 11, groups = { "Regression" })
	public void searchWithSubCatgory1NameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the sub catgory name - Beans, Grains & Cereals - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory2.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapny not found...");
	}

	// Search with sub category 2 name and select seller at inner search page
	@Test(priority = 12, groups = { "Regression" })
	public void searchWithSubCatgory2NameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the sub catgory name - Beans, Grains & Cereals - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory2.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(2000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapny not found...");
	}

	// Search with sub category 3 name and select seller at inner search page
	@Test(priority = 13, groups = { "Regression" })
	public void searchWithSubCatgory3NameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the sub catgory name - Beans - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.subCategory3.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapny not found...");
	}

	// Search with class name and select seller at inner search page
	@Test(priority = 14, groups = { "Regression" })
	public void searchWithClassNameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the class name - Broad Beans - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner, enum_addProduct.class1.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapny not found...");
	}

	// Search with product name and select seller at inner search page
	@Test(priority = 15, groups = { "Smoke" })
	public void searchWithProductNameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the product name - Green Broad Beans - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				enum_addProduct.productName.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Comapany not found...");
	}

	// Search with seller name and select seller at inner search page
	@Test(priority = 16, groups = { "Smoke" })
	public void searchWithSellerNameAndSelectSellerAtInnerPage() throws Exception {
		Thread.sleep(3000);
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Enter the seller name - Garden Fresco - in search textbox.");
		frameworkMethods.enterTextJavaScript(pageControlsSearch.txtSearchInner,
				strcompanyName);
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Find comapny and verify comapny name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Company not found...");
	}

	// Search product with select Premium Seller check box
	@Test(priority = 17, groups = { "Regression" })
	public void searchProductWithSelectPremiumSellerCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Select Premium Seller.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.premiumSeller.getValue(lang));
		Thread.sleep(5000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Premium products.");
		boolean result = pageMethodSearchPage.verifySellerStatus(pageControlsSearch.productRowCollection,
				enum_search.premiumSeller.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Premium products are not found...");
	}

	// Search product with select Identity Verified check box
	@Test(priority = 18, groups = { "Regression" })
	public void searchProductWithSelectIdentityVerifiedCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.click_On_Button(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Select Identity Verified Seller checkbox.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.identityVerified.getValue(lang));
		Thread.sleep(2000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Identity Verified products.");
		boolean result = pageMethodSearchPage.verifySellerStatusIdentity(pageControlsSearch.productRowCollection,
				enum_search.business_verified.getValue(lang), enum_search.identity_verified.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Identity Verified products are not found...");
	}

	// Search product with select Only Iranian Seller check box
	@Test(priority = 19, groups = { "Regression" })
	public void searchProductWithSelectOnlyIranianSellerCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.click_On_Button(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Select Only Iranian Seller checkbox.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.onlyIranianSeller.getValue(lang));
		Thread.sleep(2000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Only Iranian Seller products.");
		boolean result = pageMethodSearchPage.verifySellerStatus(pageControlsSearch.productRowCollection,
				enum_search.country.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Only Iranian Seller products are not found...");
	}

	// Search Seller with select Premium Seller check box
	@Test(priority = 20, groups = { "Regression" })
	public void searchSellerWithSelectPremiumSellerCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Select Premium Seller.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.premiumSeller.getValue(lang));
		Thread.sleep(2000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Premium seller.");
		boolean result = pageMethodSearchPage.verifySellerStatus(pageControlsSearch.sellerRowCollection,
				enum_search.premium_memberships.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Premium seller are not found...");
	}

	// Search Seller with select Identity Verified check box
	@Test(priority = 21, groups = { "Regression" })
	public void searchSellerWithSelectIdentityVerifiedCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Select Identity Verified Seller checkbox.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.identityVerified.getValue(lang));
		Thread.sleep(2000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Identity Verified products.");
		boolean result = pageMethodSearchPage.verifySellerStatusIdentity(pageControlsSearch.sellerRowCollection,
				enum_search.business_verified.getValue(lang), enum_search.identity_verified.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Identity Verified seller are not found...");
	}

	// Search Seller with select Only Iranian Seller check box
	@Test(priority = 22, groups = { "Regression" })
	public void searchSellerWithSelectOnlyIranianSellerCheckBox() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();

		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.click_On_Button(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		log.info("Select Only Iranian Seller checkbox.");
		frameworkMethods.select_value_On_CheckBox(pageControlsSearch.chkSearch, pageControlsSearch.chkLabel,
				pageControlsSearch.chkInput, enum_search.onlyIranianSeller.getValue(lang));
		Thread.sleep(2000);
		viewMoreClick_2();
		Thread.sleep(2000);
		log.info("Verify the Only Iranian Seller products.");
		boolean result = pageMethodSearchPage.verifySellerStatus(pageControlsSearch.sellerRowCollection,
				enum_search.country.getValue(lang));
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "'Only Iranian Seller' seller are not found...");
	}

	// Search product with sub category at left panel in inner search page
	@Test(priority = 23, groups = { "Regression" })
	public void searchProductWithSubCategoryAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with class at left panel in inner search page
	@Test(priority = 24, groups = { "Regression" })
	public void searchProductWithClassAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithProduct();
		Thread.sleep(2000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with sub category 3 at left panel in inner search page
	@Test(priority = 25, groups = { "Regression" })
	public void searchProductWithSubCategory3AtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithProduct();
		Thread.sleep(2000);
		// log.info("Click on Beans.");
		// frameworkMethods.clickOnLink(By.id("beans"));
		Thread.sleep(3000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with sub category 2 at left panel in inner search page
	@Test(priority = 26, groups = { "Regression" })
	public void searchProductWithSubCategory2AtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithProduct();
		Thread.sleep(2000);
		// log.info("Click on Beans, Grains & Cereals.");
		// frameworkMethods.clickOnLink(By.id("beans_grains_cereals"));
		Thread.sleep(3000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with Type of Business at left panel in inner search page
	@Test(priority = 27, groups = { "Regression" })
	public void searchProductWithTypeOfBusinessAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		frameworkMethods.moveToElement(pageControlsSearch.chkBusinessTypeCollection);
		Thread.sleep(1000);
		log.info("Select on Type of Business.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with Country at left panel in inner search page
	@Test(priority = 28, groups = { "Regression" })
	public void searchProductWithCountryAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		Thread.sleep(1000);
		log.info("Check country check  box.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));
		/*
		 * List<WebElement> listCountry = driver
		 * .findElements(pageControlsSearch.chkCountryCollection); for
		 * (WebElement webElement : listCountry) { WebElement nameCountry =
		 * webElement
		 * .findElement(pageControlsSearch.chkLabelCountryAndTypeBussiness); if
		 * (nameCountry.getText().equals(
		 * enum_companyProfile.country.getValue(lang))) { Thread.sleep(1000);
		 * log.info("Select on Country."); nameCountry.click(); break; } }
		 */
		Thread.sleep(5000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with sub category,class,Type of Business and Country at
	// left panel in inner search page
	@Test(priority = 29, groups = { "Regression" })
	public void searchProductWithSubCategory_Class_TypeOfBusiness_CountryAtLeftPanelinInnerSearchPage()
			throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		// ----------------------------
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(3000);
		pageMethodSearchPage.clickOnBroadBeansWithProduct();
		Thread.sleep(3000);
		// ----------------------------
		log.info("Select on Type of Business.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(4000);
		// ----------------------------
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		log.info("Select on Country.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));

		// -----------------------------------
		Thread.sleep(4000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search product with Type of Business and Country at left panel in inner
	// search page
	@Test(priority = 30, groups = { "Regression" })
	public void searchProductBusiness_CountryAtLeftPanelinInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectProductInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		frameworkMethods.moveToElement(pageControlsSearch.chkBusinessTypeCollection);
		log.info("Select on Type of Business.");
		/* frameworkMethods.select_value_On_CheckBox( */
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(4000);
		// ----------------------------
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		log.info("Select on Country.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithProduct(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));

		// -----------------------------------
		Thread.sleep(4000);
		log.info("Find product and verify product name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.productRowCollection,
				pageControlsSearch.productNameText, enum_addProduct.productName.getValue(lang), prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Product not found...");
	}

	// Search seller with sub category at left panel in inner search page
	@Test(priority = 31, groups = { "Regression" })
	public void searchSellerWithSubCategoryAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(3000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");
	}

	// Search seller with sub category and class at left panel in inner search
	// page
	@Test(priority = 32, groups = { "Regression" })
	public void searchSellerWithSubCategory_ClassAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithSeller();
		Thread.sleep(2000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "seller not found...");
	}

	// Search seller with sub category 3 at left panel in inner search page
	@Test(priority = 33, groups = { "Regression" })
	public void searchSellerWithSubCategory3AtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithSeller();
		Thread.sleep(2000);
		log.info("Click on Beans.");
		frameworkMethods.clickOnLink(By.id("beans"));
		Thread.sleep(3000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "seller not found...");
	}

	// Search seller with sub category 3 at left panel in inner search page
	@Test(priority = 34, groups = { "Regression" })
	public void searchSellerWithSubCategory2AtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(2000);
		pageMethodSearchPage.clickOnBroadBeansWithSeller();
		Thread.sleep(2000);
		log.info("Click on Beans, Grains & Cereals.");
		frameworkMethods.clickOnLink(pageControlsSearch.beansGrainsCerealsLink);
		Thread.sleep(3000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");
	}

	// Search seller with Type Of Business at left panel in inner search page
	@Test(priority = 35, groups = { "Regression" })
	public void searchSellerWithTypeOfBusinessAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		frameworkMethods.moveToElement(pageControlsSearch.chkBusinessTypeCollection);
		Thread.sleep(1000);
		log.info("Select on Type of Business.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(4000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");

	}

	// Search seller with Country at left panel in inner search page
	@Test(priority = 36, groups = { "Regression" })
	public void searchSellerWithCountryAtLeftPanelInInnerSearchPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(1000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(4000);
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		Thread.sleep(1000);
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));

		Thread.sleep(4000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");

	}

	// Search seller with SubCategory, Class, Type Of Business and Country at
	// left panel in inner search page
	@Test(priority = 37, groups = { "Regression" })
	public void searchSellerWithSubCategory_Class_TypeOfBusiness_CountryAtLeftPanelinInnerSearchPage()
			throws Exception {
		Thread.sleep(3000);
		log.info("Select value in dropdown (Seller)");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(5000);
		// ----------------------------
		clickOnAgricultureAnimalsLeftSide();
		Thread.sleep(3000);
		pageMethodSearchPage.clickOnBroadBeansWithSeller();
		Thread.sleep(3000);
		// ----------------------------
		log.info("Select on Type of Business.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(5000);
		// ----------------------------
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		log.info("Select on Country.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));

		// -----------------------------------
		Thread.sleep(5000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");
	}

	// Search seller with Type of Business and Country at left panel in inner
	// search page
	@Test(priority = 38, groups = { "Regression" })
	public void searchSellerBusiness_CountryAtLeftPanelinInnerSearchPage() throws Exception {
		Thread.sleep(2000);
		log.info("Select value in dropdown");
		pageMethodSearchPage.selectSellerInnerPage();
		Thread.sleep(2000);
		log.info("Click on search button.");
		frameworkMethods.clickOnLink(pageControlsSearch.btnSearchInner);
		Thread.sleep(2000);
		frameworkMethods.waitTillElementAppears(pageControlsSearch.chkBusinessTypeCollection);
		frameworkMethods.moveToElement(pageControlsSearch.chkBusinessTypeCollection);
		log.info("Select on Type of Business.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkBusinessTypeCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.trader.getValue(lang));
		Thread.sleep(3000);
		// ----------------------------
		frameworkMethods.waitTillElementAppears(pageControlsSearch.chkCountryCollection);
		frameworkMethods.moveToElement(pageControlsSearch.chkCountryCollection);
		log.info("Select on Country.");
		pageMethodSearchPage.selectValueOnCheckBoxInSearchWithSeller(pageControlsSearch.chkCountryCollection,
				pageControlsSearch.chkLabelCountryAndTypeBussiness, pageControlsSearch.chkInput,
				enum_companyProfile.country.getValue(lang));

		// -----------------------------------
		Thread.sleep(4000);
		log.info("Find seller and verify seller name.");
		boolean result = pageMethodSearchPage.search(pageControlsSearch.sellerRowCollection,
				pageControlsSearch.companyNameText, strcompanyName, prevRowIndex);
		Thread.sleep(1000);
		Assert.assertEquals(result, true, "Seller not found...");
	}

	// Search with main category using BrowseByCategories drop down.
	@Test(priority = 39, groups = { "Regression" })
	public void browseByCategoriesWithMainCategory() throws Exception {
		Thread.sleep(2000);
		log.info("Mouse hover on BrowseByCategories dropdown.");
		frameworkMethods.moveToElement(pageControlsSearch.browseByCategories);
		Thread.sleep(1000);
		WebElement mouseOverMainCategory = driver
				.findElement(pageControlsSearch.browseCategListAgricultureAnimalsFoodBeverage);
		log.info("Mouse hover on Agriculture, Animals, Food & Beverage in BrowseByCategories dropdown.");
		String mouseOverScriptMainCategory = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScriptMainCategory, mouseOverMainCategory);
		Thread.sleep(1000);
		log.info("Click on Agriculture, Animals, Food & Beverage category in BrowseByCategories..");
		mouseOverMainCategory.click();
		Thread.sleep(2000);
		// ******************************
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = driver.getWindowHandle();
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		// ******************************
		log.info("Verify Agriculture, Animals, Food & Beverage name in category title at search page..");
		String getCategoryName = frameworkMethods.get_LableText(pageControlsHomePage.lblCatidSubidText);
		Assert.assertEquals(getCategoryName, enum_addProduct.category.getValue(lang),
				"Agriculture, Animals, Food & Beverage name does not match in category title at search page....");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(oldTab);
	}

	// Search with sub category using BrowseByCategories dropdown.
	@Test(priority = 40, groups = { "Regression" })
	public void browseByCategoriesWithSubCategory() throws Exception {
		Thread.sleep(2000);
		log.info("Mouse hover on BrowseByCategories dropdown.");
		frameworkMethods.moveToElement(pageControlsSearch.browseByCategories);
		Thread.sleep(1000);
		frameworkMethods.moveToElement(pageControlsSearch.browseCategListAgricultureAnimalsFoodBeverage);
		Thread.sleep(1000);
		WebElement mouseOverMainCategory = driver
				.findElement(pageControlsSearch.browseCategListAgricultureAnimalsFoodBeverage);
		WebElement mouseOverSubCategory = driver.findElement(pageControlsSearch.browseCategListAgricultureAnimals);
		log.info("Mouse hover on Agriculture, Animals, Food & Beverage in BrowseByCategories dropdown.");
		String mouseOverScriptMainCategory = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScriptMainCategory, mouseOverMainCategory);
		Thread.sleep(1000);
		log.info("Mouse hover on Agriculture & Animals in BrowseByCategories dropdown.");
		String mouseOverScriptSubCategory = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScriptSubCategory, mouseOverSubCategory);
		Thread.sleep(1000);
		log.info("Click on Agriculture & Animals in BrowseByCategories..");
		mouseOverSubCategory.click();
		Thread.sleep(2000);

		// ******************************
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = driver.getWindowHandle();
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		// ******************************
		Thread.sleep(2000);
		frameworkMethods.waitTillElementAppears(pageControlsHomePage.lblCatidSubidText);
		log.info("Verify Agriculture & Animals name in category title at search page..");
		String getCategoryName = frameworkMethods.get_LableText(pageControlsHomePage.lblCatidSubidText);
		Assert.assertEquals(getCategoryName, enum_addProduct.subCategory1.getValue(lang),
				"Agriculture & Animals name does not match in category title at search page....");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(oldTab);
	}

	// Search with class using BrowseByCategories dropdown.
	@Test(priority = 41, groups = { "Regression" })
	public void browseByCategoriesWithClass() throws Exception {
		Thread.sleep(2000);
		log.info("Mouse hover on BrowseByCategories dropdown.");
		frameworkMethods.moveToElement(pageControlsSearch.browseByCategories);
		Thread.sleep(1000);
		WebElement mouseOverMainCategory = driver
				.findElement(pageControlsSearch.browseCategListAgricultureAnimalsFoodBeverage);
		WebElement mouseOverClass = driver.findElement(pageControlsSearch.browseCategListClass);
		log.info("Mouse hover on Agriculture, Animals, Food & Beverage in BrowseByCategories dropdown.");
		String mouseOverScriptMainCategory = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScriptMainCategory, mouseOverMainCategory);
		Thread.sleep(1000);
		log.info("Mouse hover on Broad Beans in BrowseByCategories dropdown.");
		String mouseOverScriptClass = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScriptClass, mouseOverClass);
		Thread.sleep(1000);
		log.info("Click on Broad Beans in BrowseByCategories..");
		mouseOverClass.click();
		Thread.sleep(2000);
		// ******************************
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = driver.getWindowHandle();
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		// ******************************
		Thread.sleep(2000);
		frameworkMethods.waitTillElementAppears(pageControlsHomePage.lblCatidSubidText);
		log.info("Verify Broad Beans name in category title at search page..");
		String getCategoryName = frameworkMethods.get_LableText(pageControlsHomePage.lblCatidSubidText);
		Assert.assertEquals(getCategoryName, enum_addProduct.class1.getValue(lang),
				"Broad Beans name does not match in category title at search page....");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(oldTab);
	}

	// ===================Contact seller==============

	// Verify Contact seller button is working or not . And check its product
	// name and seller name in Product tab
	@Test(priority = 42, groups = { "Regression" })
	public void verifyContactSellerPopupCheckProdSellerNameInProductTab() throws Exception {

		log.info("Get product Name");
		String strProductNameExpect = frameworkMethods.get_LableText(pageControlsSearch.lblProductName);
		String strSellerNameExpect = frameworkMethods.get_LableText(pageControlsSearch.companyNameInProductTab);
		Thread.sleep(1000);
		log.info("click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		log.info("Get Product Name in contact us popup");
		String strProductNameActual = frameworkMethods
				.get_LableText(pageControlAllPopups.lblProductNameInContactSeller);
		log.info("Verify product name in contact seller popup.");
		Assert.assertEquals(strProductNameActual, strProductNameExpect, "Product name does not match.");
		log.info("Get Seller Name in contact us popup");
		String strSellerNameActual = frameworkMethods.get_LableText(pageControlAllPopups.lblSellerNameInContactSeller);
		log.info("Verify Seller name in contact seller popup.");
		Assert.assertEquals(strSellerNameActual, strSellerNameExpect, "Seller name does not match.");
	}

	// Verify Contact seller button is working or not . And check its product
	// name and seller name in seller tab
	@Test(priority = 43, groups = { "Regression" })
	public void verifyContactSellerPopupCheckProdSellerNameInSeller() throws Exception {
		Thread.sleep(1000);
		log.info("Click on seller tab");
		frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
		Thread.sleep(3000);
		log.info("Get Seller Name");
		// String strProductNameExpect =
		// frameworkMethods.get_LableText(pageControlsSearch.lblProductName);
		String strSellerNameExpect = frameworkMethods.get_LableText(pageControlsSearch.lblsellerName);
		Thread.sleep(1000);
		log.info("click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		Thread.sleep(1000);
		log.info("Get Seller Name in contact us popup");
		String strSellerNameActual = frameworkMethods.get_LableText(pageControlAllPopups.lblSellerNameInContactSeller);
		Thread.sleep(1000);
		log.info("Verify Seller name in contact seller popup.");
		Assert.assertEquals(strSellerNameActual, strSellerNameExpect, "Seller name does not match.");
	}

	// ---------Without login ------------------------------------------

	// Verify contact seller popup functionality.
	// Verify registration form popup is open or not when user fill form without
	// login (In product tab)
	@Test(priority = 44, groups = { "Regression" })
	public void verifyContactSellerPopupInProductTab() throws Exception {

		log.info("Click on logout  link");
		frameworkMethods.moveToElement(pageControlsCommon.hoverUserName);
		Thread.sleep(1000);
		frameworkMethods.clickOnLink(pageControlsLogin.lnkLogOut);
		Thread.sleep(2000);
		log.info("Click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		Thread.sleep(1000);
		log.info("Call sendContactSellerPopupInSearhPage function.");
		pageMethodsAllPopup.sendContactSellerPopupInSearhPage(testDataLogin.invalidEmail);
		frameworkMethods.waitTillElementAppears(pageControlsCommon.successMessage);
		log.info("Verify validation message");
		String strSuccessMsg = frameworkMethods.get_LableText(pageControlsCommon.successMessage);
		Assert.assertEquals(strSuccessMsg, enum_allPopups.contactSellerSucessfullyMessageWithoutlogin.getValue(lang),
				"Confirmation message does not match.");
		frameworkMethods.waitTillElementAppears(pageControlsCommon.successMessage);
		log.info("Verify registration popup is open or not .");
		log.info("Get page title .");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
		System.out.println("Title ::  " + strlLabel);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
				"Register popup is not open");
		log.info("Click on close button on popup");
		frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
		Thread.sleep(2000);

	}

	// Verify required field validation message in contact seller pop up.(In
	// Product tab)
	@Test(priority = 45)
	public void verifyRequiredFieldValidationMsgInContactSellerPopupInProductTab() throws Exception {
		Thread.sleep(1000);
		try {
			log.info("click on contact seller button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
			Thread.sleep(1000);
			log.info("clear quantity field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtQuantityInContactSeller);
			Thread.sleep(1000);
			log.info("Clear quantity unit field.");
			frameworkMethods.clear_Value_On_DropDown(pageControlAllPopups.ddlQuantityUnitInContactSeller);
			Thread.sleep(1000);
			log.info("Clear  text Name field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtNameInContactSeller);
			Thread.sleep(1000);
			log.info("Clear Email text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtEmailInContactSeller);
			Thread.sleep(1000);
			log.info("Clear Country code text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtCountryCodeInContactSeller);
			Thread.sleep(1000);
			log.info("Clear mobile number text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtNumberInContactSeller);
			Thread.sleep(1000);
			log.info("Click on SubmitYourRequirment button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnSubmitYourRequirement);
			Thread.sleep(2000);

			Thread.sleep(1000);
			log.info("Verify the message required field validation message.");
			String reqValMessage = frameworkMethods.get_LableText(pageControlsSearch.reqValDescripContactSellPopup);
			Assert.assertEquals(reqValMessage, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Message required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the required field validation message in quantity field.");
			String reqValQuantity = frameworkMethods.get_LableText(pageControlsSearch.reqValQuantityContactSellPopup);
			Assert.assertEquals(reqValQuantity, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Quantity required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the required field validation message in quantity unit field.");
			String reqValQuantityUnit = frameworkMethods
					.get_LableText(pageControlsSearch.reqValQuantityUnitContactSellPopup);
			Assert.assertEquals(reqValQuantityUnit, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Quantity required field validation message does not match..");
			Thread.sleep(1000);

			log.info("Verify the Name required field validation message.");
			String reqValName = frameworkMethods.get_LableText(pageControlsSearch.reqValNameContactSellPopup);
			Assert.assertEquals(reqValName, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Name required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Email required field validation message.");
			String reqValEmail = frameworkMethods.get_LableText(pageControlsSearch.reqValEmailContactSellPopup);
			String strEmailActual = enum_validationMessage.requiredFieldValidation.getValue(lang) + " "
					+ enum_validationMessage.invalidEmailFieldValidation.getValue(lang);
			log.info("Actual Email validation message :::" + strEmailActual);
			Assert.assertEquals(reqValEmail, strEmailActual,
					"Email required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Country code required field validation message.");
			String reqValCountryCode = frameworkMethods
					.get_LableText(pageControlsSearch.reqValCountryCodeContactSellPopup);
			Assert.assertEquals(reqValCountryCode, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Country code required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Number required field validation message.");
			String reqValNumber = frameworkMethods.get_LableText(pageControlsSearch.reqValNumberContactSellPopup);
			Assert.assertEquals(reqValNumber, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Mobile number required field validation message does not match..");
		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// To verify invalid email validation at Contact Seller Popup (In Product
	// tab)
	@Test(priority = 46, groups = { "Regression" })
	public void verifyEmailValidationOnContactSellerPopupInProductTab() throws Exception {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			log.info("click on contact seller button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
			Thread.sleep(3000);
			String[] invalidEmail = { "utkarsh.patel", "utkarsh@patel@bcssarl.com", "utkarsh.@bcssarl..com",
					"@bcssarl.com", "utkarsh.bcssarl.com", "Ã£ï¿½â€šÃ£ï¿½â€žÃ£ï¿½â€ Ã£ï¿½Ë†Ã£ï¿½Å @example.com", "email@bcssarl..com" };
			for (int i = 0; i <= invalidEmail.length - 1; i++) {
				Thread.sleep(2000);
				log.info("Clear email field.");
				frameworkMethods.clear_Text(pageControlAllPopups.txtEmailInContactSeller);
				Thread.sleep(1000);
				log.info("Enter email field.");
				frameworkMethods.enterTextJavaScript(pageControlAllPopups.txtEmailInContactSeller, invalidEmail[i]);
				Thread.sleep(2000);
				log.info("Click on send button.");
				frameworkMethods.clickOnLink(pageControlAllPopups.btnSubmitYourRequirement);
				Thread.sleep(2000);
				log.info("Verify invalid email validation message.");
				String emailValMsgActual = frameworkMethods
						.get_LableText(pageControlsSearch.reqValEmailContactSellPopup);
				Assert.assertEquals(emailValMsgActual,
						enum_validationMessage.invalidEmailFieldValidation.getValue(lang),
						"Invalid email validation does not match..." + invalidEmail[i]);
			}
		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// To verify Mobile number (Country code and number) field validation on
	// Contact seller popup (In Product Tab)
	@Test(priority = 47, groups = { "Regression" })
	public void verifyMobileNumberValidationOnContactSellerInProductTab() throws Exception {
		try {
			Thread.sleep(2000);
			log.info("click on contact seller button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
			Thread.sleep(3000);
			log.info("To verify country code in Characters should not allowed.");
			String strChar = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtCountryCodeInContactSeller, enum_common.character.getValue(lang));
			Assert.assertEquals(strChar, "", "Characters should not allowed in Country code field.");
			Thread.sleep(2000);

			log.info("To verify Country code in Special Characters should not allowed.");
			String strSpecChar = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtCountryCodeInContactSeller, enum_common.specialCharacter.getValue(lang));
			Assert.assertEquals(strSpecChar, "", "Special Characters should not allowed in Country code field.");

			log.info("To verify Mobile number in Characters should not allowed.");
			String strCharNuber = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtNumberInContactSeller, enum_common.character.getValue(lang));
			Assert.assertEquals(strCharNuber, "", "Characters should not allowed in mobile number field.");
			Thread.sleep(2000);

			log.info("To verify Mobile number in Special Characters should not allowed.");
			String strSpecCharNumber = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtNumberInContactSeller, enum_common.specialCharacter.getValue(lang));
			Assert.assertEquals(strSpecCharNumber, "", "Special Characters should not allowed in mobile number field.");

		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// Verify contact seller popup functionality.
	// Verify registration form popup is open or not when user fill form without
	// login (In Seller tab)
	@Test(priority = 48, groups = { "Regression" })
	public void verifyContactSellerPopupInSellerTab() throws Exception {
		Thread.sleep(1000);
		log.info("Click on seller tab");
		frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
		Thread.sleep(3000);

		log.info("Click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		// log.info("Call sendContactSellerPopupInSearhPage function.");
		// pageMethodsAllPopup.sendContactSellerPopupInSearhPage(testDataLogin.invalidEmail);
		Thread.sleep(1000);

		/*
		 * log.info("Clear Product name.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.txtProductNamePopup)
		 * ; Thread.sleep(1000); log.info("Enter Product Name");
		 * frameworkMethods.enter_Text(pageControlAllPopups.txtProductNamePopup,
		 * enum_addProduct.productName.getValue(lang)); Thread.sleep(1000);
		 * log.info("Clear Message.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtMessageInContactSeller); Thread.sleep(1000);
		 * log.info("Enter Message.");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtMessageInContactSeller,
		 * enum_allPopups.description.getValue(lang));
		 * log.info("Clear Quantity textbox.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtQuantityInContactSeller); Thread.sleep(1000);
		 * log.info("Enter Quantity in quantity textbox");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtQuantityInContactSeller,
		 * enum_addProduct.minimumOrderQuantity.getValue(lang));
		 * Thread.sleep(1000);
		 * 
		 * log.info("Select Unit.");
		 * frameworkMethods.select_Value_On_DropDown(pageControlAllPopups.
		 * ddlQuantityUnitInContactSeller,
		 * enum_addProduct.exwPriceUnit.getValue(lang)); Thread.sleep(1000); //
		 * log.info("Attach Product Details.docx file."); //
		 * frameworkMethods.ImageUpload(pageControlAllPopups.attachFile, //
		 * testDataCommon.attachDocxFile); log.info("Clear Name.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtNameInContactSeller); Thread.sleep(1000); log.info("Enter Name.");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtNameInContactSeller, enum_mainContact.firstName.getValue(lang) +
		 * "" + enum_mainContact.lastName.getValue(lang)); Thread.sleep(1000);
		 * log.info("Clear Email.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtEmailInContactSeller); Thread.sleep(1000);
		 * log.info("Enter Email.");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtEmailInContactSeller, testDataLogin.invalidEmail);
		 * Thread.sleep(1000); log.info("Clear Country Code.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtCountryCodeInContactSeller); Thread.sleep(1000);
		 * log.info("Enter Country Code.");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtCountryCodeInContactSeller,
		 * enum_mainContact.mobileCountryCode.getValue(lang));
		 * Thread.sleep(1000); log.info("Clear mobile Number.");
		 * frameworkMethods.clear_Text(pageControlAllPopups.
		 * txtNumberInContactSeller); Thread.sleep(1000);
		 * log.info("Enter mobile Number.");
		 * frameworkMethods.enter_Text(pageControlAllPopups.
		 * txtNumberInContactSeller,
		 * enum_mainContact.mobileNumber.getValue(lang)); Thread.sleep(1000);
		 * log.info("Click on Send Requirement at Requirement form.");
		 * frameworkMethods.clickOnLink(pageControlAllPopups.
		 * btnSubmitYourRequirement);
		 */

		log.info("Call sendContactSellerPopupInSearhPage function.");
		pageMethodsAllPopup.sendContactSellerPopupInSearhPage(testDataLogin.invalidEmail);
		frameworkMethods.waitTillElementAppears(pageControlsCommon.successMessage);
		log.info("Verify validation message");
		String strSuccessMsg = frameworkMethods.get_LableText(pageControlsCommon.successMessage);
		Assert.assertEquals(strSuccessMsg, enum_allPopups.contactSellerSucessfullyMessageWithoutlogin.getValue(lang),
				"Confirmation message does noot match.");
		frameworkMethods.waitTillElementAppears(pageControlsCommon.successMessage);
		log.info("Verify registration popup is open or not .");
		log.info("Get page title .");
		String strlLabel = frameworkMethods.get_LableText(pageControlsStaticPages.lblpopupTitle);
		System.out.println("Title ::  " + strlLabel);
		Thread.sleep(2000);
		Assert.assertEquals(strlLabel, enum_staticPage.loginOrRegisterPopupTitle.getValue(lang),
				"Register popup is not open");
		log.info("Click on close button on popup");
		frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
		Thread.sleep(2000);

	}

	// Verify required field validation message in contact seller pop up.(In
	// Seller tab)
	@Test(priority = 49)
	public void verifyRequiredFieldValidationMsgInContactSellerPopupInSellerTab() throws Exception {
		Thread.sleep(1000);
		try {
			log.info("Click on seller tab");
			frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
			Thread.sleep(3000);

			log.info("Click on contact seller button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
			Thread.sleep(1000);
			log.info("Clear quantity field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtQuantityInContactSeller);
			Thread.sleep(1000);
			log.info("Clear quantity unit field.");
			frameworkMethods.clear_Value_On_DropDown(pageControlAllPopups.ddlQuantityUnitInContactSeller);
			Thread.sleep(1000);
			log.info("Clear  text Name field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtNameInContactSeller);
			Thread.sleep(1000);
			log.info("Clear Email text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtEmailInContactSeller);
			Thread.sleep(1000);
			log.info("Clear Country code text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtCountryCodeInContactSeller);
			Thread.sleep(1000);
			log.info("Clear mobile number text field.");
			frameworkMethods.clear_Text(pageControlAllPopups.txtNumberInContactSeller);
			Thread.sleep(1000);
			log.info("Click on SubmitYourRequirment button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnSubmitYourRequirement);
			Thread.sleep(2000);

			Thread.sleep(1000);
			log.info("Verify the message required field validation message.");
			String reqValMessage = frameworkMethods.get_LableText(pageControlsSearch.reqValDescripContactSellPopup);
			Assert.assertEquals(reqValMessage, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Message required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the required field validation message in quantity field.");
			String reqValQuantity = frameworkMethods.get_LableText(pageControlsSearch.reqValQuantityContactSellPopup);
			Assert.assertEquals(reqValQuantity, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Quantity required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the required field validation message in quantity unit field.");
			String reqValQuantityUnit = frameworkMethods
					.get_LableText(pageControlsSearch.reqValQuantityUnitContactSellPopup);
			Assert.assertEquals(reqValQuantityUnit, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Quantity required field validation message does not match..");
			Thread.sleep(1000);

			log.info("Verify the Name required field validation message.");
			String reqValName = frameworkMethods.get_LableText(pageControlsSearch.reqValNameContactSellPopup);
			Assert.assertEquals(reqValName, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Name required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Email required field validation message.");
			String reqValEmail = frameworkMethods.get_LableText(pageControlsSearch.reqValEmailContactSellPopup);
			String strEmailActual = enum_validationMessage.requiredFieldValidation.getValue(lang) + " "
					+ enum_validationMessage.invalidEmailFieldValidation.getValue(lang);
			log.info("Actual Email validation message :::" + strEmailActual);
			Assert.assertEquals(reqValEmail, strEmailActual,
					"Email required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Country code required field validation message.");
			String reqValCountryCode = frameworkMethods
					.get_LableText(pageControlsSearch.reqValCountryCodeContactSellPopup);
			Assert.assertEquals(reqValCountryCode, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Country code required field validation message does not match..");
			Thread.sleep(1000);
			log.info("Verify the Number required field validation message.");
			String reqValNumber = frameworkMethods.get_LableText(pageControlsSearch.reqValNumberContactSellPopup);
			Assert.assertEquals(reqValNumber, enum_validationMessage.requiredFieldValidation.getValue(lang),
					"Mobile number required field validation message does not match..");

		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}

	}

	// To verify invalid email validation at Contact Seller Popup (In Seller
	// tab)
	@Test(priority = 50, groups = { "Regression" })
	public void verifyEmailValidationOnContactSellerPopupInSellerTab() throws Exception {
		log.info("Click on seller tab");
		frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
		Thread.sleep(3000);
		log.info("click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		Thread.sleep(1000);

		try {
			Thread.sleep(2000);
			String[] invalidEmail = { "utkarsh.patel", "utkarsh@patel@bcssarl.com", "utkarsh.@bcssarl..com",
					"@bcssarl.com", "utkarsh.bcssarl.com", "Ã£ï¿½â€šÃ£ï¿½â€žÃ£ï¿½â€ Ã£ï¿½Ë†Ã£ï¿½Å @example.com", "email@bcssarl..com" };

			for (int i = 0; i <= invalidEmail.length - 1; i++) {
				Thread.sleep(2000);
				log.info("Clear email field.");
				frameworkMethods.clear_Text(pageControlAllPopups.txtEmailInContactSeller);
				Thread.sleep(1000);
				log.info("Enter email field.");
				frameworkMethods.enter_Text(pageControlAllPopups.txtEmailInContactSeller, invalidEmail[i]);
				Thread.sleep(2000);
				log.info("Click on send button.");
				frameworkMethods.clickOnLink(pageControlAllPopups.btnSubmitYourRequirement);
				Thread.sleep(2000);
				log.info("Verify invalid email validation message.");
				String emailValMsgActual = frameworkMethods
						.get_LableText(pageControlsSearch.reqValEmailContactSellPopup);
				Assert.assertEquals(emailValMsgActual,
						enum_validationMessage.invalidEmailFieldValidation.getValue(lang),
						"Invalid email validation does not match..." + invalidEmail[i]);
			}

		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// To verify Mobile number (Country code and number) field validation on
	// Contact seller popup (In Seller Tab)
	// @Test(priority = 51, groups = { "Regression" })
	public void verifyMobileNumberValidationOnContactSellerInSellerTab() throws Exception {
		try {
			Thread.sleep(1000);
			log.info("Click on seller tab");
			frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
			Thread.sleep(3000);
			log.info("click on contact seller button.");
			frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
			Thread.sleep(2000);

			log.info("To verify country code in Characters should not allowed.");
			String strChar = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtCountryCodeInContactSeller, enum_common.character.getValue(lang));
			Assert.assertEquals(strChar, "", "Characters should not allowed in Country code field.");
			Thread.sleep(2000);

			log.info("To verify Country code in Special Characters should not allowed.");
			String strSpecChar = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtCountryCodeInContactSeller, enum_common.specialCharacter.getValue(lang));
			Assert.assertEquals(strSpecChar, ",+", "Special Characters should not allowed in Country code field.");

			log.info("To verify Mobile number in Characters should not allowed.");
			String strCharNuber = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtNumberInContactSeller, enum_common.character.getValue(lang));
			Assert.assertEquals(strCharNuber, "", "Characters should not allowed in mobile number field.");
			Thread.sleep(2000);

			log.info("To verify Mobile number in Special Characters should not allowed.");
			String strSpecCharNumber = pageMethods.charOrSpecCharNotAllowedInNumericField(
					pageControlAllPopups.txtNumberInContactSeller, enum_common.specialCharacter.getValue(lang));
			Assert.assertEquals(strSpecCharNumber, "", "Special Characters should not allowed in mobile number field.");

		} catch (Exception e) {
			Assert.fail("Element is not found...");
		} finally {
			log.info("Click on close button on popup");
			frameworkMethods.clickOnLink(pageControlsStaticPages.btnClosePopup);
			Thread.sleep(2000);
		}
	}

	// Verify click on contact seller button ,page should be redirect to product
	// detail page or not.
	// 2)Verify focus is going to Message text field in Send your requirements
	// to this sellers form or not
	// @Test(priority = 52, groups = { "Regression" })
	public void verifyContactSellerBtnRedirctToProductDetail() throws Exception {
		String strProductNameExpect = frameworkMethods.get_LableText(pageControlsSearch.lblProductName);
		log.info("Click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		Thread.sleep(2000);
		log.info("Get Product Name in contact us popup");
		String strProductNameActual = frameworkMethods.get_LableText(pageControlsViewProductDetails.productName);
		log.info("Verify product name in contact seller popup.");
		Assert.assertEquals(strProductNameActual, strProductNameExpect, "Product name does not match.");
		Thread.sleep(2000);
		log.info("Check focus is going to message field or not.");
		boolean focusElement = driver.findElement(pageControlAllPopups.txtMsgSendYourMsgSupplier)
				.equals(driver.switchTo().activeElement());
		Assert.assertEquals(focusElement, true, "Focus is not display in message text field.");
	}

	// Verify click on contact seller button in seller tab ,page should be
	// redirect to Seller
	// detail page or not.
	// 2)Verify focus is going to Message text field in Send your requirements
	// to this sellers form or not
	// @Test(priority = 53, groups = { "Regression" })
	public void verifyContactSellerBtnRedirctToSellerDetail() throws Exception {
		String strSellerNameExpect = frameworkMethods.get_LableText(pageControlsSearch.lblsellerName);
		log.info("Click on Search page.");
		frameworkMethods.clickOnLink(pageControlsSearch.tabSellerClick);
		Thread.sleep(2000);
		log.info("Click on contact seller button.");
		frameworkMethods.clickOnLink(pageControlAllPopups.btnContactSeller);
		Thread.sleep(2000);
		log.info("Get Product Name in contact us popup");
		String strSellerNameActual = frameworkMethods.get_LableText(pageControlsViewCompanyDetailPage.companyNameTitle);
		log.info("Verify product name in contact seller popup.");
		Assert.assertEquals(strSellerNameActual, strSellerNameExpect, "Product name does not match.");
		Thread.sleep(2000);
		log.info("Check focus is going to message field or not.");
		boolean focusElement = driver.findElement(pageControlAllPopups.txtMsgSendYourMsgSupplier)
				.equals(driver.switchTo().activeElement());
		Assert.assertEquals(focusElement, true, "Focus is not display in message text field.");
	}

}
