package com.example.apirequest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    public static String makeHTTPRequest(URL url) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = connection.getInputStream();

        try {
            Scanner sc = new Scanner(inputStream);
            sc.useDelimiter("\\A");

            boolean hasInput = sc.hasNext();
            if(hasInput)
                return  sc.next();
            else return null;
        }finally {
            connection.disconnect();
        }


    };

}
