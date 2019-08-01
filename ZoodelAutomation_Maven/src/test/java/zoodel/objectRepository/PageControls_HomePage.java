package zoodel.objectRepository;

import org.openqa.selenium.By;

public class PageControls_HomePage {
	public By zoodelLogo = By.xpath("//div[@class='navbar-header']/div/a/img[@class='logoMain']");
	public By lnkBrowseAllSeller = By
			.xpath("//div[@class='browseBtn']/ul//descendant::li[1]/a[contains(@href,'sellers')]");
	public By lnkBrowseAllProduct = By.xpath("//div[@class='browseBtn']/ul//descendant::a[contains(@href,'products')]");
	public By lnkFaceToFaceMeeting = By
			.xpath("//div[@class='browseBtn']/ul//descendant::a[contains(@href,'exhibition-services')]");
	public By lnkCheckShippingRate = By
			.xpath("//div[@class='browseBtn']/ul//descendant::a[contains(@href,'logistics')]");
	public By lnkViewAllTender = By.xpath("//div[@class='browseBtn']/ul//descendant::a[contains(@href,'tenders')]");
	public By lnkSellOnZoodel = By
			.xpath("//div[@class='browseBtn']/ul//descendant::a[contains(@href,'addProduct')]/div[2]");

	public By register = By.id("callJoinFreeTemplate");
	public By sellerTabActive = By
			.xpath("//ul[@id='search-tabs']/li[2]/span[contains(@class,'cursor-pointer seller-tab')]");
	public By productTabActive = By
			.xpath("//ul[@id='search-tabs']/li[1]/span[contains(@class,'cursor-pointer seller-tab')]");

	public By securePayment = By.xpath("//ul[@class='text-center']//descendant::a[contains(@href,'zoodpay')]");

	public By lblSearchTextCount = By.xpath("//div[contains(@class,'countSearch')]/h1[@class='searched-text']/b");
	public By lblSearchText = By
			.xpath("//div[contains(@class,'countSearch')]/h1[@class='searched-text']/span[@class='text-green']");

	public By lblCatidSubidCount = By
			.xpath("//div[contains(@class,'countSearch')]/h1[@class='searched-count']/b[@class='total-count']");
	public By lblCatidSubidText = By
			.xpath("//div[contains(@class,'countSearch')]/h1[@class='searched-count']/b[@class='paddingRight5']");

	public By lblSearchNoFoundText = By.xpath("//div[contains(@class,'searchNotFoundText')]/h5/span");

	public By productSellerNotFound = By
			.xpath("//div[@class='productSellerNotFound']//descendant::div[contains(@class,'searchNotFoundText')]");
	public By lblProductSellerNotfoundText = By.xpath("//div[contains(@class,'searchNotFoundText')]/h5/span");

