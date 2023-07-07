package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.core5.http.HttpResponse;

public class APILogger {

    public static void Log(HttpUriRequest request, HttpResponse response,String LogPath) {
        try {
            FileWriter writer = new FileWriter(LogPath, true); // Append to the existing log file

            LocalDateTime reqDate = LocalDateTime.now();
            DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = reqDate.format(dtFormatter);

            String logEntry = String.format("""
                    ====================================================
                    Date: [%s]
                    Request: %s | %s
                    Status: %d
                    Response: %s
                    ====================================================
                    """, formattedDate, request.getMethod(), request.getUri().toString(), response.getCode(),
                    response.getReasonPhrase());

            System.out.println(logEntry);

            writer.write(logEntry);
            writer.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
}
