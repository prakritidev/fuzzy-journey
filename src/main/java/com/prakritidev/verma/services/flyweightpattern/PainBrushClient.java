package com.prakritidev.verma.services.flyweightpattern;

import com.prakritidev.verma.services.flyweightpattern.factory.PenFactory;

public class PainBrushClient {
    public static void main(String[] args) {
        PenInterface yellowThinPen1 = PenFactory.getThickPen("YELLOW"); // created new pen
        yellowThinPen1.draw("Hello World !!");

        PenInterface yellowThinPen2 = PenFactory.getThickPen("YELLOW"); // pen is shared
        yellowThinPen2.draw("Hello World !!");

        PenInterface blueThinPen = PenFactory.getThickPen("BLUE"); // created new pen
        blueThinPen.draw("Hello World !!");

        System.out.println(yellowThinPen1.hashCode());
        System.out.println(yellowThinPen2.hashCode());

        System.out.println(blueThinPen.hashCode());
    }
}
