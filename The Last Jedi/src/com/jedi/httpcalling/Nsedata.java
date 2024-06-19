package com.jedi.httpcalling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import org.json.JSONObject;


public class Nsedata {

    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36";

    private final String Accept =  "*/*";
    private final String Accept_Language = "en-GB,en-US;q=0.9,en;q=0.8";
    private final String X_Requested_With = "XMLHttpRequest";
    private final String Connection = "keep-alive";

    public static void main(String[] args) throws Exception {

        Nsedata http = new Nsedata();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        //String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/" +
                //"ajaxGetQuoteJSON.jsp?symbol=TCS&series=EQ";

        String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol=TCS&series=EQ";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");



        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept", Accept);
        con.setRequestProperty("Accept-Language", Accept_Language);
        con.setRequestProperty("X-Requested-With", X_Requested_With);
        con.setRequestProperty("Connection", Connection);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        //JSONObject parse = (JSONObject) new JSONObject(response.toString()).get("data");
        //System.out.println(parse.get("companyName"));
    }
}