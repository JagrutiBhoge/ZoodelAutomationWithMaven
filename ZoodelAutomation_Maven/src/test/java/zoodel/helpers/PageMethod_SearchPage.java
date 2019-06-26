package zoodel.helpers;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import zoodel.testdata.*;
import zoodel.base.*;

public class PageMethod_SearchPage extends TestBase {

	private static final Logger log = Logger.getLogger(PageMethod_SearchPage.class.getName());

	// public static enum_language lang = enum_language.en;

	// Search Product or seller
	public boolean search(By rowsCollection, By product_or_company_name, String str_product_or_company_name,
			int prevRowIndex) throws Exception {
		boolean flag = false;
		int rowIndex = 1;
		List<WebElement> product_or_company_rowsCollection = driver.findElements(rowsCollection);
		int rowCount = product_or_company_rowsCollection.size();
		System.out.println("\r\n Product Row index -  " + rowCount);
		for (int i = prevRowIndex; i <= rowCount; i++) {
			Thread.sleep(1000);
			System.out.println("\r\n Product Row index -  " + i);
			WebElement productName = product_or_company_rowsCollection.get(i - 1);
			WebElement prodNametxt = productName.findElement(product_or_company_name);
			System.out.println("\r\n Product Name -  " + prodNametxt.getText());
			Thread.sleep(2000);
			if (prodNametxt.getText().trim().equals(str_product_or_company_name)) {
				System.out.println("\r\n Product FOUND -  " + prodNametxt.getText());
				System.out.println("\r\n  AT ROWINDEX- " + rowIndex);
				flag = true;
				break;
			} else if (i == product_or_company_rowsCollection.size()) {
				try {
					Thread.sleep(1000);
					Actions actions1 = new Actions(driver);
					actions1.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
					Thread.sleep(1000);
					boolean isPresent = driver.findElement(pageControlsSearch.btnViewMore).isDisplayed();
					System.out.println("View more button is present or not :::" + isPresent);
					/*
					 * boolean isPresent = frameworkMethods
					 * .IsPresentLocator(pageControlsSearch.btnViewMore);
					 */
					if (isPresent) {
						Thread.sleep(3000);
						log.info("Click on view more button.");
						frameworkMethods.clickOnLink(pageControlsSearch.btnViewMore);
						Thread.sleep(2000);
						return search(rowsCollection, product_or_company_name, str_product_or_company_name, rowCount);
					} else {
						System.out.println("Product Not found.");
						break;
					}

				} catch (Exception e) {
					System.out.println("Product Not found.");
				}

			}

		}
		return flag;
	}

