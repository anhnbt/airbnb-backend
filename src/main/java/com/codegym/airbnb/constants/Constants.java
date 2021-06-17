package com.codegym.airbnb.constants;

public class Constants {
    public final static String JWT_SECRET_KEY = "ANHNBT";
    public final static long JWT_EXPIRATION = 1000 * 60 * 60 * 10; // 10h

    public static class Roles {
        public final static String ROLE_ADMIN = "ROLE_ADMIN";
        public final static String ROLE_USER = "ROLE_USER";
    }
}
