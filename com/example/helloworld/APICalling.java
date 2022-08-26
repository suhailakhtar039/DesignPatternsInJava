package com.example.helloworld;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class APICalling {
    public static String parseObject(JSONObject json, String key){
        return json.get(key).toString();
    }
    public static String getKey(JSONObject json, String key){
        boolean exists = json.has(key);
        Iterator<?> keys = json.keys();
        String nextKeys;
        if(!exists) {
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) {
                        return getKey(json.getJSONObject(nextKeys),key);
                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonArray = json.getJSONArray(nextKeys);
                        for(int i=0; i<jsonArray.length(); i++){
                            String jsonArrayString = jsonArray.get(i).toString();
                            JSONObject innerJSONObject = new JSONObject(jsonArrayString);
                            return getKey(innerJSONObject,key);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Exception " + e);
                }
            }
        }else{
            return parseObject(json,key);
        }
        return "-1";
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

            JSONArray jsonArray = json.getJSONArray("data");
//            System.out.println(jsonArray);

            String ans = getKey(json,"topLevelDomain");
            List<String> arrayList = List.of(ans);
            System.out.println(ans);
            System.out.println(arrayList);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }
}
