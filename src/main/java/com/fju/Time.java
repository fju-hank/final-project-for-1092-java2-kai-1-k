package com.fju;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.TimeZone;

public class Time {
    public boolean time(){
        String webUrl = "http://www.google.com/";
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            Long dateL = conn.getDate();
            Date date = new Date(dateL);
            System.out.print(date.getHours()+"時"+date.getMinutes()+"分"+date.getSeconds()+"秒");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return false;
    }

}
