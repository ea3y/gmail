package com.google.user;

public class UserFactory {

    public static User getUser(UserName userName) {
        return switch (userName) {
            case JAVISTA -> new User("vistaja20@gmail.com", "gfhjkzytn123");
            case AUTOMATION -> new User("automation192020@gmail.com", "gfhjkzytn123");
        };
    }
}
