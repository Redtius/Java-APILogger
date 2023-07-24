package org.example;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
    public static void fetch(String myRoute, HashMap<String, String> headersMap, String requestBody) {

        HttpUriRequest request = new HttpPost(myRoute);

        HttpResponse response = null;

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            // Add headers to the HttpPost request
            for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }

            // Set the request body (JSON data)
            StringEntity entity = new StringEntity(requestBody, ContentType.parse("UTF-8"));
            ((HttpPost) request).setEntity(entity);

            // Execution of the POST request
            response = httpclient.execute(request);
        } catch (IOException e) {
            System.out.println("An error occurred while executing the HTTP request:");
            e.printStackTrace();
        }

        assert response != null;
        APILogger.Log(request, response, "C:\\Users\\DELL\\Desktop\\Software Engineer\\Back-End\\Server\\Java\\Spring\\Projects\\APILogger\\AppApi.log");
    }
}
