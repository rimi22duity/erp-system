package maks.erp.system.enums;

import java.util.ArrayList;
import java.util.List;

public enum Relationship {
    PARENTS("Parents"),
    SPOUSE("Spouse"),
    CHILDREN("Children"),
    OTHER("Other");

    private String relation;

    public String getRelation() {
        return relation;
    }

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

    public static Relationship getRelationship( String relationShipString) {
        switch (relationShipString) {
            case "Parents": return Relationship.PARENTS;
            case "Spouse": return Relationship.SPOUSE;
            case "Children": return Relationship.CHILDREN;
            default: return Relationship.OTHER;
        }
    }
}