	// Select product option at search page (Inner Page)
	public void selectProductInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select product at Inner page.");
		frameworkMethods.select_Value_On_DropDown(pageControlsSearch.ddlProductInner,
				enum_search.product.getValue(lang));

	}

	// Select seller option at search page (Inner Page)
	public void selectSellerInnerPage() throws Exception {
		Thread.sleep(3000);
		log.info("Select seller at Inner page.");
		frameworkMethods.select_Value_On_DropDown(pageControlsSearch.ddlProductInner,
				enum_search.seller.getValue(lang));
	}

	// Select Product option at search page (Home Page)
	public void selectProductHomePage() throws Exception {
		Thread.sleep(2000);

		Select selctValue = new Select(driver.findElement(pageControlsSearch.ddlProductHome));
		selctValue.selectByVisibleText(enum_search.product.getValue(lang));
		Thread.sleep(4000);

	}

	// Select Seller option at search page (Home Page)
	public void selectSellerHomePage() throws Exception {

		Thread.sleep(2000);
		Select selctValue = new Select(driver.findElement(pageControlsSearch.ddlProductHome));
		selctValue.selectByVisibleText(enum_search.seller.getValue(lang));
		Thread.sleep(4000);

	}

	// You can send parameter like... Premium Seller , Only Iranian Seller etc.
	public boolean verifySellerStatus(By productRowCollections, String SellerStatus1) throws Exception {
		boolean OverallStatusMatching = true;
		Thread.sleep(2000);
		List<WebElement> productRowsCollection = driver.findElements(productRowCollections);
		int rowIndex = 0;
		System.out.println("Total Elements::" + productRowsCollection.size());

		for (WebElement webElement : productRowsCollection) {

			boolean SellerStatusMatching = false; // 0-No Status, 1- Identity
													// Verified status or
													// Bussiness verified, 2-
													// Identity not Verified
			Thread.sleep(1000);
			List<WebElement> imageCollection = webElement.findElements(By.tagName("img"));
			System.out.println("Total Images::" + imageCollection.size());
			for (WebElement image1 : imageCollection) {
				Thread.sleep(1000);
				Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
						image1);
				Thread.sleep(2000);
				if (ImagePresent) {
					Thread.sleep(1000);
					if (image1.getAttribute("alt").contains(SellerStatus1))
						SellerStatusMatching = true;
				}
			}
			rowIndex++;
			log.info("Status for Seller::" + SellerStatusMatching);
			if (SellerStatusMatching == false)
				OverallStatusMatching = false;
			log.info("Overall Status ::" + OverallStatusMatching + "Row Index" + rowIndex);
			// System.out.println("Overall Status ::" + OverallStatusMatching);
		}
		return OverallStatusMatching;
	}

	// You can send parameter like...Identity Verified, Identity Not Verified,
	// Business Verified etc.
	public boolean verifySellerStatusIdentity(By productRowCollections, String SellerStatus1, String SellerStatus2)
			throws Exception {
		boolean OverallStatusMatching = true;
		int rowIndex = 0;
		Thread.sleep(2000);
		List<WebElement> productRowsCollection = driver.findElements(productRowCollections); // By.xpath("//div[@id='products']//descendant::li[@class='col-lg-5
																								// col-md-5
																								// col-sm-5
																								// grid-view']")

		System.out.println("Total Elements::" + productRowsCollection.size());

		for (WebElement webElement : productRowsCollection) {
			boolean SellerStatusMatching = false; // 0-No Status, 1- Identity
													// Verified status or
													// Bussiness verified, 2-
													// Identity not Verified
			Thread.sleep(1000);
			List<WebElement> imageCollection = webElement.findElements(By.tagName("img"));
			System.out.println("Total Images::" + imageCollection.size());
			for (WebElement image1 : imageCollection) {
				Thread.sleep(1000);
				Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
						image1);
				Thread.sleep(2000);
				if (ImagePresent) {
					Thread.sleep(1000);
					if (image1.getAttribute("alt").contains(SellerStatus1)
							|| image1.getAttribute("alt").contains(SellerStatus2))
						SellerStatusMatching = true;
				}
			}
			rowIndex++;
			log.info("Identity Verification Status for Seller::" + SellerStatusMatching);
			if (SellerStatusMatching == false)
				OverallStatusMatching = false;
			log.info("Overall Identity Verification Status ::" + OverallStatusMatching + "Row Index" + rowIndex);

		}
		return OverallStatusMatching;
	}

	// Select value on CheckBox(Multiple check boxes selection)
	public void selectValueOnCheckBoxInSearchWithProduct(By chkBoxCollection, By labelText, By getInput, String Text) {

		try {
			List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
			log.info("Checkbox collection count :-" + chkBoxCollections.size());
			for (WebElement webElement : chkBoxCollections) {
				Thread.sleep(1000);
				WebElement getLable = webElement.findElement(labelText);
				WebElement getInput1 = webElement.findElement(getInput);

				String str = getLable.getText();
				System.out.println(str);
				int index = str.indexOf("(");
				String strlabel = str.substring(0, index).trim();
				System.out.println(strlabel);
				if (strlabel.equals(Text)) {
					if (!getInput1.isSelected()) {
						Thread.sleep(2000);
						String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript(script, getLable);
						js.executeScript("arguments[0].click();", getLable);
						Thread.sleep(3000);
						// getLable.click();
						break;
					}
				}
			}

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// Select value on CheckBox(Multiple check boxes selection)
	public void selectValueOnCheckBoxInSearchWithSeller(By chkBoxCollection, By labelText, By getInput, String Text) {

		try {
			List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
			for (WebElement webElement : chkBoxCollections) {
				WebElement getLable = webElement.findElement(labelText);

				WebElement getInput1 = webElement.findElement(getInput);
				String str = getLable.getText();
				if (str.equals(Text)) {
					if (!getInput1.isSelected()) {
						String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript(script, getLable);
						js.executeScript("arguments[0].click();", getLable);
						// getLable.click();
						break;
					}
				}
			}

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// Click on Broad Beans sub class at left side in search page
	public void clickOnBroadBeansWithSeller() throws Exception {

		String strClass ="Broad Beans"; //enum_addProduct.class1.getValue(lang);
		log.info("Click on view More less.");
		frameworkMethods.clickOnLink(pageControlsSearch.viewMoreLess);

		log.info("Find the Broad Beans class.");
		List<WebElement> classList = driver.findElements(pageControlsSearch.chkClassCollection);
		System.out.println("Class List count" + classList.size());
		for (WebElement webElement : classList) {

			WebElement lblClass = webElement.findElement(By.tagName("h6"));
			System.out.println(lblClass.getText());
			String strClassLabel = lblClass.getText();
			if (strClassLabel.equals(strClass)) {
				log.info("Click on Broad Beans class.");
				// lblClass.click();
				String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(script, lblClass);
				js.executeScript("arguments[0].click();", lblClass);
				break;
			}
		}
	}

	// Click on Broad Beans sub class at left side in search page
	public void clickOnBroadBeansWithProduct() throws Exception {

		String strClass = "Broad Beans";//enum_addProduct.class1.getValue(lang);
		log.info("Click on view More less.");
		frameworkMethods.clickOnLink(pageControlsSearch.viewMoreLess);

		log.info("Find the Broad Beans class.");
		List<WebElement> classList = driver.findElements(pageControlsSearch.chkClassCollection);
		System.out.println("Class List count" + classList.size());
		for (WebElement webElement : classList) {
			Thread.sleep(1000);
			WebElement lblClass = webElement.findElement(By.tagName("h6"));
			System.out.println(lblClass.getText());
			String str = lblClass.getText();
			// String[] StrClassArray= str.split("(");
			int index = str.indexOf("(");
			String strClasslabel = str.substring(0, index).trim();
			// String strClassLabel=StrClassArray[0].trim();
			System.out.println(strClasslabel);

			if (strClasslabel.equals(strClass)) {
				log.info("Click on Broad Beans class.");
				String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(script, lblClass);
				js.executeScript("arguments[0].click();", lblClass);
				break;
			}
		}
	}

}
