package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.module.ShapeModule;
import org.example.requests.DrawRequest;

public class Main {

    private static final String SQUARE_REQ="SQUARE";

    public static void sendRequest(String requestType)
    {
        if(requestType.equals(SQUARE_REQ))
        {
            Injector injector= Guice.createInjector(new ShapeModule());
            DrawRequest drawRequest=injector.getInstance(DrawRequest.class);
            drawRequest.makeRequest();

        }
    }

    public static void main(String[] args) {

        sendRequest("SQUARE");
    }
}