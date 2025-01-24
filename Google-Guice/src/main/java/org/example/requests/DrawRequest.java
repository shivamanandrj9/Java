package org.example.requests;

import org.example.services.DrawShape;

import javax.inject.Inject;

public class DrawRequest {

    public DrawShape drawShape;

    @Inject
    public DrawRequest(DrawShape drawShape){
        this.drawShape=drawShape;
    }

    public void makeRequest(){
        drawShape.draw();
    }


}
