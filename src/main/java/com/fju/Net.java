package com.fju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Net {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://ods.railway.gov.tw/tra-ods-web/ods/download/dataResource/a5839b4e6bef4964946d56535bfaabc9");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();;
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = in.readLine();
            while(line != null) {
//                System.out.println(line);
                sb.append(line);
                line = in.readLine();
            }
            System.out.println(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
