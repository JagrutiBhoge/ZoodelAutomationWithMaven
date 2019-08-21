package zoodel.testcase;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import zoodel.base.TestBase;
import zoodel.utilities.TestUtilityHelper;

public class TestCase_HomePageLink extends TestBase{

	public static final Logger log= Logger.getLogger(TestCase_HomePageLink.class.getName());
		
	
	@Test(dataProviderClass= TestUtilityHelper.class , dataProvider= "Link")
	public void CheckTitleOfHomePageLink(Hashtable<String,String> data) throws Exception
	{
		log.info("Click on link");
		log.debug("Click on menu linksssssssssss");
		driver.findElement(By.linkText(data.get("Link"))).click();
		Thread.sleep(3000);
		String actualTitle=driver.getTitle();
		String expectTitle= data.get("Title");
		log.debug("Actual Title: " +actualTitle);
		
		System.out.println("Title :" + actualTitle);
		Thread.sleep(1000);
		Assert.assertEquals(expectTitle, actualTitle,"Title is not match");
		
		
		
	}
	
}
