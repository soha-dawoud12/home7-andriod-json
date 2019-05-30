package com.home7.JsonWeather;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData  extends AsyncTask<Void,Void,Void> {
    String data="";
    //String dataparsed="";
  //  String singleparsed="";


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url =new URL("https://api.myjson.com/bins/lk29v");
            HttpURLConnection  httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));      //read the data from the input stream
            String line="";
            while(line !=null){
                line=bufferedReader.readLine();
                data =data + line;
            }
           // JSONArray JA = new JSONArray(data);
          //  for ( int i = 0 ; i<JA.length() ; i++){
             //   JSONObject JO = (JSONObject) JA.get(i);
               // singleparsed = "id:" +JO.get("id") +"\n"+
                      //  "main:" +JO.get("main") +"\n"+
                      //  "description:" +JO.get("description") +"\n"+
                      //  "icon:" +JO.get("icon") +"\n";
               // dataparsed =dataparsed +singleparsed;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (JSONException e) {
           // e.printStackTrace();
       // }
        return  null;

    }
    @Override  //show to the user
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText( this.data);
       // this.dataparsed
    }

}
