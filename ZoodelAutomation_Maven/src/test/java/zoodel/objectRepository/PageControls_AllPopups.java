package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_AllPopups {

	// Contact Seller

	public By btnContactSeller = By.id("contactSeller");
	// Popup title and Sub title(Also use for Request
	// Quote/Send to a Friend/Abuse Report Content/ Save product/
	public By lblPopupTitle = By.xpath("//div[@class='modal-header']/h4");

	// ==============Contact seller popup in search page========
	public By lblProductNameInContactSeller = By.xpath("//form[@id='frmRequestQuotePopup']/div/div[2]/h5");
	public By lblSellerNameInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::div/h5");
	public By txtMessageInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::textArea[@id='txtProductDescription']");// By.id("txtProductDescription");
	public By txtQuantityInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::input[@id='txtQuantity']"); // id("txtQuantity");
	public By ddlQuantityUnitInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::select[@id='drpUnitType']");
	public By txtNameInContactSeller = By.xpath("//form[@id='frmRequestQuotePopup']//descendant::input[@id='txtName']"); // By.id("txtName");
	public By txtEmailInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::input[@id='txtEmail']"); // By.id("txtEmail");
	public By txtCountryCodeInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::input[@id='txtCountryCode']");
	public By txtNumberInContactSeller = By
			.xpath("//form[@id='frmRequestQuotePopup']//descendant::input[@id='txtPhoneNumber']");
	public By txtProductNamePopup = By.id("txtProductNamePopup");
	public By btnSubmitYourRequirement = By.id("btnRequestProductQuote");

	// ======Old contact seller popup control==========
	public By txtSubject = By.id("txtsubject");
	public By txtDescription = By.id("txtDescription");// Also use for Make
	// offer
	public By ddlSubCategoryId = By.id("ddlSubCategoryId");
	public By chkRequirement = By.xpath("//div/div[@class='checkbox']");
	public By lblRequirement = By.tagName("label");
	public By inputRequirement = By.tagName("input");
	public By txtOrderNumber = By.id("txtordernumber");
	public By ddlUnitType = By.id("ddlUnitType"); // Also use for Make offer
	public By txtComment = By.id("txtcomment");
	public By btnSendContactSeller = By
			.xpath("//form[@class='form_contact_seller main_form']/button[contains(@class,'btn_send_Requirement')]");
	public By btnSendRequirement = By.id("btnRequestProductQuote");
	public By txtSubjectRequirement = By.id("txtSubject");
	public By btnCloseContactSeller2 = By.xpath("//div[@id='contact_seller']/div[2]/div/div[1]/button");
	public By btnCloseContactSeller = By
			.xpath("//div[@id='my_request_quote']//descendant::button[@class='close']/span");
	public By btnClosePopup = By.xpath("//button[@id='btnCloseSuccessDialog']/span");
	public By lblProducNameCategory = By.xpath(
			"//div[@class='modal-content']/div[2]/div/div[1]//descendant::label[@class='request-quote-form-label']");

	// Also use for Send to a Friend/Save product/Remove product

	public By lblCategoryAbusePopupTitle = By.xpath("//form[@id='frmAbuseReportContent']/div/label");
	public By lblSendFriendPopupTitle = By.xpath("//form[@id='frmSuggestToFriend']/div/label");

	// ============= Send your message to this supplier
	public By multiSellercheckbox = By
			.xpath("//div[@class='form-control-static']//descendant::label[@for='chkMultiSuppliers']");
	public By companyNameSendYourMsgSupplier = By.xpath("//form[@id='requestQuoteDetail']/div/div/div/span");
	public By txtProductNameMsgSupplier = By.id("txtProductName");
	public By txtMsgSendYourMsgSupplier = By.id("txtDescription");
	public By txtQuantitySendYourMsgSupplier = By.id("txtQuantity");
	public By ddlUnitSendYourMsgSupplier = By.xpath("//select[@id='ddlUnitType']");
	public By txtNameSendYourMsgSupplier = By.id("txtName");
	public By txtEmailSendYourMsgSupplier = By.id("txtEmail");
	public By txtCountryCodeSendYourMsgSupplier = By.id("txtCountryCode");
	public By txtNumberSendYourMsgSupplier = By.id("txtPhoneNumber");
	public By SendBtnSendYourMsgSupplier = By.id("btnRequestProductQuote");
	public By attachFile = By.id("btnQuoteFile");

	// ======Request For Quote in Search list page====
	//public By txtProductNameRFQ = By.id("txtProductName");
	public By txtDescriptionRFQ = By.id("txtDescription");
	public By txtQuantityRFQ = By.id("txtSearchLeftQuantity");
	public By ddlQuantityUnitRFQ = By.id("drpSearchLeftUnitType");
	//public By txtNameRFQ = By.id("txtName");
	//public By txtCountryCodeRFQ = By.id("txtCountryCode");
	//public By txtMobileNumberRFQ = By.id("txtPhoneNumber");
	public By btnGetQuoteRFQ=By.id("btnGetQuotes");
	// ==========Telephone==========
	public By btnTelePhone = By.id("ownerPhone");
	public By btnTelePhone1 = By.id("showPhoneNo");
	public By imagTelePhonePopUp = By.id("call-phone");
	public By isPresentTelePhonePopUp = By.xpath("//div[@id='phonenumber']//descendant::div[@class='modal-body']");
	public By btnCloseTelephoneNumberPopup = By.xpath("//div[@class='modal_phone-number-box']/button[@class='close']");
	// By.cssSelector("div.modal_phone-number-box > button.close");

	// =============Send To Friend======
	public By IsPresentPopup = By.xpath("//div[contains(@class,'modal-dialog')]/div");
	public By lnkSendToFriend_P = By.id("btnSuggestToFriend");
	public By lnkSendToFriend_C = By
			.xpath("//div[@class='zoDetailPageLinkBlock']/ul/li[2]/span[@id='sendToFriend']/span");// By.id("sendToFriend");
	public By txtAdName = By.id("txtAdName");
	public By txtAdEmail = By.id("txtAdEmail");
	public By txtAdEmailFriend = By.id("txtAdEmailFriend");
	public By txtAdMessage = By.id("txtAdMessage");
	public By btnSendToFriend = By.id("suggestToFriendBtn");
	public By companyNameSendToFriend = By
			.xpath("//form[@id='frmSuggestToFriend']/div[@class='overflowHidden']/label[@for='selecttype']");
	public By btnCloseSendToFriend = By.xpath("//div[@id='send-to-frd']//descendant::button[@class='close']/span");

	// Favorite
	public By lnkSave_P = By.id("productAddToFavorite");
	public By lnkRemove_P = By.id("productRemoveFromFavorite");
	public By companyName = By.xpath("//div[@class='overflowHidden']/label[@for='selecttype']");
	public By imgPath = By.xpath("//div[contains(@class,'follow-price-img-box')]/img[1]");
	public By lnkSave_C = By.xpath("//div[@class='zoDetailPageLinkBlock']//descendant::li[4]/span");
	
	public By lnkRemove_C = By.xpath("//div[@class='zoDetailPageLinkBlock']//descendant::li[4]/span");
	public By saveProductName = By.xpath("//div[@class='modal-body']/div/div[1]/label");
	// public By btnCloseFavorite =
	// By.xpath("//div[2]/div[@class='modal-content']/div[@class='modal-header']/button[@class='close']");
	public By btnClose = By.xpath("//div[@id='save']//descendant::button[@class='close']/span"); // ("//button[@class='close']");
																										// By.xpath("//div[@id='save']/div[2]/div/div[1]/button");

	// ========Make offer=====
	public By btnMakeOfferPopup = By.id("makeOfferPopup");
	public By txtPrice = By.id("txtPrice");
	public By ddlCurrency = By.id("ddlCurrency");
	public By txtQuantity = By.id("txtQuantity");// Also use for Request Quote
													// popup
	public By btnSendOffer = By.id("btnSendOffer");
	public By companyNameOnPopup = By.xpath("//div[@class='form_get_latest_price_text']/h3");
	public By btnCloseMakeOffer = By.xpath("//div[@id='my_make_offer']/div[2]/div/div[1]/button");

	// ============Request quote======
	public By drpUnitType = By.id("drpUnitType");
	public By txtReqDescription = By.id("txtreqDescription");
	public By btnRequestQuotePopup = By.id("requestQuotePopup");
	public By btnRequestProductQuote = By.id("btnRequestProductQuote");
	public By btnCloseRequestQuote = By.xpath("//div[@id='my_request_quote']/div[2]/div/div[1]/button");
	public By companyNameOnRequestQuotepopup = By.xpath("//form[@id='requestProductQuoteForm']/div/h3");

	// ============ AbuseReportContent
	public By lblProducNameCategoryAbuseReport = By.xpath(
			"//form[@id='frmAbuseReportContent']/div[@class='form-group']/label[contains(@class,'request-quote-form-label')]");
	public By lnkAbuseReportContent_P = By.xpath("//span[@id='btnAbuseReportcontent']/span"); // By.id("btnAbuseReportcontent");
	public By lnkAbuseReportContent_C = By
			.xpath("//div[@class='zoDetailPageLinkBlock']/ul/li[1]/span[@id='abuseReportContent']/span"); // By.id("abuseReportContent");
	public By rbtAbuseReportLabel = By.tagName("label");
	public By rbtAbuseReportInput = By.xpath("//input[@id='wrong_product']");
	public By rbtTAbuseReportCollection = By.xpath("//div[@class='joinfree-radio']/ul/li[@class='radio']");
	public By txtArcName = By.id("txtArcName");
	public By txtArcEmail = By.id("txtArcEmail");
	public By txtArcMessage = By.id("txtArcMessage");
	public By btnSendAbuseReport = By.id("btnAbuseReportContentmail");
	public By btnCloseAbuseReport = By
			.xpath("//div[@id='myabusereport']/div[2]//descendant::button[@class='close']/span");
	public By btnCloseAbuseReport2 = By
			.xpath("//div[@id='myabusereport']/div[2]//descendant::button[@class='close']/span");

}
