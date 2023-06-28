package com.eximbay.sample.util;

import java.util.Base64;

public final class UtillClass {

    private UtillClass()
    {

    }

    public static String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        String encodedValue = Base64.getEncoder().encodeToString(valueToEncode.getBytes());
        return "Basic " + encodedValue;
    }

}
