package com.example.helloworld;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class APICalling {
    public static void parseObject(JSONObject json, String key){
        System.out.println(json.get(key));
    }
    public static void getKey(JSONObject json, String key){
        boolean exists = json.has(key);
        Iterator<?> keys = json.keys();
        String nextKeys;
        if(!exists) {
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) {
                        System.out.println("object " + nextKeys);
                        getKey(json.getJSONObject(nextKeys),key);
                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        System.out.println("array " + nextKeys);
                    } else {
                        System.out.println("key-value pair " + nextKeys);
                    }
                } catch (Exception e) {
                    System.out.println("Exception " + e);
                }
            }
            JSONArray jsonArray = json.getJSONArray("data");
            System.out.println(jsonArray);
        }else{
            parseObject(json,key);
        }
    }
    private static HttpURLConnection connection;
    public static void main(String[] args) {
//        Method 1: java.net.HttpUrlConnection
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=india");
            connection = (HttpURLConnection) url.openConnection();
//            Request set up
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            // reading response
            if(responseCode!=connection.getResponseCode()){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            String data = new String(responseContent);
            JSONObject json = new JSONObject(data);

            JSONArray jsonArray = new JSONArray(json.getJSONArray("data").toString());
//            jsonArray = json.getJSONArray("data");
            System.out.println(jsonArray);

            getKey(json,"total_pages");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }
}
