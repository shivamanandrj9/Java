package org.example.module;

import com.google.inject.AbstractModule;
import org.example.services.DrawShape;
import org.example.services.DrawSquare;

public class ShapeModule extends AbstractModule {

    @Override
    protected void configure (){
        bind(DrawShape.class).to(DrawSquare.class);
    }
}
