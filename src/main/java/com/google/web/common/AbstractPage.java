package com.google.web.common;

import com.google.core.Url;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractPage {

    public static AbstractPage openPageAt(Class<? extends AbstractPage> clazz) {

        String url = null;
        if (clazz.isAnnotationPresent(Url.class)) {
            url = clazz.getAnnotation(Url.class).value();
        }
        if (url != null) {
            return open(url, clazz);
        }
        else {
            return page(clazz);
        }
    }
}
