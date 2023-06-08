package com.javawebhw.travel_agency.enums;

public enum UserRole {

    ADMIN {
        @Override public String toString() {
            return "ADMIN";
        }
    },
    INTERNAL {
        @Override public String toString() {
            return "INTERNAL";
        }
    }, USER {
        @Override public String toString() {
            return "USER";
        }
    };
    
}
