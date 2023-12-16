package com.belhard.bookstore.util.impl;

import com.belhard.bookstore.util.PropertiesManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManagerImpl implements PropertiesManager {
    private final Properties properties;

    public PropertiesManagerImpl(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getKey(String key) {
        return properties.getProperty(key);
    }
}
