package zoodel.testdata;

public enum enum_addProduct {

	productName("Green Broad Beans1", "گسترده لوبیا سبز1", "Yeşil Bakla1", "Зеленая фасоль Broad",
			"الفول الأخضر","绿色阔豆"),

	productName1("PE", "PF", "PT", "PR", "PA","PC"),

	productName2("ProdEN21", "ProdFA2", "ProdTR2", "ProdRU2", "ProdAR2","ProdCN2"),

	productName3("Broad beans EN1", "Broad beans FA", "Broad beans TR", "Broad beans RU", "Broad beans AR","Broad beans CN"),

	productName4("Dry beans EN1", "Dry beans FA", "Dry beans TR", "Dry beans RU", "Dry beans AR","Dry beans CN"),

	productName5("Product EN1", "Product FA", "Product TR", "Product RU", "Product AR","Product CN"),

	
	Type("Product", "محصول", "Ürün", "Товар", "المنتج","产品"),

	// Product details
	selectCategoryClass("Select Category/Class", "انتخاب مجموعه / کلاس", "Kategori/Sınıf Seç", "Выберите категорию/класс",
			"اختر الفئة / الدرجة","选择分类"),

	// category("Agriculture, Animals, Food & Beverage",
	// "کشاورزی، حیوانات، محصولات غذایی و آشامیدنی",
	// "Tarım, Hayvanlar, Gıda ve içecek",
	// "Сельское хозяйство, животные, продукты питания и напитки",
	// "الزراعة، الحيوانات، المواد الغذائیة و المشروبات"),

	category("Agriculture & Food", "کشاورزی و محصولات غذایی", "Tarım & Gıda",
			"Сельское хозяйство и продукты питания", "الزراعة، المنتجات الغذائية و المشروبات","农业食品"),

	/*
	 * subCategory1("Agriculture & Animals", "کشاورزی و حیوانات",
	 * "Tarım ve Hayvanlar", "Сельское хозяйство и животные",
	 * "Agriculture & Animals"),
	 */

	subCategory1("Agriculture", "کشاورزی", "Tarım", "Сельское хозяйство", "الزراعة و الحيوانات","农业"),

	subCategory2("Beans, Grains & Cereals", "حبوبات، غلات و دانه‌ها", "Baklagiller, Hububatlar & Tahıllar",
			"Бобы, зёрна и злаки", "البقول الغلة و الحبوب","豆类，谷类食物"),

	subCategory3("Beans", "حبوبات", "Bakliyatlar", "Фасоль", "فاصوليا","豆类"),

	class1("Broad Beans", "باقالی", "Kuru Baklalar", "Бобы садовые", "فافا البقول","蚕豆"),

	class2("Lima Beans", "لوبیای لیما (لوبیای آمریکایی)", "Lima Fasulyesi", "Лимская фасоль",
			"فاصوليا بیضاء (الفاصوليا الأمريكية)","利马豆"),
	
	class3("Butter Beans", "لوبیا لیما", "Fasulye", "Фасоль масляная", "فاصوليا بيضاء","奶油豆"),

	HSCode("12345", "NA", "NA", "NA", "NA","NA"),

	modelNumber("390010", "NA", "NA", "NA", "NA","NA"),

	brandName("Tata Tea-en", "Tata Tea-fa", "Tata Tea-tr", "Tata Tea-ru", "Tata Tea-ar","Tata Tea-cn"),

	placeOfOrigin("Afghanistan", "افغانستان", "Afghanistan", "Afghanistan", "Afghanistan","Afghanistan"),

	shelfLife("Shelf Life-en", "Shelf Life-fa", "Shelf Life-tr", "Shelf Life-ru", "Shelf Life-ar","Shelf Life-cn"),

	weight("2300", "NA", "NA", "NA", "NA","NA"),

	packaging("Other", "سایر", "Diğer", "Другой", "أخری","Other"),

	cultivationType("Common", "متداول", "Yaygın","Обычный", "العادیة","Common"),

	Style("Dried", "خشک شده", "Kurutulmuş", "Сушенный", "مجفف","Dried"),

	attributeName("AttName-en", "AttName-fa", "AttName-tr", "AttName-ru", "AttName-ar","AttName-cn"),

	attributeValue("AttValue-en", "AttValue-fa", "AttValue-tr", "AttValue-ru", "AttValue-ar","AttValue-cn"),
	// Desciption
	description("Be as descriptive and detailed as possible to ensure that the Buyer understands what you are selling.",
			"به عنوان توصیفی و دقیق که ممکن است برای اطمینان حاصل شود که خریدار می داند آنچه شما فروش است.",
			"Alıcı ne satıyoruz anlamasını sağlamak için mümkün olduğunca açıklayıcı ve ayrıntılı olun .",
			"Будьте описательный характер и подробно, как можно убедиться, что Покупатель понимает , что вы продаете .",
			"تكون وصفية و تفصيلا ممكن لضمان أن المشتري يفهم ما تقوم ببيعها .","尽可能描述和详细，以确保买方了解您所销售的产品。"),

	keyword("Keywords are critical to be found on Zoodel and on the Web", "لغات کلیدی برای جست و جو در زودل و اینترنت ضرورت دارند.",
			"Zoodel ve Internette bulunacak anahtar kelimeler kritiktir",
			"Ключевые слова крайне важны при поиске на Zoodel и в Интернете",
			"الکلمات الرئیسیةتکون ضروریة للبحث فی زودل و الإنترنت .","关键字在Zoodel和Web上都是至关重要的"),

