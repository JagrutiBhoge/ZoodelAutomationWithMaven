package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_Search {
		public By ddlProductHome =By.cssSelector("div.searchBlockSlider > div.secrhBlock > ul > li.serchBlockList > div.linkHeader > #ddlProduct");   //By.id("ddlProduct"); //By.xpath("//section//descendant::select[@id='ddlProduct']");
	//public By ddlProductInner = By.id("ddlProduct");
	
	public By ddlProductInner = By.xpath("//li[2]/div/div/ul/li[2]/div/select");
	
	public By btnSearchHome  = By.cssSelector("div.searchBlockSlider > div.secrhBlock > ul > li.serchBlockList > #btnSearch");
	//public By btnSearchInner =By.cssSelector("ul.zoOverflowHidden > li.serchBlockList > #txtSearch"); //By.xpath("//li[2]/div/div/ul/li[3]/button");
	public By btnSearchInner1 =By.cssSelector("li.headerMenuListRtl > div.secrhBlockHeader > div.secrhBlock.pr > ul.zoOverflowHidden > li.serchBlockList > #txtSearch"); //By.xpath("//li[2]/div/div/ul/li[3]/button");
	public By btnSearchInner = By.xpath("//li[2]/div/div/ul/li[3]/button");//xpath("//input[@id='txtSearch']");
	
	public By lblAllCategory = By
			.xpath("//ol[contains(@class,'breadcrumb')]//descendant::li[3]/a");
	public By lblProducts = By
			.xpath("//ol[contains(@class,'breadcrumb')]//descendant::li[2]/a");
	
	public By txtSearchInner  = By.cssSelector("li.headerMenuListRtl > div.secrhBlockHeader > div.secrhBlock.pr > ul.zoOverflowHidden > li.serchBlockList > #txtSearch");   //By.xpath("//ul/li/input[@id='txtSearch']");
	public By txtSearchHome =By.cssSelector("div.searchBlockSlider > div.secrhBlock.pr > ul > li.serchBlockList > #txtSearch");//By.xpath("//li[2]/div/div/ul/li/input");//By.xpath("//input[@id='txtSearch']");//By.id("txtSearch");
	
	public By txtSearchCategoryHome=By.xpath("//li[2]/div/div/ul/li/input");
	
	//Left Side Panel
	public By listLeftSideCategory=By
			.xpath("//div[contains(@class,'my-search-page-category-box')]/descendant::li[contains(@class,'categorytype-title')]");
	public By agricultureLeftSideCategoryLnk=By.xpath("//div[@id='leftPanelMainDiv']/div/ul/li/h5[@id='agriculture_animals']");
	public By broadBeansLeftSideCategoryLnk=By.xpath("//ul[@class='productListDisplay']//descendant::span[@id='broad_beans']/h6");
	public By viewMoreLess = By.id("view-more-less");
	public By chkBusinessTypeCollection = By.xpath("//div[@id='businessType']/div[contains(@class,'business-checkboxes')]/ul/li");
	public By chkCountryCollection = By.xpath("//div[@id='sellerBy']/div[contains(@class,'countries-checkboxes')]/ul/li/label");
	public By chkLabelCountryAndTypeBussiness=By.tagName("h5");
	
	public By agricultureAnimals = By.id("agriculture_animals");
	public By foodBeverage = By.id("food_beverage");
	public By productRowCollection = By.xpath("//ul[contains(@class,'productsListing')]/li");      //li[contains(@class,'grid-view')]
	public By sellerRowCollection=By.xpath("//div[@id='sellers']//descendant::ul[contains(@class,'sellersListing')]/li");
	//public By companyRowCollection=By.xpath("//div[@id='sellers']//descendant::li[@class='col-lg-5 col-md-5 col-sm-5 grid-view']");
	public By lblProductName =By.xpath("//ul[contains(@class,'productsListing')]//descendant::a[@class='listMiddleSection']/h5");
	public By lblsellerName =By.xpath("//ul[contains(@class,'sellersListing')]//descendant::a[@class='listMiddleSection']/h5");
	public By productNameText = By.cssSelector("div.my-search-page-right-part-box > div.row.produsct-box > ul > li > div > a > h5");
			//.cssSelector("div.gold-box > h4.pro-name2.word-wrap-2");     //("div.pro-box > aside.pro-left-side > h4.pro-name");    
	public By companyNameInProductTab =  By.cssSelector("div.my-search-page-right-part-box > div.row.produsct-box > ul > li > div > div > a > h5");
	public By companyNameText = By.cssSelector("#sellers > div.row.produsct-box > ul > li >  div > a > h5");
				//.cssSelector("div.pro-box > aside.pro-right-side > div.pro-inner-right > h4.pro-company-name.overlaphide.word-wrap-2");   //("div.gold-box > h4.pro-name2.word-wrap-2");
	public By sellerNameInProductTab = By.xpath("//ul[contains(@class,'productsListing')]//descendant::a[@class='hidden-xs']/h5");
	public By btnViewMore = By.xpath("//input[contains(@class,'btnViewMore')]");
	
	public By chkSearch = By.xpath("//ul/li[@class='checkbox']");
	public By chkLabel = By.tagName("label");
	public By chkInput = By.tagName("input");
	public By iconPremium = By
			.xpath("//div[@class='iconBox']//descendant::img[contains(@src,'zoodel_premium.png')]");
			
	public By iconIdentityVerified = By
			.xpath("//div[@class='iconBox']//descendant::img[alt='Identity Verified'][alt='Business Verified']");
		
	public By iconIranianFlag = By
			.xpath("//div[@class='iconBox']//descendant::img[contains(@src,'IR.png')]");
			//.xpath("//div[@class='iconBox']/div[3]/img[contains(@src,'IR.png')]");
	public By categoryRowCollection = By
			.xpath("//div[@class='my-search-page-category-box']/div[@class='categorytype-title']");
	public By categorylabel = By.tagName("h4");
	//public By arrowCategory = By.xpath("//i[@id='agriculture_animals']");
	public By chkClassCollection = By.xpath("//div[contains(@class,'my-search-page-category-box-checkboxes')]/ul[@class='productListDisplay']/li/span");
	
	public By viewMoreAgricultureAnimals = By.xpath("//span[@id='agriculture_animals']");
	
	public By tabProduct=By.xpath("//ul[@id='search-tabs']/li[1]");
	public By tabProductClick=By.xpath("//ul[@id='search-tabs']/li[1]/a");
	public By tabSeller=By.xpath("//ul[@id='search-tabs']/li[2]");
	public By tabSellerClick=By.xpath("//ul[@id='search-tabs']/li[2]/a");
	public By browseCategListAgricultureAnimalsFoodBeverage = By.xpath("//div[@class='container']//descendant::ul/li[1]/a[contains(@href,'/products/catid/agriculture_animals_food_beverage')]"); 
	public By browseCategListAgricultureAnimals = By.xpath("//div[@class='container']//descendant::a[contains(@href,'/products/subid/agriculture_animals')]");
	public By browseCategListClass = By.xpath("//div[@class='container']//descendant::a[contains(@href,'/products/cid/broad_beans')]");
	public By browseByCategories =By.id("categoryMenuButton");
	
	
	//Left Panel
	public By beansGrainsCerealsLink = By.id("beans_grains_cereals");    //
	
	
	//Contact seller pop up required field validation message.
	public By reqValDescripContactSellPopup =By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtProductDescriptionformError')]/div");
	public By reqValQuantityContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtQuantityformError')]/div");
	public By reqValQuantityUnitContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'drpUnitTypeformError')]/div");
	public By reqValNameContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtNameformError')]/div");
	public By reqValEmailContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtEmailformError')]/div");
	public By reqValCountryCodeContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtCountryCodeformError')]/div");
	public By reqValNumberContactSellPopup=By.xpath("//form[@id='frmRequestQuotePopup']//descendant::div[contains(@class,'txtPhoneNumberformError')]/div");
	
	//Seller Tools control
		public By btnViewMore1 = By.xpath("//div[@class='my-account-right-box']//descendant::input[contains(@class,'btnViewMore')]");
		public By productRowCollectionst = By
				.xpath("//div[contains(@class, 'myacc_sellarbox')]");
		public By productNameTextst = By.tagName("h3");
	
}
