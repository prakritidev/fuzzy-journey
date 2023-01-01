package com.prakritidev.verma.services.flyweightpattern.implementation;

import com.prakritidev.verma.services.flyweightpattern.BrushSizeEnum;
import com.prakritidev.verma.services.flyweightpattern.PenInterface;

public class ThicPen implements PenInterface {

    final BrushSizeEnum brushSize = BrushSizeEnum.THICK;
    private String color = null;

    @Override
    public void setColor(String color) {
        // TODO Auto-generated method stub
        this.color = color;
    }

    @Override
    public void draw(String content) {
        // TODO Auto-generated method stub
        System.out.println("Drawing THICK content in color : " + content);
        
    }

}
