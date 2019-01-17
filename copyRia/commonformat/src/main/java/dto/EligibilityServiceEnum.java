package com.luxottica.ria.commonformat.enumeration;

/**
 * Created by Sal Roueimiab
 */
public enum EligibilityServiceEnum {

    EXAM ("1", "E", "Exam"),
    CONTACT_LENSES("2", "C", "Contacts"),
    CONTACT_LENSES_FIT_FOLLOW("3", "U", "Fit and Follow-up"),
    LENSES ("4", "L", "Lenses"),
    FRAMES("5", "F", "Frames");

    EligibilityServiceEnum(String id, String symbol, String description) {
        this.id = id;
        this.symbol = symbol;
        this.description = description;
    }

    private String id;
    private String symbol;
    private String description;

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public static EligibilityServiceEnum fromId(String id) {
        for (EligibilityServiceEnum e: values()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }

        return null;
    }
}