	// ::::::::Category,Sub Category,SubSub Category,SubSubSub Category::::::
	// ============Agriculture & Food
	public By agricultureAnimalsFoodBeverage = By
			.xpath("//a[contains(@href,'agriculture_animals_food_beverage')]/h3");
	public By agricultureAnimalsFoodBeverageProductCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(), 'Search All Products') and contains(@href,'products?categoryId=agriculture_animals_food_beverag')]");
	public By agricultureAnimalsFoodBeverageSellerCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(), 'Search All Sellers') and contains(@href,'sellers?categoryId=agriculture_animals_food_beverag')]");

	public By foodBeverage = By.xpath("//a[contains(@href,'subCategoryId=food_beverage')]/h3");
	public By foodBeverageProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Products') and contains(@href,'food_beverage')]");
	public By foodBeverageSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'food_beverage')]");

	public By agricultureAnimals = By
			.xpath("//a[contains(@href,'subCategoryId=agriculture_animal')]/h3");
	public By agricultureAnimalsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Products') and contains(@href,'agriculture_animal')]");
	public By agricultureAnimalsSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'agriculture_animal')]");

	public By beansGrainsCereals = By.xpath("//a[contains(@href,'beans_grains_cereals')]/h3"); // beans_grains_cereals
	public By beansGrainsCerealsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Products') and contains(@href,'beans_grains_cereals')]");
	public By beansGrainsCerealsSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'beans_grains_cereals')]");

	public By nutsKernels = By.xpath("//a[contains(@href,'nuts_kernels')]/h3"); // .xpath("//a[contains(@href,'/nuts_kernels')]/div/h3");
	public By nutsKernelsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Products') and contains(@href,'nuts_kernels')]");
	public By nutsKernelsSellerCount = By
			.xpath("//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'nuts_kernels')]");
	// ======= Building Construction
	public By buildingConstruction = By.xpath("//a[contains(@href,'building_construction')]/h3");
	public By buildingConstructionProductCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(), 'Search All Products') and contains(@href,'building_construction')]");
	public By buildingConstructionSellerCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'building_construction')]");

	public By buildingMaterialsSupplies = By.xpath("//a[contains(@href,'building_materials_supplies')]/h3");
	public By buildingMaterialsSuppliesProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'building_materials_supplies')]");
	public By buildingMaterialsSuppliesSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'building_materials_supplies')]");

	public By steelMetalStructuresEquipment = By
			.xpath("//a[contains(@href,'steel_metal_structures_equipment')]/h3");
	public By steelMetalStructuresEquipmentProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'steel_metal_structures_equipment')]");
	public By steelMetalStructuresEquipmentSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'steel_metal_structures_equipment')]");

	public By designDecorationOtherStructures = By
			.xpath("//a[contains(@href,'design_decoration_other_structures')]/h3");
	public By designDecorationOtherStructuresProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'design_decoration_other_structures')]");
	public By designDecorationOtherStructuresSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'design_decoration_other_structures')]");

	public By machineryConstructionEquipment = By
			.xpath("//a[contains(@href,'machinery_construction_equipment')]/h3");
	public By machineryConstructionEquipmentStructuresProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'machinery_construction_equipment')]");
	public By machineryConstructionEquipmentStructuresSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'machinery_construction_equipment')]");

	// =========== Rubber & Plastics
	public By rubberPlastics = By.xpath("//a[contains(@href,'rubber_plastics')]/h3");
	public By rubberPlasticsProductCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(), 'Search All Products') and contains(@href,'rubber_plastics')]");
	public By rubberPlasticsSellerCount = By.xpath(
			"//div[contains(@class,'categoryInsideBox')]//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'rubber_plastics')]");

	public By plasticProducts = By.xpath("//a[contains(@href,'plastic_products')]/h3");
	public By plasticProductsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'plastic_products')]");
	public By plasticProductsSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'plastic_products')]");

	public By plasticRawMaterials = By.xpath("//a[contains(@href,'plastic_raw_materials')]/h3");
	public By plasticRawMaterialsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'plastic_raw_materials')]");
	public By plasticRawMaterialsSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'plastic_raw_materials')]");

	public By rubberProducts = By.xpath("//a[contains(@href,'rubber_products')]/h3");
	public By rubberProductsProductCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(), 'Search All Products') and contains(@href,'rubber_products')]");
	public By rubberProductsSellerCount = By.xpath(
			"//div[@class='categoryInsideBox']//descendant::a[contains(text(),'Search All Sellers') and contains(@href,'rubber_products')]");

	public By rubberRawMaterials = By.xpath("//a[contains(@href,'rubber_raw_materials')]/h3");
	public By rubberRawMaterialsProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'rubber_raw_materials')]");
	public By rubberRawMaterialsSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'rubber_raw_materials')]");

	// ========Apparel, Textiles, Shoes, Bags, Jewelry & Accessories
	public By apparelTextilesShoesBagsJewelryAccessories = By
			.xpath("//a[contains(@href,'apparel_textiles_shoes_bags_jewelry_accessories')]/h3");
	public By apparelTextilesShoesBagsJewelryAccessoriesProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'apparel_textiles_shoes_bags_jewelry_accessories')]");
	public By apparelTextilesShoesBagsJewelryAccessoriesSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'apparel_textiles_shoes_bags_jewelry_accessories')]");

	public By apparelGarments = By.xpath("//a[contains(@href,'apparel_garments')]/h3");
	public By apparelGarmentsProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'apparel_garments')]");
	public By apparelGarmentsSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'apparel_garments')]");

	public By bagsLuggageCases = By.xpath("//a[contains(@href,'bags_luggage_cases')]/h3");
	public By bagsLuggageCasesProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'bags_luggage_cases')]");
	public By bagsLuggageCasesSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'bags_luggage_cases')]");

	public By shoesFootwearAccessories = By.xpath("//a[contains(@href,'shoes_footwear_accessories')]/h3");
	public By shoesFootwearAccessoriesProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'shoes_footwear_accessories')]");
	public By shoesFootwearAccessoriesSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'shoes_footwear_accessories')]");

	public By textileLeatherGoods = By.xpath("//a[contains(@href,'textile_leather_goods')]/h3");
	public By textileLeatherGoodsProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'textile_leather_goods')]");
	public By textileLeatherGoodsSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'textile_leather_goods')]");

	// ===========Metallurgy, Chemicals, Energy
	public By metallurgyChemicalsEnergy = By
			.xpath("//a[contains(@href,'metallurgy_chemicals_energy_rubber_plastics')]/h3");
	public By metallurgyChemicalsEnergyProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'metallurgy_chemicals_energy_rubber_plastics')]");
	public By metallurgyChemicalsEnergySellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'metallurgy_chemicals_energy_rubber_plastics')]");

	public By chemicalsWasteManagementDyesSolvents = By
			.xpath("//a[contains(@href,'chemicals_waste_management_dyes_solvents')]/h3");
	public By chemicalsWasteManagementDyesSolventsProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'chemicals_waste_management_dyes_solvents')]");
	public By chemicalsWasteManagementDyesSolventsSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'chemicals_waste_management_dyes_solvents')]");

	public By energy = By.xpath("//a[contains(@href,'subCategoryId=energy')]/h3");
	public By energyProductCount = By
			.xpath("//a[contains(text(), 'Search All Products') and contains(@href,'subCategoryId=energy')]");
	public By energySellerCount = By
			.xpath("//a[contains(text(),'Search All Sellers') and contains(@href,'subCategoryId=energy')]");

	public By metalsMineralsOresAlloys = By.xpath("//a[contains(@href,'metals_minerals_ores_alloys')]/h3");
	public By metalsMineralsOresAlloysProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'metals_minerals_ores_alloys')]");
	public By metalsMineralsOresAlloysSellerCount = By.xpath(
			"//a[contains(text(),'Search All Sellers') and contains(@href,'metals_minerals_ores_alloys')]");

	public By healthcareCosmeticsPersonalCare = By
			.xpath("//a[contains(@href,'healthcare_cosmetics_personal_care')]/h3");
	public By healthcareCosmeticsPersonalCareProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'healthcare_cosmetics_personal_care')]");
	public By healthcareCosmeticsPersonalCareSellerCount = By.xpath(
			"//a[contains(text(), 'Search All Sellers') and contains(@href,'healthcare_cosmetics_personal_care')]");

	//Search page
	public By bredcumchemiWasteMngementDyesSolvents = By.xpath("//a[@id='chemicals_waste_management_dyes_solvents']");
	
	// =============Iran Hightech=======
	public By iranHightech = By.xpath("//a[contains(@href,'products?tag=high-tech')]/h3");
	public By iranHightechProductCount = By
			.xpath("//a[contains(text(), 'Search All Products') and contains(@href,'products?tag=high-tech')]");
	public By iranHightechSellerCount = By
			.xpath("//a[contains(text(), 'Search All Sellers') and contains(@href,'sellers?tag=high-tech')]");

	public By advancedMaterialAndNanoTechnology = By.xpath("//a[contains(@href,'nano')]/h3");
	public By advancedMaterialAndNanoTechnologyProductCount = By
			.xpath("//a[contains(text(), 'Search All Products') and contains(@href,'nano')]");
	public By advancedMaterialAndNanoTechnologySellerCount = By
			.xpath("//a[contains(text(), 'Search All Sellers') and contains(@href,'nano')]");

	public By biotechnology = By.xpath("//a[contains(@href,'bio')]/h3");
	public By biotechnologyProductCount = By
			.xpath("//a[contains(text(), 'Search All Products') and contains(@href,'bio')]");
	public By biotechnologySellerCount = By
			.xpath("//a[contains(text(), 'Search All Sellers') and contains(@href,'bio')]");

	public By advancedManufacturingLaboratoryEquipment = By
			.xpath("//a[contains(@href,'machinery_industrial_plant_hardware_parts_tools')]/h3");
	public By advancedManufacturingLaboratoryEquipmentProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'machinery_industrial_plant_hardware_parts_tools')]");
	public By advancedManufacturingLaboratoryEquipmentSellerCount = By.xpath(
			"//a[contains(text(), 'Search All Sellers') and contains(@href,'machinery_industrial_plant_hardware_parts_tools')]");

	public By advancedElectronicPowerTelecommunicationEquipment = By
			.xpath("//a[contains(@href,'electrical_equipment_components_and_lights')]/h3");
	public By advancedElectronicPowerTelecommunicationEquipmentProductCount = By.xpath(
			"//a[contains(text(), 'Search All Products') and contains(@href,'electrical_equipment_components_and_lights')]");
	public By advancedElectronicPowerTelecommunicationEquipmentSellerCount = By.xpath(
			"//a[contains(text(), 'Search All Sellers') and contains(@href,'electrical_equipment_components_and_lights')]");

	// :::::::::::::::::::::::: Class list:::::::::::::::::
	// ==============Agriculture & Food===================
	public By pistachioNuts = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='pistachio_nuts']/a");
	public By pistachioNutsCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='pistachio_nuts']/a//descendant::span[contains(@class,'countColor')]");
	public By biscuits = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='biscuits']/a");
	public By biscuitsCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='biscuits']/a//descendant::span[contains(@class,'countColor')]");
	public By tomatoPaste = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='tomato_paste']/a");
	public By tomatoPasteCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='tomato_paste']/a//descendant::span[contains(@class,'countColor')]");
	public By milk = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/milk')]");
	public By milkCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/milk')]//descendant::span[contains(@class,'countColor')]");
	public By saffron = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='saffron']/a");
	public By saffronCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='saffron']/a//descendant::span[contains(@class,'countColor')]");
	public By yogurt = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/yogurt')]");
	public By yogurtCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/yogurt')]//descendant::span[contains(@class,'countColor')]");
	public By fruitVegetableJuice = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='fruit_vegetable_juice']/a");
	public By fruitVegetableJuiceCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='fruit_vegetable_juice']/a//descendant::span[contains(@class,'countColor')]");
	public By date = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='date']/a");
	public By dateCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='date']/a//descendant::span[contains(@class,'countColor')]");
	public By chocolate = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='chocolate']/a");
	public By chocolateCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='chocolate']/a//descendant::span[contains(@class,'countColor')]");
	public By honey = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='honey']/a");
	public By honeyCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='honey']/a//descendant::span[contains(@class,'countColor')]");
	public By pickles = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='pickles']/a");
	public By picklesCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='pickles']/a//descendant::span[contains(@class,'countColor')]");
	public By singleSpicesHerbs = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/single_spices_herbs')]");
	public By singleSpicesHerbsCount = By.xpath(
			"//li/a[contains(@href,'/products/cid/single_spices_herbs')]//descendant::span[contains(@class,'countColor')]");
	public By cannedVegetables = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/canned_vegetables')]");
	public By cannedVegetablesCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/canned_vegetables')]//descendant::span[contains(@class,'countColor')]");
	public By jellyPudding = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='jelly_pudding']/a");
	public By jellyPuddingCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='jelly_pudding']/a//descendant::span[contains(@class,'countColor')]");
	public By instantCoffee = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/instant_coffee')]");
	public By instantCoffeeCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/instant_coffee')]//descendant::span[contains(@class,'countColor')]");
	public By flour = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/flour')]");
	public By flourCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[@class='item-selection list-styled hidden-xs']/li/a[contains(@href,'/products/cid/flour')]//descendant::span[contains(@class,'countColor')]");
	public By raisin = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='raisin']/a");
	public By raisinCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='raisin']/a//descendant::span[contains(@class,'countColor')]");
	public By dairyProducts = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='dairy_products']/a");
	public By dairyProductsCount = By.xpath(
			"//ul[@data-category='agriculture_animals_food_beverage']/li[@id='dairy_products']/a//descendant::span[contains(@class,'countColor')]");

	// ===========Building & Construction
	public By cement = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='cement']/a");
	public By cementCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='cement']/a//descendant::span[contains(@class,'countColor')]");
	public By granite = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='granite']/a");
	public By graniteCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='granite']/a//descendant::span[contains(@class,'countColor')]");
	public By tiles = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='tiles']/a");
	public By tilesCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='tiles']/a//descendant::span[contains(@class,'countColor')]");
	public By bathShowerFaucets = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/bath_shower_faucets')]");
	public By bathShowerFaucetsCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/bath_shower_faucets')]//descendant::span[contains(@class,'countColor')]");
	public By buildingBlocks = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/building_blocks')]");
	public By buildingBlocksCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/building_blocks')]//descendant::span[contains(@class,'countColor')]");
	public By energySavingFluorescent = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/energy_saving_fluorescent')]");
	public By energySavingFluorescentCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/energy_saving_fluorescent')]//descendant::span[contains(@class,'countColor')]");
	public By ceramic = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='ceramic']/a");
	public By ceramicCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='ceramic']/a//descendant::span[contains(@class,'countColor')]");
	public By coolingHeatingSystem = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='electronic_cooling_heating_systems_installations']/a");
	public By coolingHeatingSystemCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='electronic_cooling_heating_systems_installations']/a//descendant::span[contains(@class,'countColor')]");
	public By light = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='lights_lighting_products_accessories']/a");
	public By lightCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='lights_lighting_products_accessories']/a//descendant::span[contains(@class,'countColor')]");
	public By powerCables = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='power_cables']/a");
	public By powerCablesCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='power_cables']/a//descendant::span[contains(@class,'countColor')]");
	public By steelProducts = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='steel_stainless_steel']/a");
	public By steelProductsCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='steel_stainless_steel']/a//descendant::span[contains(@class,'countColor')]");
	public By marble = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='marble']/a");
	public By marbleCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='marble']/a//descendant::span[contains(@class,'countColor')]");
	public By elevatorParts = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='elevator_parts']/a");
	public By elevatorPartsCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='elevator_parts']/a//descendant::span[contains(@class,'countColor')]");
	public By gypsumPowder = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='gypsum_powder']/a");
	public By gypsumPowderCount = By.xpath(
			"//ul[@data-category='building_construction']/li[@id='gypsum_powder']/a//descendant::span[contains(@class,'countColor')]");
	public By otherMetalsMetalProducts = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_metals_metal_products')]");
	public By otherMetalsMetalProductsCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_metals_metal_products')]//descendant::span[contains(@class,'countColor')]");
	public By ironPlateRebarWire = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/iron_plate_rebar_wire')]");
	public By ironPlateRebarWireCount = By.xpath(
			"//div[contains(@class,'mainCtaeWidth')]/ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/iron_plate_rebar_wire')]//descendant::span[contains(@class,'countColor')]");

	// ======== Rubber & Plastics
	public By plasticProfiles = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='plastic_profiles']/a");
	public By plasticProfilesCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='plastic_profiles']/a//descendant::span[contains(@class,'countColor')]");
	public By plasticFilms = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='plastic_films']/a");
	public By plasticFilmsCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='plastic_films']/a//descendant::span[contains(@class,'countColor')]");
	public By homeAppliancePlastic = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='home_appliance_plastic']/a");
	public By homeAppliancePlasticCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='home_appliance_plastic']/a//descendant::span[contains(@class,'countColor')]");
	public By otherPlasticProducts = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_plastic_products')]");
	public By otherPlasticProductsCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_plastic_products')]//descendant::span[contains(@class,'countColor')]");
	public By plasticTubes = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='plastic_tubes']/a");
	public By plasticTubesCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='plastic_tubes']/a//descendant::span[contains(@class,'countColor')]");
	public By zipBags = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/packaging_laminated_zip_bags')]");
	public By zipBagsCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/packaging_laminated_zip_bags')]//descendant::span[contains(@class,'countColor')]");
	public By pvc = By.xpath("//ul[@data-category='rubber_plastics']/li[@id='pvc']/a");
	public By pvcCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='pvc']/a//descendant::span[contains(@class,'countColor')]");
	public By polymers = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='polymers']/a");
	public By polymersCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='polymers']/a//descendant::span[contains(@class,'countColor')]");
	public By plasticMasterbatches = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='plastic_masterbatches']/a");
	public By plasticMasterbatchesCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='plastic_masterbatches']/a//descendant::span[contains(@class,'countColor')]");
	public By carTires = By
			.xpath("//ul[@data-category='rubber_plastics']/li[@id='car_tires']/a");
	public By carTiresCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='car_tires']/a//descendant::span[contains(@class,'countColor')]");
	public By eps = By.xpath("//ul[@data-category='rubber_plastics']/li[@id='eps']/a");
	public By epsCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='eps']/a//descendant::span[contains(@class,'countColor')]");
	public By plasticSheets = By.xpath("//ul[@data-category='rubber_plastics']/li[@id='plastic_sheets']/a");
	public By plasticSheetsCount = By.xpath(
			"//ul[@data-category='rubber_plastics']/li[@id='plastic_sheets']/a//descendant::span[contains(@class,'countColor')]");

	// ===== Apparel, Textiles, Handicrafts & Fashion Accessorie
	public By carpet = By.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='carpet']/a");
	public By carpetCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='carpet']/a//descendant::span[contains(@class,'countColor')]");
	public By shoes = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='shoes_footwear_accessories']/a");
	public By shoesCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='shoes_footwear_accessories']/a//descendant::span[contains(@class,'countColor')]");
	public By socks = By.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='socks']/a");
	public By socksCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='socks']/a//descendant::span[contains(@class,'countColor')]");
	public By sandalsFlipFlops = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/sandals_flip_flops')]");
	public By sandalsFlipFlopsCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/sandals_flip_flops')]//descendant::span[contains(@class,'countColor')]");
	public By jackets = By.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='jackets']/a");
	public By jacketsCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='jackets']/a//descendant::span[contains(@class,'countColor')]");
	public By scarfHatGloveSets = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/scarf_hat_glove_sets')]");
	public By scarfHatGloveSetsCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/scarf_hat_glove_sets')]//descendant::span[contains(@class,'countColor')]");
	public By bathrobes = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/bathrobes')]");
	public By bathrobesCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/bathrobes')]//descendant::span[contains(@class,'countColor')]");
	public By otherFiber = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_fiber')]");
	public By otherFiberCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_fiber')]//descendant::span[contains(@class,'countColor')]");
	public By beddingSet = By
			.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='bedding_set']/a");
	public By beddingSetCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='bedding_set']/a//descendant::span[contains(@class,'countColor')]");
	public By handicrafts = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='arts_crafts_stocks']/a");
	public By handicraftsCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='arts_crafts_stocks']//descendant::span[contains(@class,'countColor')]");
	public By jweleryEyeWearWatches = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='jewelry_eyewear_watches']/a");
	public By jweleryEyeWearWatchesCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='jewelry_eyewear_watches']//descendant::span[contains(@class,'countColor')]");
	public By yarnsAndFibers = By
			.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='fibers']/a");
	public By yarnAndFibersCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='fibers']//descendant::span[contains(@class,'countColor')]");
	public By fabric = By
			.xpath("//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='textile_stocks']/a");
	public By fabricCount = By.xpath(
			"//ul[@data-category='apparel_textiles_shoes_bags_jewelry_accessories']/li[@id='textile_stocks']//descendant::span[contains(@class,'countColor')]");

	// =============== Metallurgy, Chemicals, Energy
	public By fertilizers = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='fertilizers']/a");
	public By fertilizersCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='fertilizers']/a//descendant::span[contains(@class,'countColor')]");
	public By bitumen = By.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='bitumen']/a");
	public By bitumenCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='bitumen']/a//descendant::span[contains(@class,'countColor')]");
	public By chemicalAuxiliaryAgent = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='chemical_auxiliary_agent']/a");
	public By chemicalAuxiliaryAgentCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='chemical_auxiliary_agent']/a//descendant::span[contains(@class,'countColor')]");
	public By dyestuffs = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='dyestuffs']/a");
	public By dyestuffsCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='dyestuffs']/a//descendant::span[contains(@class,'countColor')]");
	public By lubricant = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='lubricant']/a");
	public By lubricantCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='lubricant']/a//descendant::span[contains(@class,'countColor')]");
	public By organicChemical = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='basic_organic_chemicals']/a");
	public By organicChemicalCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='basic_organic_chemicals']/a//descendant::span[contains(@class,'countColor')]");
	public By catalyst = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='catalyst']/a");
	public By catalystCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='catalyst']/a//descendant::span[contains(@class,'countColor')]");
	public By biogas = By.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/biogas')]");
	public By biogasCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/biogas')]//descendant::span[contains(@class,'countColor')]");
	public By paraffin = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='paraffin']/a");
	public By paraffinCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='paraffin']/a::span[contains(@class,'countColor')]");
	public By inorganicChemicals = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='inorganic_chemicals']/a");
	public By inorganicChemicalsCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='inorganic_chemicals']/a::span[contains(@class,'countColor')]");
	public By soapsDetergents = By
			.xpath("//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='soaps_detergents']/a");
	public By soapsDetergentsCount = By.xpath(
			"//ul[@data-category='metallurgy_chemicals_energy_rubber_plastics']/li[@id='soaps_detergents']/a::span[contains(@class,'countColor')]");
	public By shampoo = By.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/shampoo')]");
	public By shampooCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/shampoo')]//descendant::span[contains(@class,'countColor')]");
	// ============== Knowledge Based(Iran HighTech)
	public By pharmaceutical = By.xpath("//ul[@data-category='high-tech']/li[@id='pharmaceutical']/a");
	public By pharmaceuticalCount = By.xpath(
			"//ul[@data-category='high-tech']/li[@id='pharmaceutical']/a//descendant::span[contains(@class,'countColor')]");
	public By halide = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/halide_(_except_chloride_)?qs=high-tech')]");
	public By halideCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/halide_(_except_chloride_)?qs=high-tech')]//descendant::span[contains(@class,'countColor')]");
	public By biologicalFertilizer = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/subSubSubId/fertilizers?qs=high-tech')]");
	public By biologicalFertilizerCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/subSubSubId/fertilizers?qs=high-tech')]//descendant::span[contains(@class,'countColor')]");
	public By fertilizer = By.xpath(
			"//ul[@data-category='high-tech']/li[@id='fertilizers_soil_additives']/a");
	public By fertilizerCount = By.xpath(
			"//ul[@data-category='high-tech']/li[@id='fertilizers_soil_additives']/a//descendant::span[contains(@class,'countColor')]");
	public By electronicProductsMachinery = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/electronic_products_machinery?qs=high-tech')]");
	public By electronicProductsMachineryCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/electronic_products_machinery?qs=high-tech')]//descendant::span[contains(@class,'countColor')]");
	public By physicalMeasuringInstruments = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_physical_measuring_instruments?qs=high-tech')]");
	public By physicalMeasuringInstrumentsCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'products/cid/other_physical_measuring_instruments?qs=high-tech')]//descendant::span[contains(@class,'countColor')]");
	public By analyzingInstruments = By.xpath(
			"//ul[@data-category='high-tech']/li[@id='other_measuring_analyzing_instruments']/a");
	public By analyzingInstrumentsCount = By.xpath(
			"//ul[@data-category='high-tech']/li[@id='other_measuring_analyzing_instruments']/a//descendant::span[contains(@class,'countColor')]");
	public By otherLabSupplies = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_lab_supplies?qs=high-tech')]");
	public By otherLabSuppliesCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/other_lab_supplies?qs=high-tech')]//descendant::span[contains(@class,'countColor')]");
	public By solarWaterHeaters = By
			.xpath("//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/solar_water_heaters')]");
	public By solarWaterHeatersCount = By.xpath(
			"//ul[contains(@class,'list-styled')]/li/a[contains(@href,'/products/cid/solar_water_heaters')]//descendant::span[contains(@class,'countColor')]");
	public By medicalDevices = By.xpath("//ul[@data-category='high-tech']/li[@id='medical_devices']/a");
	public By medicalDevicesCount = By.xpath("//ul[@data-category='high-tech']/li[@id='medical_devices']/a//descendant::span[contains(@class,'countColor')]");
	public By chemicalsWasteManagement = By.xpath("//ul[@data-category='high-tech']/li[@id='chemicals_waste_management_dyes_solvents']/a");
	public By chemicalsWasteManagementCount = By.xpath("//ul[@data-category='high-tech']/li[@id='chemicals_waste_management_dyes_solvents']/a//descendant::span[contains(@class,'countColor')]");
	public By labInstruments = By.xpath("//ul[@data-category='high-tech']/li[@id='lab_instruments_supplies']/a");
	public By labInstrumentsCount = By.xpath("//ul[@data-category='high-tech']/li[@id='lab_instruments_supplies']/a//descendant::span[contains(@class,'countColor')]");
	
	//=================================
	public By classLinkCollections = By.xpath("//ul[contains(@class,'item-selection')]/li/a[@class='zoColorPikerHover']/span[1]");
	public By classCountList=By.xpath("//ul[contains(@class,'item-selection')]/li/a[@class='zoColorPikerHover']/span[2]");
	public By categoryAndSubCategoryList =By.xpath("//div[contains(@class,'categoryInsideBox')]/h3");
	public By searchAllProductSellerCountList =By.xpath("//div[contains(@class,'subCategoryWidth ')]//descendant::div[contains(@class,searchProduct )]/a[@class='zoColorPikerHover']");
	
	// ==================================================================
	public By btnSeeAllCategory = By
			.xpath("//div[contains(@class,'homePage')]//descendant::div[contains(@class,'btnForSeeAll')]/a[contains(@href,'products')]");
	// Cost Saving
	public By imgCostSaving = By.id("cost-saving-img");
	public By lnkGainAccess = By.xpath("//td[@class='td-1']//descendant::div[@class='panelBgColor']/h4");
	public By lnkLowerInverntoryCost = By.xpath("//td[@class='td-2']//descendant::div[@class='panelBgColor']/h4");
	public By lnkReducedProcurmentCost = By.xpath("//td[@class='td-3']//descendant::div[@class='panelBgColor']/h4");
	public By lnkLowerTransactionCost = By.xpath("//td[@class='td-4']//descendant::div[@class='panelBgColor']/h4");
	public By btnOrderwithLowerTransactionCost = By
			.xpath("//div[contains(@class,'homePage')]//descendant::div[contains(@class,'btnForSeeAll')]/a[contains(@href,'sellers')]");
	// Our Integrated Complementary Services
	public By lnkCompanyVerification = By
			.xpath("//div[contains(@class,'bgWhite')]/ul//descendant::a[contains(@href,'identity-verified')]/h3");
	public By lnkSecurePayment = By
			.xpath("//div[contains(@class,'bgWhite')]/ul//descendant::a[contains(@href,'zoodpay')]/h3");
	public By lnkInspectionServices = By.xpath("//div[contains(@class,'homePage')]//descendant::ul/li[3]/div[@class='stepBlock']/a/h3");
	public By lnkLogisticsServices = By.xpath("//div[contains(@class,'homePage')]//descendant::a[contains(@href,'logistics')]/h3");
	public By btnSignUpAndStartTradingAtZoodel = By.id("signupStartTradingZoodel");
	public By btnCantFindWhatYouAreLookingFor = By
			.xpath("//div[contains(@class,'homePage')]//descendant::div[contains(@class,'btnForSeeAll')]/a[contains(@href,'contactus')]");
	// How It Works
	public By lnkSearch = By.xpath("//ul[@id='footerStep']/li[1]/a");
	public By lnkContactDirectly = By.xpath("//ul[@id='footerStep']/li[2]/a");
	public By lnkOrderPay = By.xpath("//ul[@id='footerStep']/li[3]/a");
	public By lnkInspectShip = By.xpath("//ul[@id='footerStep']/li[4]/a");
	public By lnkDone = By.xpath("//ul[@id='footerStep']/li[5]/a");
	public By imgSearch = By.xpath("//div[@id='search']//descendant::img[contains(@src,'step1.png')]");
	public By imgContactDirectly = By
			.xpath("//div[@id='contactDirectly']//descendant::img[contains(@src,'step2.png')]");
	public By imgOrderPay = By.xpath("//div[@id='orderPay']//descendant::img[contains(@src,'step3.png')]");
	public By imgInspectShip = By.xpath("//div[@id='inspectShip']//descendant::img[contains(@src,'step4.png')]");
	public By imgDone = By.xpath("//div[@id='done']//descendant::img[contains(@src,'step5.png')]");
	public By lblSearch = By.xpath("//div[@id='search']//descendant::div[contains(@class,'textBoxTabList')]/h5");
	public By lblContactDirectly = By
			.xpath("//div[@id='contactDirectly']//descendant::div[contains(@class,'textBoxTabList')]/h5");
	public By lblOrderPay = By.xpath("//div[@id='orderPay']//descendant::div[contains(@class,'textBoxTabList')]/h5");
	public By lblInspectShip = By
			.xpath("//div[@id='inspectShip']//descendant::div[contains(@class,'textBoxTabList')]/h5");
	public By lblDone = By.xpath("//div[@id='done']//descendant::div[contains(@class,'textBoxTabList')]/div/img");
	// Page title
	public By lblProductCategory = By.xpath("//div[@id='listedCategory']/div[1]/div/h2");
	public By lblJoinFree = By.id("myModalLabel");
	// Sticky Header

	// Sticky Header
	public By ddlForBuyerSticky = By.xpath(
			"//div[@id='bs-example-navbar-collapse-2']//descendant::ul[contains(@class,'linkOnScrollRight')]/li[1]/div/span");
	public By menuPostByRequirForBuyer = By
			.xpath("//ul[contains(@class,'linkOnScrollRight')]/li[1]//descendant::ul[@class='dropdown-menu']/li[1]/a");
	public By menusearchProdSellerForBuyer = By
			.xpath("//ul[contains(@class,'linkOnScrollRight')]/li[1]//descendant::ul[@class='dropdown-menu']/li[2]/a");
	public By ddlForSellerSticky = By.xpath(
			"//div[@id='bs-example-navbar-collapse-2']//descendant::ul[contains(@class,'linkOnScrollRight')]/li[2]/div/span");
	public By menuCreateYourWebstoreSeller = By
			.xpath("//ul[contains(@class,'linkOnScrollRight')]/li[2]//descendant::ul[@class='dropdown-menu']/li[1]/a");
	public By menuPostYourProductFreeForSeller = By
			.xpath("//ul[contains(@class,'linkOnScrollRight')]/li[2]//descendant::ul[@class='dropdown-menu']/li[2]/a");
	/*
	 * public By menuPostByRequirForSeller=By.xpath(""); public By
	 * menusearchProdSellerForSeller=By.xpath(""); public By
	 * hrLnkPostByRequirements = By.xpath(""); public By hrLnkCallUs =
	 * By.xpath(""); public By hrLnkRequestQuote =
	 * By.xpath("//ul[contains(@class,'row')]/li[3]/a");
	 */

	// public By hrLnkPostByRequirements = By.xpath("");
	public By lnkCallUsSticky = By
			.xpath("//div[@id='bs-example-navbar-collapse-2']/ul[1]//descendant::a[contains(@href,'contactus')]");
	public By lnkMyAccountSticky = By
			.xpath("//div[@id='bs-example-navbar-collapse-2']/ul[1]//descendant::ul[@class='dropdown-menu']/li[1]/a");
	public By lnkRegisterStickyHr = By.id("callJoinFreeTemplate");
	public By lnkloginStickyHr = By.xpath("//ul[contains(@class,'commanHeader')]//descendant::a[@id='myLogin']");
	public By lnkLogoutStickyHr = By.id("logout");
	public By btnRequestQuote = By.xpath("//ul[contains(@class,'row')]/li[3]/div/a");
	// Search
	public By btnSearch = By.id("btnSearch");
	public By txtSearch = By.id("txtSearch");
	public By ddlProductHome = By
			.xpath("//div[contains(@class,'secrhBlock')]/ul//descendant::select[@id='ddlProduct']");

	// Language Flag
	public By ddlLaguage = By.xpath("//form/div[contains(@class,'zoCountryLanguageDropdownBox')]/a");
			//By.xpath("//ul[contains(@class,'linkOnScrollRight')]/li[3]//descendant::div[contains(@class,'languageSelectBlock')]/span[1]");
			//By.xpath("//div[@class='langHeader']//descendant::a");
	
	/*public By ddlEN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[1]/span");
	public By ddlFA = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[2]/span");
	public By ddlTR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[3]/span");
	public By ddlAR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[4]/span");
	public By ddlRU = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[5]/span");
	public By ddlCN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::ul[@id='ddlTransLang']/li[6]/span");*/
	
	public By ddlEN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[1]/label");
	public By ddlFA = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[2]/label");
	public By ddlTR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[3]/label");
	public By ddlAR = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[4]/label");
	public By ddlRU = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[5]/label");
	public By ddlCN = By.xpath("//ul[contains(@class,'latoRegular')]//descendant::div[contains(@class,'zoLanguageRadioBox ')]/div[6]/label");
}
