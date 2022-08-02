package com.tutorial.weatherapp.util;

import android.util.Patterns;

public class Validations {
    public static boolean isFieldEmpty(String text) {
        if (text.trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(String text){
        return Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }
    public static boolean isValidPhone(String text){
        return Patterns.PHONE.matcher(text).matches();
    }
    public static boolean isEqualStr(String field,String field1){
        return field.equalsIgnoreCase(field1);
    }
}
