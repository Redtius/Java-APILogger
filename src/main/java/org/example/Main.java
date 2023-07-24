package org.example;

public class Main {
    public static void main(String[] args) {
        //Enter the Api Full Url Here
        HttpRequest.fetch("https://api.publicapis.org/entries");
        //String requestBody = "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\"}"; // this is How the requestbody should be
        //HttpRequest.fetch(); // Post Request

    }
}