//package com.jedi.httpcalling;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//
//public class Stock {
//
//    //private static final String USER_AGENT = "Mozilla/5.0";
//    //private static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36";
//
//    private static String Accept =  "*/*";
//    private static String Accept_Language = "en-GB,en-US;q=0.9,en;q=0.8";
//    private static String X_Requested_With = "XMLHttpRequest";
//    private static String Connection = "keep-alive";
//
//    private static final String GET_URL = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol=INFY&series=EQ";
//
//
//    public static void main(String[] args) throws IOException {
//        sendGET();
//        System.out.println("GET DONE");
//    }
//
//    private static void sendGET() throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(GET_URL);
//        //httpGet.addHeader("User-Agent", USER_AGENT);
//        //httpGet.addHeader("Accept", Accept);
//        //httpGet.addHeader("Accept-Language", Accept_Language);
//        //httpGet.addHeader("X-Requested-With", X_Requested_With);
//        //httpGet.addHeader("Connection", Connection);
//
//        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//
//        System.out.println("GET Response Status:: "
//                + httpResponse.getStatusLine().getStatusCode());
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                httpResponse.getEntity().getContent()));
//
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = reader.readLine()) != null) {
//            response.append(inputLine);
//        }
//        reader.close();
//
//        // print result
//        System.out.println(response.toString());
//        httpClient.close();
//    }
//}
