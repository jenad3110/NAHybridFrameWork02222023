package com.tutorialsninja.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {


    static String path = System.getProperty("user.dir");

    public static  Properties loadProperties() {

        Properties config = new Properties();

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\sron4\\Downloads\\HybridFrameWork02222023\\src\\test\\resources\\Properties\\Config.Properties");
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return config;
    }


}
