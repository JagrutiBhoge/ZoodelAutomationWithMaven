package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_AddProduct {

	public By btnListNewProduct = By.xpath("//form[@class='form-inline']/div/a");
	public By noResultFoundLbl =By.xpath("//div[@class='productSellerNotFound']/div[@class='no-result-found']");
	// ==========Product information============
	public By txtProductName = By.id("txtProductName");
	public By imageUpload = By.xpath("//div[@class='uploadPanel']/div/input[@type='file']");

	public By uploadBtnListNewProduct = By.xpath("//button[@id='btnMainPhoto']");
	public By uploadBtnModifyProduct = By.xpath("//a[@id='btnUploadPhotos']");
	public By productImage = By.id("imgMainProductPhoto");
	public By lblRemoveImage = By.id("lblRemoveImage");
	public By btnConfirmOkRemoveImagepopup = By.id("btnConfirmOk");
	public By btnSaveContinue = By.id("btnSaveProduct");
	//public By btnSaveContinue1 = By.xpath("//form[@id='frmAddProduct']//descendant::button[@id='btnSaveProduct']");
	public By btnSaveContinue1 = By.xpath("//form[@id='frmProductDetails']//descendant::div[contains(@class,'request-quote-form-checkbox')]/button[2]");
	public By validationMsg = By.xpath("//div[@class='formErrorContent topArrow']");

	public By productImageCount = By
			.xpath("//div[@class='myacc-pb-main-img-box']/ul/li/div[@class='list-your-product-upload-photo']");

	public By productImageCount1 = By
			.xpath("//ul[contains(@class,'list-unstyled')]//descendant::div[@class='list-your-product-upload-photo']");

	public By linkRemove = By.xpath("//ul[contains(@class,'list-unstyled')]//descendant::label[@id='lblRemoveImage']");

	public By  btnVerifyAndRequestToPublish =By.id("btnVerifyAndRequestToPublish");
	
	
	
	
	
	// ==========Product details===============
	public By TabProductDetail = By.xpath("//ul[@id='myaccount-tab']/li[1]/a");
	public By ddlCategory = By.id("ddlCategory");
	public By ddlCategory1 = By.xpath("//form[@id='frmAddProduct']//descendant::select[@id='ddlCategory']");
	public By ddlSubCategory1 = By.xpath("//div[@class='request-quote-form-input-dropdown']/select[@level='1']");
	public By ddlSubCategory2 = By.xpath("//div[@class='request-quote-form-input-dropdown']/select[@level='2']");
	public By ddlSubCategory3 = By.xpath("//div[@class='request-quote-form-input-dropdown']/select[@level='3']");
	public By ddlClass = By.xpath("//div[@class='request-quote-form-input-dropdown']/select[@level='4']");
	public By txtHSCode = By.id("txtTerrifNumber");
	public By txtModelNumber = By.xpath("//div[@id='clearcontrol']//descendant::input[@name='Model Number']");
	public By txtBrandName = By.xpath("//div[@id='clearcontrol']//descendant::input[@name='Brand Name']");
	public By ddlPlaceofOrigin = By.xpath("//div[@id='clearcontrol']//descendant::select[@name='Place of Origin']");
	public By txtShelfLife = By.xpath("//div[@id='clearcontrol']//descendant::input[@name='Shelf Life']");
	public By txtWeight = By.xpath("//div[@id='clearcontrol']//descendant::input[@name='Weight (kg)']");
	public By checkBoxCollection = By.xpath("//ul/li[contains(@class,'checkbox')]");
	public By chkOtherLabel = By.tagName("label");
	public By chkOtherInput = By.tagName("input");
	public By ddlCultivationType = By.xpath("//div[@id='clearcontrol']//descendant::select[@name='Cultivation Type']");
	public By ddlStyle = By.xpath("//div[@id='clearcontrol']//descendant::select[@name='Style']");
	// More Details
	public By txtAttributeName = By.xpath("//input[contains(@class,'clsMoreKey')]");
	public By txtAttributeValue = By.xpath("//input[contains(@class,'clsMoreVal')]");
	// Attribute
	public By btnAdd = By.id("btnAddMore");
	public By btnClose = By.xpath("//div[contains(@id,'remove')]");
	public By btnSaveProductDeatils = By
			.xpath("//form[@id='frmProductDetails']//descendant::button[contains(@class,'btnEditSave')]");
	

	// Save button (common)
		
	public By btnVerifiedRequestToPublishEdit =By.xpath("//form[@id='frmProductDetails']//descendant::button[@next='verified']");
	public By btnSaveDescription = By
			.xpath("//div[@id='My-account-Description']//descendant::button[contains(@class,'btnEditSave')]");
	public By btnSaveTradeInformation = By
			.xpath("//form[@id='frmTradeInfo']//descendant::button[contains(@class,'btnEditSave')]");
	
	// ============Description========
	public By TabDescription = By.xpath("//ul[@id='myaccount-tab']/li[2]/a");
	// /Language
	public By tabEnglish = By.xpath("//ul[@id='myaccount-tab2']/li[1]/a");
	public By tabFarsi = By.xpath("//ul[@id='myaccount-tab2']/li[2]/a");
	public By tabTurkish = By.xpath("//ul[@id='myaccount-tab2']/li[3]/a");
	public By tabArabic = By.xpath("//ul[@id='myaccount-tab2']/li[4]/a");
	public By tabRussian = By.xpath("//ul[@id='myaccount-tab2']/li[5]/a");

	public By txtDescriptionIframe = By.tagName("iframe");
	public By txtDescriptionTinymce = By.tagName("body");
	public By txtKeywords = By.id("txtKeywords");
	// public By btnSaveDescription =
	// By.xpath("//button[@next='account-trade']");

	// ============Trade Information=======
	public By TabTradeInformation = By.xpath("//ul[@id='myaccount-tab']/li/a[contains(@href,'account-trade')]");
	// .xpath("//ul[@id='myaccount-tab']/li[3]/a");
	public By ddlExwpriceCurrency = By.id("ddlCurrency");
	public By txtExwPrice = By.id("txtFobPrice");
	public By ddlExwpriceUnit = By.id("ddlFobUnits");
	public By txtMinOrderQuantity = By.id("txtMinOrder");
	public By ddlMinOrderUnit = By.id("ddlMinOrderQty");
	public By rbtTradeInsuranceYesLabel = By.tagName("label");
	public By rbtTradeInsuranceYesInput = By.xpath("//div[@class='joinfree-radio']/div/input[@id='check114']");
	public By rbtTradeInsuranceNoLabel = By.tagName("label");
	public By rbtTradeInsuranceNoInput = By.id("check126");
	public By rbtTradeInsuranceCollection = By.xpath("//div[@class='joinfree-radio']/div[@class='radio']");
	public By txtPort = By.id("txtPort");
	public By chkPaymentTermCollections = By.xpath("//ul/li[@class='checkbox']");
	public By chkPTBankTransferInput = By.xpath("//ul[@class='payment-ul']/li[4]/input");
	public By chkPTBankTransferLabel = By.xpath("//ul[@class='payment-ul']/li[4]/label");
	public By txtSupplyAbility = By.id("txtSupplyAbility");
	public By ddlSupplyAbilityUnit = By.id("ddlSupplyUnit");
	public By ddlSupplyAbilityTime = By.id("ddlSupplyTime");
	public By txtDeliveryTime = By.id("txtDeliveryTime");
	public By txtPakagingDetails = By.id("txtPkgDetails");
	//public By btnTradeInfoSave = By.id("btnTradeInfo");

	// Validation Message locator
	// List New Product
	public By reqValProductName = By
			.xpath("//form[@id='frmAddProduct']//descendant::div[contains(@class,'txtProductNameformError')]/div");
	public By reqValCategoryListNewProduct = By
			.xpath("//form[@id='frmAddProduct']//descendant::div[contains(@class,'ddlCategoryformError ')]/div");
	public By reqValSubCategory1ListNewProduct = By
			.xpath("//form[@id='frmAddProduct']/div[4]/div[2]//descendant::div[contains(@class,'topArrow')]");
	public By reqValSubCategory2ListNewProduct = By
			.xpath("//form[@id='frmAddProduct']/div[4]/div[3]//descendant::div[contains(@class,'topArrow')]");
	public By reqValSubCategory3ListNewProduct = By
			.xpath("//form[@id='frmAddProduct']/div[4]/div[4]//descendant::div[contains(@class,'topArrow')]");
	public By reqValClassListNewProduct = By
			.xpath("//form[@id='frmAddProduct']/div[4]/div[5]//descendant::div[contains(@class,'topArrow')]");

	// After modify product
	public By reqValCategory = By
			.xpath("//form[@id='frmProductDetails']//descendant::div[contains(@class,'ddlCategoryformError ')]/div");
	public By reqValSubCategory1 = By
			.xpath("//form[@id='frmProductDetails']/div/div[2]//descendant::div[contains(@class,'topArrow')]");
	public By reqValSubCategory2 = By
			.xpath("//form[@id='frmProductDetails']/div/div[3]//descendant::div[contains(@class,'topArrow')]");
	public By reqValSubCategory3 = By
			.xpath("//form[@id='frmProductDetails']/div/div[4]//descendant::div[contains(@class,'topArrow')]");
	public By reqValClass = By
			.xpath("//form[@id='frmProductDetails']/div/div[5]//descendant::div[contains(@class,'topArrow')]");
	public By reqValEXWPrice = By
			.xpath("//div[@class='list-group-final-box']/div[2]//descendant::div[contains(@class,'topArrow')]");
	public By reqValEXWUnit = By
			.xpath("//div[@class='list-group-final-box']/div[3]//descendant::div[contains(@class,'topArrow')]");
	public By reqValMinimumOrderQuantity = By
			.xpath("//div[@class='list-group-final-box']/div[1]//descendant::div[contains(@class,'topArrow')]");
	public By minmumOrderQuantityUnit = By.id("ddlMinOrderQty");
}
