package com.prakritidev.verma.services.flyweightpattern.implementation;

import com.prakritidev.verma.services.flyweightpattern.BrushSizeEnum;
import com.prakritidev.verma.services.flyweightpattern.PenInterface;

public class ThinPen implements PenInterface{

    final BrushSizeEnum brushSize = BrushSizeEnum.THIN;
    private String color = null; 
     
    public void setColor(String color) {
      this.color = color;
    }
   
    @Override
    public void draw(String content) {
      System.out.println("Drawing THIN content in color : " + content);
    }
}
