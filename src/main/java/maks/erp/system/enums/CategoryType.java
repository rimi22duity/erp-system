package maks.erp.system.enums;

import lombok.Getter;

@Getter
public enum CategoryType {
    SCIENTIFIC_INSTRUMENTS("Scientific Instruments"),
    LABORATORY_CHEMICALS("Laboratory Chemicals"),
	PRODUCT_RND_MACHINE("Production R&D Machine"),
	LABORATORY_EQUIPMENT("Laboratory Equipment"),
 	MEDICAL_EQUIPMENT("Medical Equipment"),
	GAS_EQUIPMENT("Gas Equipment"),
	REAGENTS("Reagents"),
	GLASSWARE("Glassware"),
	ETP_PLANT_LAB_EQUIPMENT("ETP Plant Lab Equipment");

	String category;

	CategoryType(String category) { this.category = category; }
    }
