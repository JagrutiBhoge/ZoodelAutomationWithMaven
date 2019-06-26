package zoodel.testdata;

public enum enum_staticPage {
	loginOrRegisterPopupTitle("Login or Registration Free now",
			"وارد شوید و یا عضو شوید",
			"Giriş Yap ya da Hemen Ücretsiz Kayıt Ol",
			"Войти или зарегистрироваться", "الدخول أو تسجيل العضویة الآن","现在登陆或者免费注册"),

	//loginTitle("Login or Registration Free now", "ورود به حساب کاربری",
			//"hesabınıza giriş", "Войти в систему", "الدخول إلی الحساب"),

	aboutUsTitle("About Us", "درباره ما", "Bizim hakkımızda", "О нас",
			"من نحن","关于我们"),

	helpTitle("Help", "پشتیبانی", "Yardım", "Помощь", "المساعدة","帮助中心"),

	partnerWithUsTitle("Our Partners", "شرکای ما", "Ortaklarımız",
			"Наши партнеры", "شركاؤنا","合作伙伴"),

	newsTitle("News", "اخبار", "Haberler", "Новости", "الاخبار","新闻资讯"),

	contactUsTitle("Contact Us", "تماس با ما", "iletişim", "Свяжитесь с нами",
			"الإتصال بنا","联系我们"),

	termsConditionsTitle("General Terms and Conditions", "شرایط و مقررات",
			"General Terms and Conditions", "General Terms and Conditions",
			"General Terms and Conditions",""),

	zoodelAcademyTitle("Zoodel Academy", "گردهمایی مدیران", "Zoodel Akademi",
			"Академия Zoodel", "أكاديمية زودل","Zoodel学院"),

	iranSMEExportConf("http://conf.zoodel.com/", "NA", "NA", "NA", "NA","NA"),

	exhibitionServices("Exhibition Services","خدمات نمایشگاه","Fuar Hizmetleri","Выставочные услуги","خدمات المعارض","会展服务"),
	
	marketResearch("Market Research","","","","","'"),
	
	zoodPayTitle("ZoodPay (Escrow)", "زودپرداخت (حساب امانی)",
			"ZoodPay", "ZoodPay (Эскроу)", "السداد المبكر","ZoodPay (第三方支付)"),

	businessVerifiedTitle("Business Verified", "تایید کسب و کار",
			"Işletmenin onaylanması", "Business Verified", "Business Verified","已通过商务认证"),

	identityVerifiedTitle("Identity Verified", "تایید هویت",
			"Kimlik doğrulama", "Проверенная компания", "التحقق من الهویة","身份认证"),

	premiumMembershipsTitle("ZOODEL MEMBERSHIP", "عضویت در زودل",
			"ZOODEL'DE ÜYELİK", "MEMBERSHIP IN ZOODEL", "MEMBERSHIP IN ZOODEL","Zoodel 的会员服务"),

	zoodelFinance("Zoodel Finance","خدمات مالی زودل","Zoodel Finans","Zoodel Финансы","شؤون زودل المالية","Zoodel金融"),
	
	postBuyRequirementsTitle("Request Quote", "درخواست قیمت", "fiyat isteği",
			"Запросить цену", "طلب السعر","发布询盘"),

	createYourWebstoreTitle("My Web Store", "فروشگاه من", "benim mağazam",
			"Мой интернет-магазин", "متجری","我的店铺"),

	webStore("Web Store", "فروشگاه", "Online Mağaza", "Интернет-магазин", "المتجر","网上店铺"),

	createYourWebstoreNOW("Create your Web Store NOW",
			"هم اکنون فروشگاه اختصاصی خود را ایجاد کنید",
			"hemen kendi online mağazanızı açın",
			"Создайте свой интернет-магазин СЕЙЧАС",
			"الآن أنشاء المتجر الخاص بک ","立刻创建你的店铺"),

	postYourProductsFree("List your product", "محصولات خود را آگهی کنید",
			"Ürününüzü ekleyin", "Добавить свой товар", "إعلن منتجاتک","发布你的产品"),

	tenders("Tenders","مناقصات","İhaleler","Тендеры","المناقصات","招标信息"),
	
	product("Products", "محصولات", "ürünler", "Продукции", "المنتجات","产品"),

	seller("Sellers", "جهت فروشندگان:", "satıcılar için", "Sellers", "Sellers","卖家"),

	faceBook("https://www.facebook.com/Zoodel?fref=ts", "NA", "NA", "NA", "NA","NA"),

	twitter("https://twitter.com/ZoodelTrade", "NA", "NA", "NA", "NA","NA"),

	linkdin("https://www.linkedin.com/company/zoodel?trk=biz-companies-cym",
			"NA", "NA", "NA", "NA","NA"),
	telegram("https://telegram.me/ZOODELB2B",
			"NA", "NA", "NA", "NA","NA");

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;

	private enum_staticPage(String english, String farsi, String turkish, String russian, String arabic,String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese=chinese;
	}

	private enum_staticPage(String english) {
		this.english = english;
	}

	public String getValue(enum_language lang) {
		switch (lang) {
		case en:
			return english;

		case fa:
			if (farsi == "NA")
				return english;
			else
				return farsi;

		case tr:
			if (turkish == "NA")
				return english;
			else
				return turkish;

		case ru:
			if (russian == "NA")
				return english;
			else
				return russian;

		case ar:
			if (arabic == "NA")
				return english;
			else
				return arabic;
		case cn:
			if (chinese == "NA")
				return english;
			else
				return chinese;

		default:
			return english;
		}
	}
}