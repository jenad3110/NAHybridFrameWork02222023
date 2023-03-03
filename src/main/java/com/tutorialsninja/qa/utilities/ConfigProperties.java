package com.tutorialsninja.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {


    static String path = System.getProperty("user.dir");

    public static  Properties loadProperties() {

        Properties config = new Properties();

        try {
            FileInputStream fis = new FileInputStream(path+"/src/main/java/com/tutorialsninja/qa/properties/Config.Properties");
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return config;
    }

    public static  Properties loadDataTestProperties() {

        Properties config = new Properties();

        try {
            FileInputStream fis = new FileInputStream(path+"/src/main/java/com/tutorialsninja/qa/properties/DataTest.Properties");
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return config;
    }


}
