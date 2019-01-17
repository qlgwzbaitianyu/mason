package com.luxottica.ria.commonformat.utility;

import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringValidationUtils {

    public static boolean containsLower(String text) {
        String regex = "(?=.*[a-z])";
        return validate(regex, text);
    }

    public static boolean containsUpper(String text) {
        String regex = "(?=.*[A-Z])";
        return validate(regex, text);
    }

    public static boolean isAlpha(String text) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])";
        return validate(regex, text);
    }

    public static boolean containsDigits(String text) {
        String regex = "(?=.*\\d)";
        return validate(regex, text);
    }

    public static boolean isAlphaNumeric(String text) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)";
        return validate(regex, text);
    }

    public static boolean containsCharacters(String text, String characterSet) {
        String regex = "(?=.*[" + characterSet + "])";
        return validate(regex, text);
    }

    public static String buildMatcherRegex(boolean allowLower, boolean allowUpper, boolean allowDigits, String additionalCharacters) {
        String regex = "";
        if (allowLower) {
            regex = regex.concat("(?=.*[a-z])");
        }
        if (allowUpper) {
            regex = regex.concat("(?=.*[A-Z])");
        }
        if (allowDigits) {
            regex = regex.concat("(?=.*\\d)");
        }
        if (StringUtils.isNotBlank(additionalCharacters)) {
            regex = regex.concat("(?=.*["+additionalCharacters+"])");
        }

        return regex;
    }

    public static boolean validate(String regex, String text) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        return m.find();
    }
}

