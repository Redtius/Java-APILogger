package org.example;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import java.io.IOException;


public class HttpRequest {
//    enum Method{
//        GET,
//        POST,
//        PUT,
//        PATCH,
//        DELETE
//    }
    public static void fetch (String MyRoute){

        HttpUriRequest request = new HttpGet(MyRoute);


        HttpResponse response = null;


        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            response = httpclient.execute(request);
        } catch (IOException e) {
            System.out.println("An error occurred while executing the HTTP request:");
            e.printStackTrace();
        }
        assert response != null;
        APILogger.Log(request,response,"C:\\Users\\DELL\\Desktop\\Software Engineer\\Back-End\\Server\\Java\\Spring\\Projects\\APILogger\\AppApi.log");
    }
}
