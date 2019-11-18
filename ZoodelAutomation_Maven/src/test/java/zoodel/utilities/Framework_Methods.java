package zoodel.utilities;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import zoodel.base.*;

public class Framework_Methods extends TestBase {
	private static final Logger log = Logger.getLogger(Framework_Methods.class.getName());

	// public static enum_language lang = enum_language.en;

	//
	public void waitTillElementAppears(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	
	public void waitTillElementDisappears(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// ========================== Text Box ==========================
	// Set text box
	public void enter_Text(By locator, String text) {
		try {
			waitTillElementAppears(locator);
			WebElement element = driver.findElement(locator);
			Thread.sleep(2000);
			element.sendKeys(text);
		} catch (Exception e) {
			log.info("Not yet implemented." + e);

		}
	}

	// Enter text in using java script.
	public void enterTextJavaScript(By locator, String text) {
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		
		WebElement searchbox = driver.findElement(locator);
		myExecutor.executeScript("arguments[0].value= '" + text + "';", searchbox);
	}

	// Clear text box
	public void clear_Text(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Thread.sleep(1000);
			element.clear();
		} catch (Exception e) {
			log.info("Not yet implemented." + e);

		}
	}

	// Get value (Text box value)
	public String get_TextValue(By locator) {
		String result = "";
		try {
			// waitTillElementAppears(locator);
			WebElement element = driver.findElement(locator);
			result = element.getAttribute("value").toString();

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
		return result;
	}

	// Get value (label and confirmation message)
	public String get_LableText(By locator) {
		String result = "";
		try {
			// waitTillElementAppears(locator);
			WebElement element = driver.findElement(locator);
			Thread.sleep(2000);
			result = element.getText().toString();

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
		return result;
	}

	// ========================== Link Text ==========================
	// Click on link
	public void click_On_Link(By locator) {
		try {
			waitTillElementAppears(locator);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
	}

	// Using Java Script
	public void clickOnLink(By locator) {
		try {

			WebElement element = driver.findElement(locator);
			String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script, element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
	}

	// ========================== Button ==========================
	// Click on Button
	public void click_On_Button(By locator) {
		try {
			waitTillElementAppears(locator);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
	}

	// ========================== DropDown ==========================

	// Select value on DropDown
	public void select_Value_On_DropDown(By ddlLocator, String Text) {
		try {
			Thread.sleep(2000);
			Select selctValue = new Select(driver.findElement(ddlLocator));
			Thread.sleep(1000);
			selctValue.selectByVisibleText(Text);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	public void clear_Value_On_DropDown(By ddlLocator) {
		try {
			Thread.sleep(1000);
			Select selctValue = new Select(driver.findElement(ddlLocator));
			selctValue.selectByIndex(0);
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// Get value on DropDown - Jagruti
	public String get_Value_On_DropDown(By ddlLocator) {
		String SelectByValue = "";
		try {
			Select Se = new Select(driver.findElement(ddlLocator));
			WebElement SelectedOption = Se.getFirstSelectedOption();
			SelectByValue = SelectedOption.getText().trim();
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

		return SelectByValue;
	}

	// ========================== CheckBox ==========================

	// Select value on CheckBox(Multiple check boxes selection)
	public void select_value_On_CheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {

		try {
			List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
			for (WebElement webElement : chkBoxCollections) {
				WebElement getLable = webElement.findElement(labelText);
				WebElement getInput1 = webElement.findElement(getInput);
				System.out.println(getLable.getText());
				if (getLable.getText().equals(Text)) {
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

	public void clear_value_On_CheckBox(By chkBoxCollection, By labelText, By getInput) {

		try {
			List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
			for (WebElement webElement : chkBoxCollections) {
				WebElement getLable = webElement.findElement(labelText);
				WebElement getInput1 = webElement.findElement(getInput);

				// if (getLable.getText().equals(Text)) {
				if (getInput1.isSelected()) {
					// getLable.click();
					String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(script, getLable);
					js.executeScript("arguments[0].click();", getLable);

					// break;
				}
				// }
			}

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}

	}

	// Get value on selected check box
	public boolean get_Value_On_CheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {
		boolean b = false;
		try {
			List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
			for (WebElement webElement : chkBoxCollections) {
				WebElement getLable = webElement.findElement(labelText);
				WebElement getInput1 = webElement.findElement(getInput);

				if (getLable.getText().equals(Text)) {
					if (getInput1.isSelected()) {
						b = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			log.info("Not yet implemented." + e);
			b = false;
		}
		return b;
	}

	// ========================== Radio Button ==========================
	// Select value on Radio Button
	public void select_value_On_RadioButton(By rbtnCollection, By rbtnLabel, String strText) throws Exception {

		List<WebElement> RadioList = driver.findElements(rbtnCollection);
		int radioBtnIndex = 0;
		for (WebElement radiobtn : RadioList) {
			WebElement rbtnName = radiobtn.findElement(rbtnLabel);
			if (rbtnName.getText().trim().equals(strText)) {
				System.out.println("Radio button Text:--" + rbtnName.getText());
				// rbtnName.click();
				Thread.sleep(1000);
				String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(script, rbtnName);
				js.executeScript("arguments[0].click();", rbtnName);
				break;
			}
			radioBtnIndex++;
			System.out.print("Radio button index::" + radioBtnIndex);
		}

	}

	// Get value on radio button
	public boolean get_Value_On_RadioButton(By rbtnCollection, By rbtnLabel, By rbtnText, String Text) {
		boolean b = false;
		List<WebElement> rbtnCollections = driver.findElements(rbtnCollection);
		for (WebElement radiobtn : rbtnCollections) {
			WebElement getLable = radiobtn.findElement(rbtnLabel);
			WebElement getInput = radiobtn.findElement(rbtnText);

			if (getLable.getText().equals(Text)) {
				System.out.println("Get label" + getLable.getText());
				if (getInput.isSelected()) {
					b = true;
					break;
				}
			}
		}
		return b;
	}

	// ========================== Is Present Locator ==========================

	// Locator element is present or not
	public boolean IsPresentLocator(By locator) {
		try {
			boolean _result = driver.findElements(locator).size() > 0;
			return _result;
		} catch (NoSuchElementException e) {
			log.info("Not yet implemented." + e);
			return false;
		}

	}

	//========================Switch frame============
	public void  switchFrame(By locator)
	{
		driver.switchTo().frame(driver.findElement(locator));
	}
	
	// ========================== Image Upload ==========================
	// Image upload
	public void ImageUpload(By locator, String ImagePath) {
		try {
			File file = new File(ImagePath);
			WebElement imgUpload = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].style = ''; arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible';", imgUpload);
			imgUpload.sendKeys(file.getAbsolutePath());
					
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
	}
		
	// Verify Uploaded Image
	public boolean IsPresentImage(By imgLocator) {
		boolean imagePresent = false;
		try {
			WebElement imageFile = driver.findElement(imgLocator);
			if (!imageFile.getAttribute("src").contains("/images/no-image.png")) {
				imagePresent = true;
			} else {
				imagePresent = false;
			}
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
		return imagePresent;
	}
	
	
	/**
     * This method will set any parameter string to the system's clipboard.
     */
	
	public  void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public  void uploadFile(String fileLocation) {
        try {
        	 Robot robot = new Robot();
        	 //String c="";
        	 robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_S);
             robot.keyRelease(KeyEvent.VK_S);
             robot.keyRelease(KeyEvent.VK_CONTROL);
        	//Setting clipboard with file location
            //setClipboardData(fileLocation);
            for(int i=0;i< fileLocation.length();i++)
            {
            	 String c= "";
            	c = Character.toString(fileLocation.charAt(0));
            	System.out.println("Path charcter::" + c); 
            //typeCharacter(robot, "C");
            //robot.keyPress(KeyEvent.VK_SHIFT);
            //robot.keyPress(KeyEvent.VK_SEMICOLON);
            //robot.keyRelease(KeyEvent.VK_SHIFT);
            //robot.keyPress(KeyEvent.VK_BACK_SLASH);
            typeCharacter(robot, c);
            
            
            Thread.sleep(3000);
                  
            }
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_SPACE);
            
            robot.keyPress(KeyEvent.VK_ENTER);
            
            //native key strokes for CTRL, V and ENTER keys
           // Robot robot = new Robot();
           // robot.delay(1500);
           // robot.keyPress(KeyEvent.VK_CONTROL);
            //robot.keyPress(KeyEvent.VK_V);
            //robot.keyRelease(KeyEvent.VK_V);
            //robot.keyRelease(KeyEvent.VK_CONTROL);
           // robot.keyPress(KeyEvent.VK_ENTER);
           // robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
	
	public static void typeCharacter(Robot robot, String letter)
	{
	 try
	{
	  boolean upperCase = Character.isUpperCase( letter.charAt(0) );
	  String variableName = "VK_" + letter.toUpperCase();
	  Class<KeyEvent> clazz = KeyEvent.class;
	  Field field = clazz.getField( variableName );
	  int keyCode = field.getInt(null);

	  robot.delay(1000);

	  if (upperCase) robot.keyPress( KeyEvent.VK_SHIFT );

	  robot.keyPress( keyCode );
	  robot.keyRelease( keyCode );

	  if (upperCase) robot.keyRelease( KeyEvent.VK_SHIFT );
	 }
	 catch(Exception e)
	 {
	  System.out.println(e);
	 }
	 }
	

	// Verify Uploaded Image
	public boolean IsPresentImage1(By imgLocator) {
		boolean imagePresent = false;
		try {
			WebElement imageFile = driver.findElement(imgLocator);
			if (!imageFile.getAttribute("src").contains("/images/no-image.png")) {
				imagePresent = true;
			} else {
				imagePresent = false;
			}
		} catch (Exception e) {
			log.info("Not yet implemented." + e);
		}
		return imagePresent;
	}

	// Move to locator
	public void moveToElement(By locator) throws Exception {
		WebElement searchElement = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(searchElement).perform();
	}

}
