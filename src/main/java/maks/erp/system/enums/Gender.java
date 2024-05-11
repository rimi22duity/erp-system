package maks.erp.system.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duity
 * @since 5/4/24
 */
public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    Other("Other");

    private String fullString;

    Gender(String fullString) {
        this.fullString = fullString;
    }

    public static List<String> getGenderList() {
        List<String> genderList = new ArrayList<>();
        for (Gender g: Gender.values()) {
            genderList.add(g.fullString);
        }

        return genderList;
    }

    public static Gender getGender( String genderString) {
        switch (genderString) {
            case "Male": return Gender.MALE;
            case "Female": return Gender.FEMALE;
            default: return Gender.Other;
        }
    }

}
