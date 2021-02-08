package com.ea3y;

import com.ea3y.utils.PropertyReader;

public class Configuration {

    public static String getRecipientEmail() {
        PropertyReader property = new PropertyReader("user.properties");
        return property.getValue("automation.email");
    }
}