	// Trade Insurance
	exwPriceCurrency("USD United States Dollar", "USD دلار ایالات متحده", "USD Amerika birleşik devletleri Dolar'ı",
			"USD Доллар США", "USD الدولار الأمريكي",""),

	exwPrice("30,000", "NA", "NA", "NA", "NA","NA"),

	exwPriceUnit("Acre/Acres", "اکر", "Acker", "Акр / акры", "أيسر",""),

	minimumOrderQuantity("50", "NA", "NA", "NA", "NA","NA"),

	tradeInsuranceYes("Yes", "بله", "Evet", "Да", "نعم","是"),

	port("Port En", "Port Fa", "Port Tr", "Port Ru", "Port Ar","Port Cn"),

	paymentTerms("Bank Transfer", "انتقال وجه", "Para transferi", "Банковский перевод", "تحويل الأموال","银行转帐"),

	supplyAbility("350", "NA", "NA", "NA", "NA","NA"),

	supplyAbilityUnit("Box/Boxes", "اکر", "Acker", "Акр / акры", "أيسر","Box/Boxes"),

	supplyAbilityTime("Month", "ماه", "Ay", "Месяц", "شهر","月"),

	per("Per", "هر", "her", "за", "الکل","Per"),

	deliveryTime("15 days", "NA", "NA", "NA", "NA","NA"),

	pakagingDetails(
			"We pack all the products, using quality packaging material to ensure safe and secure transportation.",
			"ما بسته تمام محصولات، با استفاده از مواد بسته بندی با کیفیت برای اطمینان از حمل و نقل امن و مطمئن.",
			"Biz güvenli ulaşım sağlamak için kaliteli ambalaj malzemesi kullanılarak , tüm ürünleri paketi.",
			"Мы упаковываем все продукты , с использованием качественного упаковочного материала для обеспечения безопасной и надежной транспортировки.",
			"نحن حزمة جميع المنتجات ، وذلك باستخدام مواد التعبئة والتغليف عالية الجودة ل ضمان النقل الآمن وآمنة.","我们包装所有产品，使用优质的包装材料，以确保运输安全可靠。"),

	// Success message
	imageUploadMsg("Product main photo has been uploaded successfully", "تصویر اصلی محصول با موفقیت بارگذاری شد",
			"Ürünün ana fotoğrafı başarıyla yüklendi", "Главная фотография продукции успешно загружена",
			"تم تحمیل الصورة الرئیسیة بنجاح","产品主图片已上传成功"),

	productSuccessMsg("Product has been saved successfully", "محصول با موفقیت ذخیره شد", "Ürün başarıyla kaydedildi",
			"Продукция успешно сохранена", "تم تخزین المنتج بنجاح","产品已保存成功"),

	modifyProductSucessMsg("Your Product is saved successfully and will be published soon",
			"محصول شما ثبت شده است و به زودی منتشر می شود", "Ürününüz başarıyla kaydedildi ve yakında yayınlanacak",
			"Ваша продукция успешно сохранена и будет скоро опубликована.",
			"يتم حفظ المنتج الخاص بك بنجاح وسيتم نشره قريبا","你的产品已经保存成功，很快将会上架"),

	removeProductSucessMsg("Product Deleted Successfully..", "حذف شد محصول با موفقیت تغییر کرد",
			"Ürün başarıyla Silindi..", "Продукт успешно удален.", "تم حذفه تم تغییر المنتج بنجاح","产品已成功删除"),

	previewLink("Preview", "پیش نمایش", "Önizleme", "Предварительный просмотр", "عرض مسبق","预览"),

	modifyLink("Modify", "ویرایش", "Değiştir", "Редактировать", "تعدیل","修改"),

	removeLink("Remove", "حذف", "Kaldır", "Удалить", "إزالة","移除"),

	publishLink("Publish","انتشار","Yayınla","Опубликовать","نشر","发布"),
	// Status
	productStatusPending("Pending", "در حالت انتظار", "Bekliyor", "Ожидает решения", "فی حالة الانتظار","待审核"),

	productStatusNew("New", "جدید", "Yeni", "новый", "جدید","新的"), 
	
	productStatusPublish("Published", "منتشر شد","Yayınlanmış",	"Опубликовано", "تم نشره","Published"),

	productStatusRejected("Rejected", "قبول نشده است", "Reddedildi", "Отклонено", "یرفض","Rejected"),

	productStatusUnPublish("Unpublished", "انتشار لغو شد", "Yayınlanmamış", "Не опубликован", "لم یتم نشره","已取消发布"),

	productStatusSuspended("Suspended", "به حالت تعلیق", "Askıda", "Приостановлено", "معلق","Suspended"),   //Back Office

	productStatusVerified("Verified", "تایید شده","Doğrulanmış","Проверенный","تم تصدیقه","Verified"),
	
	productStatusUnVerified("Unverified","تایید نشده","取消认证","Doğrulanmamış","Unverified","Unverified"),
	
	productStatusToVerify("To Verify","به منظور بررسی","Doğrulamak için", "Проверять", "للتحقق","To Verify"),
	
	productStatusProductModified("Product Modified","اصلاح شده","Değiştirilen Ürün","Товар изменён","التعديل المنتج","Product Modified"),

	productStatusReadyToPublish("Ready to publish", "آماده انتشار", "Yayınlanmaya hazır", "Готово к публикации", "على استعداد لنشر","等待发布");   //Back Office

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;
	
	private enum_addProduct(String english, String farsi, String turkish, String russian, String arabic,String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese=chinese;
	}

	private enum_addProduct(String english) {
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
