package com.blckclov3r.cebu_mproject.mPlaces;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Abrenica, Aljun on 7/26/2018.
 */

public class DownloadUrl {
    public String readUrl(String myUrl) throws IOException{
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while((line  = br.readLine()) != null){
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                inputStream.close();
                urlConnection.disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }
}