package zoodel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class TestUtilityHelper {

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

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

	// Capture screenshot for fail test case
	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			// if exist screenshot then its delete
			Files.deleteIfExists(Paths.get("./Screenshots/" + screenshotName + ".png"));
			// Create reference of TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			// Call method to capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location here it will save all screenshot
			// in our project home directory and
			// result.getName() will return name of test case so that screenshot
			// name will be same
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	@DataProvider(name = "Link")
	public Object[][] getData(Method m) throws Exception {
		String sheetName = "Sheet1"; // m.getName();
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			// sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		Thread.sleep(1000);

		// String sheetName = "Sheet1";l
		// Get row count
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return getData(m, sheet);

	}

	@DataProvider(name = "staticLink")
	public Object[][] getFooterData(Method m) throws Exception {
		String sheetName = "Sheet2"; // m.getName();
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			// sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		Thread.sleep(1000);

		// String sheetName = "Sheet1";l
		// Get row count
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);  //Get the XSSFSheet object at the given index.
		return getData(m, sheet);

	}

	// GetData from excel
	public Object[][] getData(Method m, XSSFSheet sheet) throws Exception {
		//Total number of rows
		int rows = sheet.getLastRowNum() + 1;
		System.out.println("Total rows in the sheet are : " + rows);
		// int rows = excel.getRowCount(sheetName);
		// int cols = excel.getColumnCount(sheetName);
		// =================
		// Find the test case start row
		int testCaseRowNum = 0;
		for (testCaseRowNum = 0; testCaseRowNum <= rows; testCaseRowNum++) {
			if (sheet.getRow(testCaseRowNum) == null)
				continue;
			String testCaseFromSheet = sheet.getRow(testCaseRowNum).getCell(0).getStringCellValue();
			System.out.println("Test case Name is :" + testCaseFromSheet);
			if (!testCaseFromSheet.equalsIgnoreCase("")) {
				if (testCaseFromSheet.equalsIgnoreCase(m.getName())) {
					System.out.println("Test case Name (from Sheet) is :" + testCaseFromSheet);
					break;
				}
			}
		}
		System.out
				.println("Test case starts from row num: " + testCaseRowNum + " And Test case Name is :" + m.getName());

		// Checking total rows in test case
		int dataStartRowNum = testCaseRowNum + 2;
		System.out.println("Test case data starts from row num: " + dataStartRowNum);
		int testRows = 0;
		while (sheet.getRow(dataStartRowNum + testRows) != null) {
			testRows++;
		}
		System.out.println("Total rows of data are : " + testRows);

		// Checking total columns in test case
		int testDataStartRowNum = testCaseRowNum + 1;
		int testCols = 0;
		while (sheet.getRow(testDataStartRowNum).getCell(testCols) != null) {
			testCols++;
		}

		System.out.println("Total cols are : " + testCols);

		// ============================

		// Get Cols count
		row = sheet.getRow(1);
		int cols = row.getLastCellNum();

		Object[][] data = new Object[testRows][1];
		Hashtable<String, String> table = null;
		int dataIndex = 0;
		for (int rowNum = dataStartRowNum; rowNum < dataStartRowNum + testRows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < testCols; colNum++) {
				table.put(getCellData(sheet, colNum, testCaseRowNum + 1), getCellData(sheet, colNum, rowNum));
			}
			data[dataIndex][0] = table;
			dataIndex++;
		}

		return data;
	}

	// returns the data from a cell
	public String getCellData(XSSFSheet sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			// get row and cell object
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
}
