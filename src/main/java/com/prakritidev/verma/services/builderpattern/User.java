package com.prakritidev.verma.services.builderpattern;

public class User {
    private final String firstName;
    private final int age;

    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.age = userBuilder.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User: " + this.firstName + " Age: " + this.age;
    }

    public static class UserBuilder {
        private final String firstName;
        private int age;

        public UserBuilder(String firstName) {
            this.firstName = firstName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }

}
