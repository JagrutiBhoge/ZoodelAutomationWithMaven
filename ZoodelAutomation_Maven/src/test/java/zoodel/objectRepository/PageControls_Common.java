package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_Common {

	
	public By iframeUpload = By.xpath("/html/body/iframe");
	public By iframeSecondUpload = By.xpath("/html/body/iframe[2]");
	public By lnkLogOut = By.id("logout");
	public By heder_dropdown = By.xpath(
			"//ul[contains(@class,'latoRegular')]/li/div[@class='dropdown']//descendant::span[contains(@class,'loginName')]");

	public By header_dropdownInner = By.xpath("//ul[@class='row commanHeader']//descendant::div[@class='loginIcon']");
	public By myAccountLink = By.cssSelector(
			"div#bs-example-navbar-collapse-1 > ul.nav.navbar-nav.latoRegular > li > div.dropdown.open > ul.dropdown-menu > li > a");
	// Login registration drop down menu.
	public By hoverUserName = By.xpath("//div[@id='afterLoginMenu']//descendant::a[@class='myZoodel']");
	public By myFavoriteMenuLink = By
			.xpath("//div[@id='afterLoginMenu']//descendant::li[@class='headerIdList']/a[contains(@href,'myfavoritepage')]");
	public By tenderMenuLink = By
			.xpath("//div[@id='afterLoginMenu']//descendant::li[@class='headerIdList']/a[contains(@href,'myFavoriteTenderList')]");
	public By sellerToolsMenuLink = By
			.xpath("//div[@id='afterLoginMenu']//descendant::li[@class='headerIdList']/a[contains(@href,'manageProducts')]");
	public By buyingRequestMenuLink = By
			.xpath("//div[@id='afterLoginMenu']//descendant::li[@class='headerIdList']/a[contains(@href,'sentRequestQuote')]");
	public By mesageMenuLink = By
			.xpath("//div[@id='afterLoginMenu']//descendant::li[@class='headerIdList']/a[contains(@href,'sentRequestQuote')]");

	// Tender advertising popup in home page   or Get Best Price for Shipping popup
	public By advertisingPopup = By.xpath("//div[@class='modal-dialog']/div[contains(@class,'modal-content')]");
	public By advertisePopupCloseBtn = By.xpath("//div[@class='modal-dialog']//descendant::button[@class='close']/span");

	// ========Confirmation message======
	// Confirm Ok button
	public By btnConfirmOk = By.id("btnConfirmOk");
	public By btnOK = By.id("confirm-ok");
	public By btnCancel = By.id("btnConfirmCancel");
	public By successMessage = By.id("successMessage");
	public By errorMessage = By.id("errorMessage");
	public By confimationPopup=By.xpath("//div[@id='myModal2']//descendant::div[@class='modal-content']");
	public By popupSuccessMessage = By.xpath("//div[@class='modal_phone-number-box']/p");
	
	
	//==========================
	public By noResultFoundLbl =By.xpath("//div[@class='productSellerNotFound']/div[@class='no-result-found']");

	//============ Homepage Language Control
		public By ddlEN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[1]/label");
		public By ddlFA = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[2]/label");
		public By ddlTR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[3]/label");
		public By ddlAR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[4]/label");
		public By ddlRU = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[5]/label");
		public By ddlCN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[6]/label");
		public By ddlLaguage = By.xpath("//form/div[contains(@class,'zoCountryLanguageDropdownBox')]/a");
		
		//logo
		public By logo = By.xpath("//div[contains(@class,'notForResponsive')]//descendant::img[@id='logo']");
}
