package com.prakritidev.verma.services.flyweightpattern.factory;

import java.util.HashMap;

import com.prakritidev.verma.services.flyweightpattern.PenInterface;
import com.prakritidev.verma.services.flyweightpattern.implementation.MediumPen;
import com.prakritidev.verma.services.flyweightpattern.implementation.ThicPen;
import com.prakritidev.verma.services.flyweightpattern.implementation.ThinPen;

public class PenFactory {
    private static final HashMap<String, PenInterface> pensMap = new HashMap<>();

    public static PenInterface getThickPen(String color) {
        String key = color + "-THICK";

        PenInterface pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new ThicPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }

        return pen;
    }

    public static PenInterface getThinPen(String color) {
        String key = color + "-THIN";

        PenInterface pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new ThinPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }

        return pen;
    }

    public static PenInterface getMediumPen(String color) {
        String key = color + "-MEDIUM";

        PenInterface pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new MediumPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }

        return pen;
    }

}
