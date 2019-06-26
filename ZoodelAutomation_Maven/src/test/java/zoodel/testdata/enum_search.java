package zoodel.testdata;

public enum enum_search {

	allCategories("All categories", "همه مجموعه‌ها", "Tüm Guruplar", "Все категории", "جمیع الأقسام", "所有分类"),

	product("Product", "محصول", "ürün", "Продукция", "المنتج", "产品"),

	products("Products", "محصولات", "ürünler", "Товары", "المنتجات", "产品"),

	seller("Seller", "فروشنده", "satıcı", "Продавец", "البائع", "卖家"),

	sellers("Sellers", "فروشندگان", "satıcılar", "Продавцы", "البیاع", "卖家"),

	seeAllCategories("See All Categories", "جستجو در همه مجموعه‌ها", "Tüm Guruplarda Ara", "Посмотреть все категории",
			"البحث فی جمیع الأقسام", "查看所有分类"),

	// beans("Beans", "", "", "", ""),

	// broadBeans("Broad Beans","","","",""),

	premiumSeller("Premium Seller", "فروشنده ویژه", "özel satıcı", "Премиум-продавец", "بائع خاص", "高级会员"),

	identityVerified("Identity Verified", "فروشنده مورد تایید", "kimlik doğrulama", "Подтвержденная личность",
			"تم تصدیق الهویة", "身份认证"),

	onlyIranianSeller("Only Iranian Seller", "فقط فروشندگان ایرانی", "sadece İran'li satıcılar",
			"Только иранские продавцы", "البائعون الإیرانیین فقط", "Only Iranian Seller"),

	business_verified("Business Verified", "تایید کسب و کار", "İşletme onayı", "Подтвержденный бизнес", "تصدیق العمل",
			"已通过商务认证"),

	premium_memberships("Premium Memberships", "عضویت ویژه", "Özel üyelik", "Премиальное членство", "إشتراک خاص", "会员权益"),

	identity_verified("Identity Verified", "فروشنده مورد تایید", "kimlik doğrulama", "Подтвержденная личность",
			"تم تصدیق الهویة", "身份认证"),

	country("IRAN", "ایران", "İRAN", "ИРАН", "إيران", "伊朗");

	// isPremium("premium"),

	// isIdentityVerified("verified"),

	// isOnlyIranianSeller("IR");

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;

	private enum_search(String english, String farsi, String turkish, String russian, String arabic, String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese = chinese;
	}

	private enum_search(String english) {
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
