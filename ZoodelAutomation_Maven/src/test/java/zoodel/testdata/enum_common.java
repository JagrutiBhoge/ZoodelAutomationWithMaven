package zoodel.testdata;

public enum enum_common {

	/*url_public("http://qa.zoodel.com:8240/", "http://qa.zoodel.com:8240/",
			"http://qa.zoodel.com:8240/", "http://qa.zoodel.com:8240/",
			"http://qa.zoodel.com:8240/"),

	url_backOffice("http://qa.zoodel.com:8199/en",
			"http://qa.zoodel.com:8199/", "http://qa.zoodel.com:8199/",
			"http://qa.zoodel.com:8199/", "http://qa.zoodel.com:8199/"),*/
	

	specialCharacter("`~!@#$^?&*()_=:;\\//.-<>,+[]{}|", "NA", "NA", "NA", "NA","NA"), 
	
	character(
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ,"NA","NA","NA","NA","NA");

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;
	
	private enum_common(String english, String farsi, String turkish,
			String russian, String arabic,String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese = chinese;
}

	private enum_common(String english) {
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
