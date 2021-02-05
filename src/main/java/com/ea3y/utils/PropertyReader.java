package com.ea3y.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public Properties properties;

    public PropertyReader(String file) {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

        properties = new Properties();
        try {
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }
}
