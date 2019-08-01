package zoodel.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import zoodel.base.*;
import zoodel.testdata.*;

public class Page_Methods extends TestBase {
	private static final Logger log = Logger.getLogger(Page_Methods.class.getName());

	// public static enum_language lang = enum_language.en;

	// ======== Common methods for login functionality===============
	// User logIn method for [public side
	public void loggedIn(String email, String password) throws Exception {

		try {
			log.info("Click on login link.");
			frameworkMethods.clickOnLink(pageControlsLogin.lnkLogin);
			Thread.sleep(1000);
			log.info("Enter the email id." + email);
			frameworkMethods.clear_Text(pageControlsLogin.txtEmail);
			Thread.sleep(1000);
			frameworkMethods.enterTextJavaScript(pageControlsLogin.txtEmail, email);
			Thread.sleep(1000);
			log.info("Enter the password." + password);
			frameworkMethods.clear_Text(pageControlsLogin.txtPassword);
			Thread.sleep(1000);
			frameworkMethods.enterTextJavaScript(pageControlsLogin.txtPassword, password);
			Thread.sleep(1000);
			log.info("Click on Login button.");
			frameworkMethods.clickOnLink(pageControlsLogin.btnLogin);
			Thread.sleep(1000);
			// Thread.sleep(5000);

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// User logOut method for public side
	public void loggedOut() throws Exception {

		log.info("Scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		log.info("Click on Logo .");
		frameworkMethods.clickOnLink(pageControlsCommon.logo);
		Thread.sleep(2000);
		log.info("Verify login link is present or not.");
		boolean _match = driver.findElements(pageControlsLogin.lnkLogin).size() > 0;
		Thread.sleep(5000);
		if (!_match) {
			log.info("Click on user name at heder dropdown.");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			frameworkMethods.clickOnLink(pageControlsCommon.header_dropdownInner);
			Thread.sleep(2000);
			log.info("Click on log out in heder dropdown.");
			frameworkMethods.clickOnLink(pageControlsLogin.lnkLogOut);
		} else {
			log.info("User is already login");
		}
	}

	// User go To MyAccount method
	public void goToMyAccount() throws Exception {

		try {
			Thread.sleep(4000);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Click on user name at header dropdown.");
			frameworkMethods.clickOnLink(pageControlsCommon.heder_dropdown);
			Thread.sleep(2000);
			log.info("Click on My account link in header dropdown.");
			WebElement element = driver.findElement(pageControlsCommon.myAccountLink);
			String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script, element);
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// =============Product page method=====================

	// Product Name is present or not
	public int SearchProduct(By ProdRowsCollection, By productName, String strProductname) {
		List<WebElement> ProductRowsCollection = driver.findElements(ProdRowsCollection);
		System.out.println("ProductRow colloection:::" + ProductRowsCollection.size());
		int productRowIndex = 0;
		for (WebElement ProductRow : ProductRowsCollection) {

			WebElement prodName = ProductRow.findElement(productName);
			System.out.println("Product Title:--" + prodName.getText());

			if (prodName.getText().trim().equals(strProductname)) {
				System.out.println("\r\n Product FOUND - {0} " + prodName.getText());
				System.out.println("\r\n  AT ROWINDEX- {0}" + productRowIndex);
				break;
			}
			if (productRowIndex == ProductRowsCollection.size() - 1) {
				try {
					Thread.sleep(2000);
					frameworkMethods.clickOnLink(pageControlsSearch.btnViewMore1);

				} catch (Exception e) {
					System.out.println("Product Not found.");
				}
				SearchProduct(ProdRowsCollection, productName, strProductname);
			}

			productRowIndex++;
		}
		return productRowIndex;
	}

	// Product modify, Preview.
	public int SearchProductRow(String strProductName) throws Exception {
		boolean flag = false;
		int productRowIndex;
		do {
			productRowIndex = 0;
			List<WebElement> rowCollection = driver.findElements(pageControlsSearch.productRowCollectionst);
			System.out.println("Product row colllection:::" + rowCollection.size());
			Thread.sleep(1000);
			for (WebElement element : rowCollection) {
				String strProdName = element.findElement(pageControlsSearch.productNameTextst).getText();
				System.out.println("Product Title:::" + strProdName);
				if (strProdName.equals(strProductName)) {
					flag = true;
					break;
				}
				productRowIndex++;
			}
			if (!flag) {
				Thread.sleep(3000);
				WebElement btnViewmore = driver.findElement(pageControlsSearch.btnViewMore1);
				String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(script, btnViewmore);
				js.executeScript("arguments[0].click();", btnViewmore);
				Thread.sleep(1000);
			}

		} while (!flag);

		return productRowIndex;
	}

	// Product modify, Preview.
	public void clickLink(String strProductName, String linkText) throws Exception {
		boolean flag = false;
		do {
			List<WebElement> rowCollection = driver.findElements(pageControlsSearch.productRowCollectionst);
			Thread.sleep(1000);
			for (WebElement element : rowCollection) {
				String strProdName = element.findElement(pageControlsSearch.productNameTextst).getText();
				// System.out.println("Product Name::" + strProdName);
				if (strProdName.equals(strProductName)) {
					System.out.println("Product Name::" + strProdName);
					flag = true;
					Thread.sleep(3000);
					WebElement link = element.findElement(By.linkText(linkText));
					String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(script, element);
					js.executeScript("arguments[0].click();", link);
					break;
				}
			}
			Thread.sleep(2000);
			if (!flag) {
				Thread.sleep(3000);
				// driver.findElement(pageControlsSellerTools.btnViewMore).click();
				frameworkMethods.clickOnLink(pageControlsSearch.btnViewMore1);
			}
		} while (!flag);

	}

	// Click on Remove link for selected Product Name
	public void clickRemoveLink(String strProductName) throws Exception {
		Thread.sleep(2000);
		boolean flag = false;
		do {
			List<WebElement> rowCollection = driver.findElements(pageControlsSearch.productRowCollectionst);
			Thread.sleep(2000);
			for (int i = 1; i <= rowCollection.size(); i++) {
				String strProdName = driver
						.findElement(
								By.xpath("//div[@class='my-account-right-box']/ul/li[" + i + "]//descendant::div/h3"))
						.getText();
				System.out.println("Product Row::" + i);
				Thread.sleep(2000);
				if (strProdName.equals(strProductName)) {
					System.out.println("Product Name::" + strProdName);
					WebElement removeProductLink = driver
							.findElement(By.xpath("//div[@class='my-account-right-box']/ul/li[" + i
									+ "]//descendant::span[@id='btnRemoveProduct']"));
					System.out.println("Link Name::" + removeProductLink.getText());
					String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(script, removeProductLink);
					js.executeScript("arguments[0].click();", removeProductLink);
					flag = true;
					break;
				}
			}
			Thread.sleep(2000);
			if (!flag) {
				Thread.sleep(3000);
				log.info("Click on View more button.");
				frameworkMethods.clickOnLink(pageControlsSearch.btnViewMore1);
			}
		} while (!flag);
	}

	// Click on Unpublish link for selected Product Name
	public void clickUnpublishLink(By prodLinksCollections, int productRowIndex) {
		List<WebElement> productLinksCollections = driver.findElements(prodLinksCollections);
		WebElement productLinks = productLinksCollections.get(productRowIndex);
		WebElement unpublishProductLink = productLinks.findElement(By.id("btnPublishUnpublish"));
		String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, unpublishProductLink);
		js.executeScript("arguments[0].click();", unpublishProductLink);
	}

	// Product unpublish .....
	public void clickUnpublish(String strProductName, By locator) throws Exception {
		boolean flag = false;
		do {
			List<WebElement> rowCollection = driver.findElements(pageControlsSearch.productRowCollectionst);
			Thread.sleep(1000);
			for (WebElement element : rowCollection) {
				Thread.sleep(1000);
				String strProdName = element.findElement(pageControlsSearch.productNameTextst).getText();
				Thread.sleep(2000);
				if (strProdName.equals(strProductName)) {
					flag = true;
					WebElement lnkPublish = element.findElement(locator);
					String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(script, lnkPublish);
					js.executeScript("arguments[0].click();", lnkPublish);

					break;
				}
			}

			if (!flag) {
				Thread.sleep(4000);
				driver.findElement(pageControlsSearch.btnViewMore1).click();
			}
		} while (!flag);

	}

	
	// Get Product Status
	public String getProductStatus(By labelcollection, By statusLabel, int productRowIndex) {
		List<WebElement> labelCollections = driver.findElements(labelcollection);
		WebElement label = labelCollections.get(productRowIndex);
		WebElement statLabel = label.findElement(statusLabel);
		return statLabel.getText();

	}

	// Product Name is present or not
	public boolean SearchProductName(By ProdRowsCollection, By productName, String strProductname) {
		boolean product = false;
		List<WebElement> ProductRowsCollection = driver.findElements(ProdRowsCollection);
		int productRowIndex = 0;
		for (WebElement ProductRow : ProductRowsCollection) {

			WebElement prodName = ProductRow.findElement(productName);
			System.out.println("Product Title" + prodName.getText());

			if (prodName.getText().trim().equals(strProductname)) {
				System.out.println("\r\n Product FOUND - {0} " + prodName.getText());
				System.out.println("\r\n  AT ROWINDEX- {0}" + productRowIndex);
				product = true;
				break;
			}

			if (productRowIndex == ProductRowsCollection.size() - 1) {
				try {
					Thread.sleep(2000);
					frameworkMethods.click_On_Button(pageControlsSearch.btnViewMore1);

				} catch (Exception e) {

					System.out.println("Product Not found.");
				}
				SearchProductName(ProdRowsCollection, productName, strProductname);
			}

			productRowIndex++;
		}
		return product;
	}

	// Tab is active or not
	public boolean ActiveTab(By tabLocator) {

		try {
			driver.findElement(tabLocator).getAttribute("class").contains("active");

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Validate Product information in seller tools
	public boolean validateProductDetailInSellerTool(String Type, String Photos, String Category,
			boolean ProductDetails, boolean Description, boolean TradeInfo, int productRowIndex) {
		boolean _blnDetailMatched = false;

		List<WebElement> detailsCollection = driver.findElements(By.className("list-unstyled"));
		WebElement selectedProductDetails = detailsCollection.get(productRowIndex);
		List<WebElement> actualProductDetails = selectedProductDetails.findElements(By.tagName("span"));

		// Type
		String actualType = actualProductDetails.get(1).getText();
		boolean _blnDetailMatched1 = actualType.equals(Type);
		log.info("Type Comparison..... Actual: " + actualType + "   Expected: " + Type);
		// Photos
		String actualPhotos = actualProductDetails.get(3).getText();
		boolean _blnDetailMatched2 = actualPhotos.equals(Photos);
		log.info("Photos Comparison..... Actual: " + actualPhotos + "  Expected: " + Photos);
		System.out.println(String.format("Photos Comparison..... Actual:%1s  Expected:%2s", actualPhotos, Photos));

		// Category
		String actualCategory = actualProductDetails.get(5).getText();
		boolean _blnDetailMatched3 = actualCategory.equals(Category);
		log.info("Category Comparison..... Actual :" + actualCategory + " Expected: " + Category);
		System.out
				.println(String.format("Category Comparison..... Actual:%1s  Expected:%2s", actualCategory, Category));

		// Product detail
		String actualProductDetail = actualProductDetails.get(7).getText();
		boolean _blnDetailMatched4;
		if (actualProductDetail.equals("--")) {
			boolean blnActualProductDetail = false;
			_blnDetailMatched4 = blnActualProductDetail && ProductDetails;
			log.info("Product Detail Comparison..... Actual: " + String.valueOf(blnActualProductDetail) + " Expected: "
					+ String.valueOf(ProductDetails));
			System.out.println(String.format("Product Detail Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualProductDetail), String.valueOf(ProductDetails)));
		} else {
			boolean blnActualProductDetail = actualProductDetails.get(7).findElement(By.tagName("img"))
					.getAttribute("src").contains("icon_right");
			_blnDetailMatched4 = blnActualProductDetail && ProductDetails;
			log.info("Product Detail Comparison..... Actual:" + String.valueOf(blnActualProductDetail) + " Expected: "
					+ String.valueOf(ProductDetails));
			System.out.println(String.format("Product Detail Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualProductDetail), String.valueOf(ProductDetails)));
		}

		// Description
		String actualDescription = actualProductDetails.get(9).getText();
		boolean _blnDetailMatched5;
		if (actualDescription.equals("--")) {
			boolean blnActualDescription = false;
			_blnDetailMatched5 = blnActualDescription && Description;
			log.info("Description Comparison..... Actual:%1s  Expected:%2s" + String.valueOf(blnActualDescription)
					+ String.valueOf(Description));
			System.out.println(String.format("Description Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualDescription), String.valueOf(Description)));
		} else {
			boolean blnActualDescription = actualProductDetails.get(9).findElement(By.tagName("img"))
					.getAttribute("src").contains("icon_right");
			_blnDetailMatched5 = blnActualDescription && Description;
			log.info("Description Comparison..... Actual:%1s  Expected:%2s" + String.valueOf(blnActualDescription)
					+ String.valueOf(Description));
			System.out.println(String.format("Description Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualDescription), String.valueOf(Description)));
		}
		// Trade Info
		String actualTradeInfo = actualProductDetails.get(11).getText();
		boolean _blnDetailMatched6;
		if (actualTradeInfo.equals("--")) {
			boolean blnActualTradeInfo = false;
			_blnDetailMatched6 = blnActualTradeInfo && TradeInfo;
			log.info("Trade Info Comparison..... Actual:%1s  Expected:%2s" + String.valueOf(blnActualTradeInfo)
					+ String.valueOf(TradeInfo));
			System.out.println(String.format("Trade Info Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualTradeInfo), String.valueOf(TradeInfo)));
		} else {
			boolean blnActualTradeInfo = actualProductDetails.get(11).findElement(By.tagName("img")).getAttribute("src")
					.contains("icon_right");
			_blnDetailMatched6 = blnActualTradeInfo && Description;
			log.info("Trade Info Comparison..... Actual: " + String.valueOf(blnActualTradeInfo) + "  Expected: "
					+ String.valueOf(TradeInfo));
			System.out.println(String.format("Trade Info Comparison..... Actual:%1s  Expected:%2s",
					String.valueOf(blnActualTradeInfo), String.valueOf(TradeInfo)));
		}

		System.out.println(
				actualType + actualPhotos + actualCategory + actualProductDetail + actualDescription + actualTradeInfo);

		/*
		 * String actualUpdated = actualProductDetails.get(13).getText();
		 * _blnDetailMatched = actualUpdated.equals(Updated);
		 * System.out.println(
		 * String.format("Updated Comparison..... Actual:%1s  Expected:%2s" ,
		 * actualUpdated, Updated))
		 */;

		if (_blnDetailMatched1 && _blnDetailMatched2 && _blnDetailMatched3 && _blnDetailMatched4 && _blnDetailMatched5
				&& _blnDetailMatched6) {
			_blnDetailMatched = true;
		}

		// System.out.println(actualType + actualPhotos + actualCategory +
		// actualProductDetail + actualDescription + actualTradeInfo +
		// actualUpdated);
		return _blnDetailMatched;

	}

	// Select language in public side
	public void LanguageSelectionInPublic() throws Exception {
		System.out.println("Language ::" + lang.toString());
		if (lang.toString().equalsIgnoreCase("en")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on English Flag (Select language English)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlEN);
		} else if (lang.toString().equalsIgnoreCase("fa")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on Farsi Flag (Select language Farsi)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlFA);
		} else if (lang.toString().equalsIgnoreCase("tr")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on Turkish Flag (Select language Turkish)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlTR);
		} else if (lang.toString().equalsIgnoreCase("ru")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on Russian Flag (Select language Russian)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlRU);
		} else if (lang.toString().equalsIgnoreCase("ar")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on Arabic Flag (Select language Arabic)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlAR);
		}else if (lang.toString().equalsIgnoreCase("cn")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on Chinese Flag (Select language chinese)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlCN);
		}  
		else if (lang.toString().equalsIgnoreCase("")) {
			log.info("Click on laguage dropdown");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlLaguage);
			Thread.sleep(1000);
			log.info("Click on English Flag (Select language English)");
			frameworkMethods.clickOnLink(pageControlsCommon.ddlEN);
		}

	}

	// Verify Image field validation
	public void verifyImageExtension(By uploadbtn) throws Exception {
		Thread.sleep(5000);
		String[] extFile = { testDataCommon.htmlFile, testDataCommon.textFile, testDataCommon.docFile,
				testDataCommon.excelFile, testDataCommon.pdfFile };

		for (int i = 0; i <= extFile.length - 1; i++) {
			driver.navigate().refresh();
			Thread.sleep(5000);
			log.info("Click on upload button.");
			frameworkMethods.clickOnLink(uploadbtn);
			frameworkMethods.switchFrame(pageControlsCommon.iframeUpload);
			Thread.sleep(2000);
			log.info("Upload " + extFile[i] + " file.");
			String filePath = extFile[i];
			frameworkMethods.ImageUpload(By.tagName("input"), filePath);
			// Thread.sleep(1000);
			driver.switchTo().defaultContent();
			log.info("Verify uploaded file Extension validation.");
			frameworkMethods.waitTillElementAppears(pageControlsCommon.errorMessage);
			String imageValidationSize = frameworkMethods.get_LableText(pageControlsCommon.errorMessage);
			Assert.assertEquals(imageValidationSize, enum_validationMessage.imageValidationFileFormat.getValue(lang),
					"Verify uploaded file Extension validation message does not match..");
			Thread.sleep(5000);

		}
		// driver.switchTo().defaultContent();
	}

	// Verify Numeric field validation
	public int verifyNumericFieldSize(By numericField, String strSize) throws Exception {
		Thread.sleep(2000);
		log.info("Clear text field.");
		frameworkMethods.clear_Text(numericField);
		Thread.sleep(1000);
		log.info("Enter number.");
		frameworkMethods.enter_Text(numericField, strSize);
		Thread.sleep(2000);
		log.info("Get values is numeric textbox.");
		String strCountryCode1 = frameworkMethods.get_TextValue(numericField);
		int lengthCountry = strCountryCode1.length();
		return lengthCountry;

	}

	// Verify Numeric field validation (should accept Character or special
	// character)
	public String charOrSpecCharNotAllowedInNumericField(By numericField, String strCharOrSpecChar) throws Exception {
		Thread.sleep(2000);
		log.info("Clear text field.");
		frameworkMethods.clear_Text(numericField);
		Thread.sleep(3000);
		log.info("Enter Char Or SpecChar.");
		frameworkMethods.enter_Text(numericField, strCharOrSpecChar);
		Thread.sleep(4000);
		log.info("Get Char Or SpecChar in numeric textbox.");
		String charOrSpecChar = frameworkMethods.get_TextValue(numericField);
		return charOrSpecChar;
	}

	// verify Separate comma in numeric field
	public void verifySeparateComma(By numericField) throws Exception {
		Thread.sleep(2000);
		String separateCommaValue[] = { "1,000", "10,000", "100,000" };
		for (int i = 0; i <= separateCommaValue.length - 1; i++) {
			Thread.sleep(1000);
			log.info("Clear text field.");
			frameworkMethods.clear_Text(numericField);
			Thread.sleep(2000);
			log.info("Enter " + separateCommaValue[i] + ".");
			frameworkMethods.enterTextJavaScript(numericField, separateCommaValue[i]);
			Thread.sleep(3000);
			log.info("To Verify digits value with separate comma " + separateCommaValue[i] + "");
			String getValue = frameworkMethods.get_TextValue(numericField);
			Assert.assertEquals(getValue, separateCommaValue[i], "Separate Comma does not work..");
		}

	}

	public void currentTab(int tabIndex) throws Exception {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = driver.getWindowHandle();
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(tabIndex));
	}

	// Close advertising popup
	public void closeAdvertisingPopup() throws Exception {
		Thread.sleep(8000);
		if (driver.findElements(pageControlsCommon.advertisingPopup).size() > 0) {
			Thread.sleep(2000);
			log.info("Click on close button on tender popup.");
			frameworkMethods.click_On_Link(pageControlsCommon.advertisePopupCloseBtn);
		} else {
			System.out.print("Popup is not present.");
		}
		Thread.sleep(5000);
	}

	// Delete file from screenshot folder
	public void deleteFileInFolder() {
		File index = new File("./Screenshots/");
		String[] entries = index.list();
		int indexSize = entries.length;
		log.info("Index Size=" + indexSize);
		if (indexSize > 0) {
			log.info("Index :" + (index != null));
			if (index != null) {
				for (String s : entries) {
					File currentFile = new File(index.getPath(), s);
					currentFile.delete();
				}
			}
		}
	}

	// Below is the code to select the Option based on the string passed in the
	// Test
	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// login to another user and enter its company name
	/*public void enterCompanyName() throws Exception {
		log.info("Login in to:" + testDataLogin.userEmail);
		pageMethodBuyingRequest.loginIntoAnotherAccount(testDataLogin.userEmail1, testDataLogin.userPassword1);
		Thread.sleep(2000);
		log.info("Go to My account");
		goToMyAccount();
		Thread.sleep(2000);
		log.info("Click on company navigation menu.");
		frameworkMethods.clickOnLink(pageControlsCompanyProfilePage.tabComapny);
		Thread.sleep(1000);
		log.info("Click on company Profile menu.");
		frameworkMethods.clickOnLink(pageControlsCompanyProfilePage.lnkCompanyProfile);
		Thread.sleep(2000);
		log.info("Clear Company Name.");
		frameworkMethods.clear_Text(pageControlsCompanyProfilePage.txtCompanyName);
		Thread.sleep(1000);
		log.info("Enter Company Name: " + enum_companyProfile.companyNameAnotherUser.getValue(lang));
		frameworkMethods.enter_Text(pageControlsCompanyProfilePage.txtCompanyName,
				enum_companyProfile.companyNameAnotherUser.getValue(lang));
		Thread.sleep(1000);
		log.info("Click on Save button at Company profile.");
		frameworkMethods.clickOnLink(pageControlsCompanyProfilePage.btnSaveCompanyprofile);
		Thread.sleep(2000);
		log.info("Click on logout  link");
		frameworkMethods.moveToElement(pageControlsCommon.hoverUserName);
		Thread.sleep(1000);
		frameworkMethods.clickOnLink(pageControlsLogin.lnkLogOut);
		Thread.sleep(2000);

	}*/
	
	

}
