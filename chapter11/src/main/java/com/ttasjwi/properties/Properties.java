package com.ttasjwi.properties;

import java.util.Hashtable;

public class Properties {

    private final Hashtable<String, String> properties = new Hashtable<>();

    public String setProperty(String key, String value) {
        return properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
