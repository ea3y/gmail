package com.ea3y.user;

import com.ea3y.utils.PropertyReader;

public class UserFactory {

    public static User getUser(UserName userName) {
        PropertyReader property = new PropertyReader("user.properties");
        return switch (userName) {
            case JAVISTA -> new User(
                    property.getValue("javista.email"), property.getValue("javista.password"));
            case AUTOMATION -> new User(
                    property.getValue("automation.email"), property.getValue("automation.password"));
        };
    }
}
