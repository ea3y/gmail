package com.ea3y.user;

import com.ea3y.utils.PropertyReader;

public class UserFactory {

    public static User getUser(UserName userName) {

        PropertyReader property = new PropertyReader("user.properties");

        return switch (userName) {
            case JAVISTA -> new User(
                    property.getValue("JAVISTA_EMAIL"), property.getValue("JAVISTA_PASSWORD"));
            case AUTOMATION -> new User(
                    property.getValue("AUTOMATION_EMAIL"), property.getValue("AUTOMATION_PASSWORD"));
        };
    }
}
