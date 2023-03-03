package com.tutorialsninja.qa.properties;

import com.tutorialsninja.qa.base.CommonAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test extends CommonAPI {

    String test1= dataProp.getProperty("FirstNameForEmail");
    String test2 =dataProp.getProperty("LastNameForEmail");

    public  String generateEmailsWithCurrentTime(){

        DateFormat df = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        df.format(date);

        String email = (test1+"."+test2+df.format(date)+"@gmail.com");

        return email;
    }


}
