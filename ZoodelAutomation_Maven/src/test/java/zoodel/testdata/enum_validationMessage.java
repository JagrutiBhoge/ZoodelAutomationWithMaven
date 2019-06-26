package zoodel.testdata;

public enum enum_validationMessage {

	invalidLogin("Please enter your verified email address", "لطفا ایمیل تاییدشده خود را وارد کنید",
			"Lütfen doğrulanmış e-posta adresinizi girin", "Пожалуйста, введите подтверждённый адрес email",
			"يرجى إدخال عنوان بريدك الإلكتروني الذي تم التحقق منه", "请输入你已经认证的电子邮箱地址"),

	msgInvalidLoginAttempt("Invalid login attempt!!!", "ورود به حساب کاربری با مشکل روبرو شد!",
			"kullanıcı hesabına giriş sorunludur", "Не удалось войти в систему !!!", "لم یمکن الدخول إلی الحساب !",
			"无效的登陆请求！！！"),

	requiredFieldValidation("* This field is required.", "* این فیلد ضروری است.", "* Bu alan zorunludur.",
			"* Необходимо заполнить.", "* هذا الحقل مطلوب.", ""),

	invalidEmailFieldValidation("* Invalid email address.", "* یک آدرس ایمیل معتبر وارد کنید.",
			"* Geçersiz e-posta adresi.", "* Неверный адрес электронной почты.", "* عنوان البريد الإلكتروني غير صالح.",
			""),

	imageValidationSize("Image size must be smaller than 4 MB", "سایز عکس باید کمتر از 4 مگابایت باشد",
			"Resim boyutu 4MB ve daha küçük olmalıdır", "Размер файла должна быть не более 4 мб",
			"يجب أن يكون حجم الصورة أصغر من 4MB", "图片大小必须小于4MB"),

	imageValidationFileFormat("Supported formats: jpeg, jpg, gif, or png Size: 4MB",
			"فرمت های مورد تایید: jpeg، jpg، gif یا pngسایز:۴ مگابایت",
			"Desteklenen Formatlar: gif, jpg, jpeg veya png Boyut:4MB",
			"Поддерживаются файлы jpeg, jpg, gif и png, размером до 4 Мб",
			"الصیغ المسموحة: JPEG، JPG، GIF، PNG أو حجم: 4M", "文件支持格式: jpeg, jpg, gif, png 最大: 4MB"),

	contactPhotoValidationMsg("Contact photo has been uploaded successfully", "عکس با موفقیت بارگذاری شد",
			"İletişim fotoğrafı başarıyla yüklendi", "Фото контактного лица успешно загружено",
			"تم تحميل صورة طرف الإتصال للشرکة بنجاح", "联系人照片已经上传成功"),

	minimumcharacterValidationMsg("* Minimum 3 characters allowed.", "* حداقل 3 حرف ضروری است.",
			"* Bu alana en az 3 karakter girmelisiniz .", "* Минимум 3 символа(ов).", "* على الأقل 3 حروف مطلوبة.", ""),

	selectImageValidationMsg("Please select product photo", "لطفا عکس کالا را انتخاب کنید.",
			"Lütfen ürün fotoğrafını seçin", "Выберите, пожалуйста, фотографию продукции", "یرجی اختیار صورة البضاعة .",
			"请选择产品图片"),

	PublishLinkValidationMsg("Product publish request sent successfully", "درخواست انتشار محصول با موفقیت ارسال شد.",
			"Ürün yayınlama isteği başarıyla gönderildi", "Запрос на размещение товара успешно отправлен",
			"المنتج تنشر طلب إرسال بنجاح", "产品上架请求已发送成功"), // add
	// product
	// after click on unpublish product,display publish link.

	verifiedAndRequestToPublishSucessfullyMsg("Product information verified successfully",
			"اطلاعات مربوط به محصول با موفقیت تایید شد", "Ürün bilgileri başarıyla doğrulandı",
			"Информация о продукте успешно проверена", "معلومات عن المنتج التحقق بنجاح", "产品信息已通过审核"),

	invalidURLValidationMsg("* Invalid URL.", "* نشانی معتبر وارد کنید.", "* Geçersiz URL.", "* Неправильный URL.",
			"یرجی اختیار صورة البضاعة .", ""),

