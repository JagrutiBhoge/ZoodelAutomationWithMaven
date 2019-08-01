package zoodel.testdata;

public enum enum_companyProfile {

	companyName("Garden Fresco EN1", "Garden Fresco FA", "Garden Fresco TR", "Garden Fresco RU", "Garden Fresco AR",
			"Garden Fresco CN"),

	companyNameAnotherUser("Agro Seeds EN1", "Agro Seeds FA", "Agro Seeds TR",
			"Agro Seeds RU", "Agro Seeds AR", "Agro Seeds CN"),
	
	currencyName("IRR Iran Rial", "IRR ریال ایران", "IRR İran Riyal'i", "IRR Иранский риал", "IRR  ريال إيران",
			"IRR伊朗里亚尔"),

	trader("Trader", "بازرگانی", "Ticari", "Трейдер", "تاجر", "贸易商"),

	ownership("Limited Partnership", "تضامنی محدود", "Sınırlı Ortaklık", "Товарищество с ограниченной ответственностью",
			"شراكة محدودة", "有限合伙制"),

	country("IRAN", "ایران", "İRAN", "ИРАН", "إيران", "伊朗"),
	
	registrationAuthority("IR1989-en", "IR19891-fa", "IR1989-tr", "IR1989-ru", "IR1989-ar","IR1989-cn"),

	street("89- Narayan complex-en", "89- Narayan complex-fa", "89- Narayan complex-tr", "89- Narayan complex-ru",
			"89- Narayan complex-ar","89- Narayan complex-cn"),

	zipCode("390010", "NA", "NA", "NA", "NA","NA"),

	cityName("Tehran-en", "Tehran-fa", "Tehran-tr", "Tehran-ru", "Tehran-ar", "Tehran-cn"),

	countryCode("98", "NA", "NA", "NA","NA","NA"),

	areaCode("2222", "NA", "NA", "NA", "NA","NA"),

	companyNumber("333333", "NA", "NA", "NA", "NA","NA"),

	establishmentYear("2015", "NA", "NA", "NA", "NA","NA"),

	numberofEmployees("150", "NA", "NA", "NA", "NA","NA"),

	annualRevenues("1,200,000", "NA", "NA", "NA", "NA","NA"),

	registrationNo("ISO1989", "NA", "NA", "NA", "NA","NA"),

	website("www.bcssarl.com", "NA", "NA", "NA", "NA","NA"),

	companyUpdatedConfirmationMessage("Company has been updated successfully", "اطلاعات شرکت به روز رسانی شد",
			"Şirket bilgileri başarıyla güncellendi", "Данные о компании успешно обновлны",
			"تم تحدیث معلومات الشرکة بنجاح","公司信息更新已完成"),

	test("en", "fa", "tr", "ru", "ar","cn");

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;
	private enum_companyProfile(String english, String farsi, String turkish, String russian, String arabic,String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese = chinese;
	}

	private enum_companyProfile(String english) {
		this.english = english;
	}

	// public String getValue(enum_language lang) {
	// switch (lang) {
	// case en:
	// return english;
	// case fa:
	// return farsi;
	// case tr:
	// return turkish;
	// case ru:
	// return russian;
	// case ar:
	// return arabic;
	// default:
	// return english;
	// }
	// }

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
