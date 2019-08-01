package zoodel.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtilityHelper {

	/*
	 * public static void main(String args[]) throws Exception {
	 * 
	 * 
	 * MongoClient mongoClient = new MongoClient("136.243.153.45:27017"); DB db
	 * = mongoClient.getDB("zoodel"); char[] pass = "uje8236k".toCharArray();
	 * System.out.println(pass); boolean authenticated =
	 * db.authenticate("db_zoodel", pass); if (authenticated) {
	 * System.out.println("Successfully logged in to MongoDB!"); } else {
	 * System.out.println("Invalid username/password"); } }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * try {
	 * 
	 * Mongo mongo = new Mongo("136.243.153.45:27017"); DB db =
	 * mongo.getDB("zoodel"); char[] pass = "uje8236k".toCharArray();
	 * System.out.println(pass); boolean auth = db.authenticate("db_zoodel",
	 * pass); if (auth) {
	 * 
	 * DBCollection table = db.getCollection("user");
	 * 
	 * BasicDBObject document = new BasicDBObject(); document.put("name",
	 * "mkyong"); table.insert(document);
	 * 
	 * System.out.println("auth is successful!"); } else {
	 * System.out.println("auth is failed!"); }
	 * 
	 * } catch (UnknownHostException e) { e.printStackTrace(); } catch
	 * (MongoException e) { e.printStackTrace(); } }
	 */

	//Capture screenshot for fail test case
	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			//if exist screenshot then its delete
			 Files.deleteIfExists(Paths.get("./Screenshots/"+screenshotName+".png"));
			// Create reference of TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			// Call method to capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location here it will save all screenshot in our project home directory and
			// result.getName() will return name of test case so that screenshot name will be same
			FileUtils.copyFile(source, new File("./Screenshots/"
					+ screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}
	}
	
	
	

}
