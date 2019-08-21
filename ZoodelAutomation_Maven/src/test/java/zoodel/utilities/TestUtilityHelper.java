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
	
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
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
	
	
	//GetData from excel
	@DataProvider(name="Link")
	public Object[][] getData(Method m) throws Exception {
	
		String sheetName = "Sheet1"; //m.getName();
		String path =System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		Thread.sleep(1000);
		
		//String sheetName = "Sheet1";
		//Get row count
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		int rows=sheet.getLastRowNum()+1;
		//int rows = excel.getRowCount(sheetName);
		//int cols = excel.getColumnCount(sheetName);
		
		//Get Cols count
		row = sheet.getRow(0);
		int cols =row.getLastCellNum();
		
		Object[][] data= new Object[rows-1][1];
		Hashtable<String,String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(getCellData(sheetName, colNum, 1), getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}
		
		
		return data;
	}
	
	// returns the data from a cell
		public String getCellData(String sheetName,int colNum,int rowNum){
			try{
				if(rowNum <=0)
					return "";
			
			int index = workbook.getSheetIndex(sheetName);

			if(index==-1)
				return "";
			
		
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";
			
		  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           // format in form of M/D/YY
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.MONTH)+1 + "/" +
		                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cellText;
		      }

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return "";
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
			}
			catch(Exception e){
				
				e.printStackTrace();
				return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
			}
		}
}
