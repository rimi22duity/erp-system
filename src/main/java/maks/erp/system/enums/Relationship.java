package maks.erp.system.enums;

import java.util.ArrayList;
import java.util.List;

public enum Relationship {
    PARENTS("Parents"), SPOUSE("Spouse"), CHILDREN("Children"), OTHER("Other");

    private String relation;

    Relationship(String relation) {
        this.relation = relation;
    }

    public static List<String> getRelationshipList() {
        List<String> relationshipList = new ArrayList<>();
        for (Relationship r: Relationship.values()) {
            relationshipList.add(r.relation);
        }

        return relationshipList;
    }
}
