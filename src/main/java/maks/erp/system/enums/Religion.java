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

    public static List<String> getReligionList() {
        List<String> list = new ArrayList<>();

        for(Religion religion: Religion.values()) {
            list.add(religion.fullString);
        }

        return list;
    }
}
