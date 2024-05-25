package maks.erp.system.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public enum Religion {
    ISLAM("Islam"),
    HINDUISM("Hinduism"),

    BUDDHISM("Buddhism"),
    CHRISTIANITY("Christianity");
    private String fullString;

    Religion(String fullString) {
        this.fullString = fullString;
    }

    public String getFullString() {
        return fullString;
    }

    public static List<String> getReligionList() {
        List<String> list = new ArrayList<>();

        for(Religion religion: Religion.values()) {
            list.add(religion.fullString);
        }

        return list;
    }

    public static Religion getReligion( String religionString) {
        switch (religionString) {
            case "Islam": return Religion.ISLAM;
            case "Hinduism": return Religion.HINDUISM;
            case "Buddhism": return Religion.BUDDHISM;
            case "Christianity": return Religion.CHRISTIANITY;
            default: return null;
        }
    }
}