	max10ImagesAllowed("Max. 10 images allowed", "حداکثر 10 عکس می توانید ارسال کنید", "En fazla 10 resim",
			"Допускается максимум 10 изображений", "حد الاقصی یمکن إرسال 10 صور", "最多10张图片"),

	registrationNoAlreadyExist("Registration No. is already Exist", "کد ملی قبلاً ثبت شده است.",
			"Kayıt Numarası zaten mevcut", "Регистрационный номер уже существует", "تم تسجیل الرقم القومی سابقاً",
			"注册号已存在"),

	selectAnOption("* Please select an option.", "* لطفا یک گزینه را انتخاب کنید.",
			"* Lütfen bir seçeneği işaretleyiniz.", "* Вы должны выбрать вариант.", "* برجاء إختيار إحدى الخيارات.",
			""), // Company profile

	locationUnique("Location Should be unique", "موقعیت باید منحصر به فرد باشد", "Konum Benzersiz Olmalıdır",
			"Местоположение должно быть уникальным", "یجب أن الموافق تکون فریدة من نوعها", "地点只能有一个"), // Request
	// Quote page

	rfqWithOutLogin("Your requirements sent successfully. Kindly register now to complete the process.",
			"مورد نیاز شما با موفقیت ارسال. لطفا ثبت نام در حال حاضر به تکمیل روند.",
			"İhtiyaçlarınız başarıyla gönderildi. İşlemi tamamlamak için lütfen şimdi kayıt olun.",
			"Ваши требования отправлены успешно. Пожалуйста, зарегистрируйтесь сейчас, чтобы завершить процесс.",
			"تم إرسال المتطلبات بنجاح. يرجى التسجيل الآن لإكمال العملية.", "您的要求发送成功。请现在注册完成这个过程。"),

	rfqRecievedBackOffice("RFQ details sent successfully to the selected sellers",
			"جزئیات استعلام با موفقیت برای فروشندگان مورد نظر ارسال شد",
			"Fiyat Talebi ayrıntıları seçilen satıcılara başarıyla gönderildi",
			"Информация о ценовом запросу успешно отправлена выбранным продавцам",
			"RFQ details sent successfully to the selected sellers", "询盘详细内容已经成功发送给选择的卖家"), // Back
	// office validation message.

	requestQuoteUploadFile("Quote has been uploaded successfully", "درخواست قیمت با موفقیت بارگذاری شد.",
			"fiyat isteği başarıyla yüklendi", "Коммерческое предложение успешно загружено",
			"تم تحمیل طلب السعر بنجاح .", "文件已经上传成功"),

	quotationSentMsg("Your quotation has been sent successfully.", "نقل قول شما با موفقیت ارسال شد.",
			"Teklifiniz başarıyla gönderildi.", "Ваша цитата отправлена ​​успешно.", "تم إرسال الاقتباس بنجاح.",
			"您的报价已成功发送。"),

	// =====Message tab======
	rfqCloseMessage("Your quote has been closed successfully", "درخواست شما با موفقیت بسته شد",
			"Teklifiniz başarıyla kapandı", "Ваше коммерческое предложение успешно закрыто",
			"Your quote has been closed successfully", "你的询盘已经成功关闭"),

	supportedFileSizeRequestQuote("Supported file Size: 15MB", "سایز فایل مورد تایید: 15 مگابایت",
			"dosyanin geçerli boyutu : 15 mg", "Подходящий размер файла: 15 мб", "بدعم حجم الملف: 15MB",
			"支持的最大文件：15MB"), // Request Quote page

	productVerifiedSuccessMsg("Product Verified Successfully..", "محصولات تایید شده با موفقیت ..",
			"Ürün Başarıyla Doğrulanmıştır ..", "Продукт проверен успешно ..", "تم التحقق من المنتج بنجاح ..", "产品验证成功");

	private String english;
	private String farsi;
	private String turkish;
	private String russian;
	private String arabic;
	private String chinese;

	private enum_validationMessage(String english, String farsi, String turkish, String russian, String arabic,
			String chinese) {
		this.english = english;
		this.farsi = farsi;
		this.turkish = turkish;
		this.russian = russian;
		this.arabic = arabic;
		this.chinese = chinese;
	}

	private enum_validationMessage(String english) {
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
