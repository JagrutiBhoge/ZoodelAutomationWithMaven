package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_Login {

	public By lnkLogin = By.id("showLoginRegisteration");
	public By txtEmail = By.id("usrEmailorMobile");
	public By txtPassword = By.id("usrPassword");
	public By titleLogin = By.id("myModalLabel");
	public By btnLogin = By.id("usrLogin");
	public By lnkLogOut = By.id("logout");
	public By loginName = By.xpath("//div[@id='bs-example-navbar-collapse-1']/ul/li[5]/div/span/span[contains(@class,'loginName')]");
			//By.xpath("//span/span[@class='cursor-pointer linkHeader loginName']");

	public By tabLogin =By.xpath("//ul[@role='tablist']/li[1]");
	
	
}
