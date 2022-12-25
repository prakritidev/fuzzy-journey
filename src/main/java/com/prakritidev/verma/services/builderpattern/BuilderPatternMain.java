package com.prakritidev.verma.services.builderpattern;

public class BuilderPatternMain {
    public static void main(String[] args) {
        User user = new User
                .UserBuilder("akash")
                .age(10)
                .build();
        System.out.println(user.toString());
    }
}
