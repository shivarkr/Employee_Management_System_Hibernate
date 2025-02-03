package com.utils;

import java.util.regex.Pattern;

public class InputValidators {
    public static boolean isValidString(String str){
        if( str==null || str.trim().isEmpty()){
            return false;
        }
        if (!str.matches("[a-zA-Z]+") || str.length() < 2) {
            return false;
        }
        return true;
    }
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        // Regex to match a 10-digit phone number
        String phoneRegex = "\\d{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }
    public static boolean isValidStreetNumber(String streetNumber) {
        if (streetNumber == null) {
            return false;
        }
        // Regex to match letters, numbers, and '/'
        String streetNumberRegex = "^[a-zA-Z0-9/]+$";
        Pattern pattern = Pattern.compile(streetNumberRegex);
        return pattern.matcher(streetNumber).matches();
    }

}
