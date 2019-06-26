package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_StaticPages {
	// Logo
	public By logo = By.xpath("//div[contains(@class,'notForResponsive')]//descendant::img[@id='logo']");
	// Page Title
	public By lblPageTitle = By.xpath("//div[contains(@class,'about_us_content')]"); // .xpath("//div[contains(@class,'about_us_content')]/h2");
	public By lblHelp = By.xpath("//div[@class='help_page_header_left']/h2");
	public By lblPricePage = By.xpath("//div[@class='pricing-page-block1']/div/h1");
	public By lblrequestQuote = By
			.xpath("//div[@class='container']/div[contains(@class,'request-quote-green-line')]/h4");
	public By lblContactUs = By.xpath("//div[@class='contact_page_right_part']/h2");
	public By lblListYourProduct = By.xpath("//div[contains(@class,'request-quote-green-line')]/h4");
	public By lblMyWebstore = By.xpath("//div[contains(@class,'leftNavBarUpper')]/h3[contains(@class,'txtBold')]");
	public By breadcumExhibitionService=By.xpath("//ol[contains(@class,'breadcrumb')]//descendant::li[2]");
	public By breadcrumMareketResearch = By.xpath("//ol[contains(@class,'breadcrumb')]//descendant::li[2]/a");
	// .xpath("//div[contains(@class,'leftNavBarUpper')]/h3");

	public By btnCreateYourWebstoreNow = By.id("getYourWebstore");
	public By tabProduct = By.xpath("//ul[@id='search-tabs']/li[1]/a");
	public By tabSellerhowitworks = By.xpath("//ul[@id='how-it-works-tabs']/li[1]/a");

	public By lblpopupTitle = By.xpath("//h4[@id='myModalLabel']");
	public By btnClosePopup = By.xpath("//button[contains(@class,'close')]/span");
	public By tenderBreadCum = By.xpath("//ol[contains(@class,'breadcrumb')]/li[2]/a");
	public By zoodelFinaceBreadCum =By.xpath("//ol[contains(@class,'breadcrumb')]/li[2]");
	// ===================== Header link ====================
	public By hrLnkAboutusHeader = By
			.xpath("//ul[contains(@class,'latoRegular')]//descendant::a[contains(@href,'aboutUs')]");
	public By ddlSeller = By.cssSelector("#bs-example-navbar-collapse-1 > ul > li.dropdown > span"); // By.xpath("//ul[contains(@class,'latoRegular')]/li[@class='dropdown']");
	public By hrLnkCreateWebStore = By
			.xpath("//ul[@class='dropdown-menu']//descendant::a[contains(@href,'freewebsite')]");
	public By hrLnkCreateWebStoreWithLogin = By
			.xpath("//ul[@class='dropdown-menu']//descendant::a[contains(@href,'storeConfigurations')]");
	public By hrLnkPostYourProductFree = By.xpath(
			"//li[contains(@class,'open')]/ul[@class='dropdown-menu']//descendant::a[contains(@href,'addProduct')]");
	public By hrLnkViewTenders = By.xpath("//ul[@class='dropdown-menu']//descendant::a[contains(@href,'tenders')]");
	public By hrLnkContactUs = By.xpath("//ul[contains(@class,'latoRegular')]/li[3]/a");
	public By hrLnkRegister = By.id("callJoinFreeTemplate");
	public By hrLnkRequestQuote = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::a[@id='requestQuoteTop']");
	public By requestQuoteCommonHeader = By
			.xpath("//ul[contains(@class,'commanHeader')]/li/div/a[@id='requestQuoteLinkAfterScroll']");

	// ========================== Footer link=====================
	// Our Company
	public By lnkAboutUs = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'aboutUs')]");
	public By lnkHelp = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'help')]");
	public By lnkHowItWorks = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'howitworks')]");
	public By lnkPartnerWithUs = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'partnerwithus')]");
	public By lnkNews = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'news')]");
	public By lnkContactUs = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'contactUs')]");
	public By lnkTermsConditions = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'termsconditions')]");
	// Our Events
	public By lnkZoodelAcademy = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'academy')]");
	public By lnkIranSMEExportConf = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'conf.zoodel.com')]");
	public By lnkExhibitionServices = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'exhibition-services')]");
	// Our Services
	public By lnkZoodPay = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'zoodpay')]");
	public By lnkBusinessVerified = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'business-verified')]");
	public By lnkIdentityVerified = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'identity-verified')]");
	public By lnkPremiumMemberships = By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'pricing')]");
	public By lnkZoodelFinance =By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'financing')]");
	public By lnkMarketReasearch =By.xpath("//div[@class='footerList']//descendant::a[contains(@href,'market-research')]");
	// For Buyers
	public By lnkRequestQuote = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'request-quote')]");
	public By lnkSearchProductsAndSellers = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'products')]");
	// For Sellers
	public By lnkCreateYourWebstore = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'freewebsite')]");
	public By lnkCreateYourWebstoreWithLogin = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'storeConfigurations')]");
	public By lnkPostYourProductsFree = By
			.xpath("//div[@class='footerList']//descendant::a[contains(@href,'addProduct')]");
	// Follow Us On
	public By lnkFacebook = By.xpath("//div[@class='footerList socialIcons']/ul/li[1]/a/i");
	public By lnkTwitter = By.xpath("//div[@class='footerList socialIcons']/ul/li[2]/a/i");
	public By lnkLinkedin = By.xpath("//div[@class='footerList socialIcons']/ul/li[3]/a/i");
	public By lnkTelegram = By.xpath("//div[@class='footerList socialIcons']/ul/li[4]/a/i");

	//======= Static page controls
	public By  btnFreeJoinUsNow = By.id("btnFreeJoin");
	public By btnHowItWorks = By.id("btnHowItworks");
	//Help
	public By lnkCreateYourwebstoreInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'freewebsite')]");
	public By lnkPostYourProductInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'addProduct')]");
	public By lnkRequestQuoteInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'request-quote')]");
	public By lnkSearchProductSellerInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'products')]");
	public By lnkOurPartnerInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'partnerwithus')]");
	public By lnkPremiumMembershipsInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']//descendant::a[contains(@href,'pricing')]");
	public By btnHowItWorksInHelp = By.xpath("//div[@class='zoodle_help_page_left_part']/a[contains(@href,'howitworks')]");
	
	//how it works 
	public By btnFreeJoinUsNowHowItWork=By.xpath("//div[contains(@class,'mrg-none')]/button[contains(@class,'free-list-bloc')]");
	public By sellertabActive=By.xpath("//ul[@id='how-it-works-tabs']/li[1]");
	public By buyertabActive=By.xpath("//ul[@id='how-it-works-tabs']/li[2]");
	public By buyerTab =By.xpath("//ul[@id='how-it-works-tabs']/li[2]/a");
	//Premium membership
	public By btnFreeJoinNowInPremium = By.xpath("//button[@id='btnJoinFreeTemplate']");
	public By btnYearlySubscription =By.xpath("//button[@id='btnPremiumTemplate']");
	
	
	
	
	
}
