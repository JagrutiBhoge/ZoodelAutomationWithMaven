package zoodel.testdata;

import org.openqa.selenium.WebDriver;

public class TestData_Common {

	static WebDriver driver;
     
	//public final String url_staging ="http://staging-www.zoodel.com";
	public final String url_staging ="https://www.zoodel.com"; //"https://staging-www.zoodel.com/en";  // "http://qa.zoodel.com:3333/en"; //"http://lebanon.zoodel.com/en";  //"http://staging.zoodel.com/";
	
			
	// Back office url
	public final String url_backOffice = "http://bk-staging.zoodel.com/en";   
	
	
	//Image path file	
	//public String companylogoImagePath  ="C://Users/Jagruti/workspace_New/zoodel.automationtesting/res/images/companyLogo.png";
	public String companylogoImagePath = "res/images/companyLogo.png";

	public String companyPhotoImagePath = "res/images/companyPhotos.jpg";

	public String contactPhotoImagePath = "res/images/contactPhoto.jpg";

	public String productImagePath = "res/images/broadBeans01.jpg";

	public String productImagePath1 = "res/images/broadBeans02.jpg";
	
	public String imageSize4mb = "res/images/4mbImg.png";
	
	public String imageSize5mb = "res/images/5mbImg.jpg";
	
	//Document path file
	public String attachDocxFile = "res/doc/Product Details.docx";
	
	public String docFile = "res/doc/Doc.docx";
	
	public String excelFile = "res/doc/Excel.xlsx";
	
	public String htmlFile = "res/doc/Html.html";
	
	public String textFile = "res/doc/Text.txt";
	
	public String pdfFile = "res/doc/Pdf.PDF";
	
	public String rarFileMore15mb = "res/doc/Test Automation.rar";
}
