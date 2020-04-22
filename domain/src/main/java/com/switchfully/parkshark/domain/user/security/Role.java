package com.switchfully.parkshark.domain.user.security;

public enum Role {
    CONTACTPERSON(Values.CONTACTPERSON),
    MEMBER(Values.MEMBER),
    MANAGER(Values.MANAGER);

    private String role;

    Role(String role) {
        this.role = role;
    }

    public static class Values {
        public static final String CONTACTPERSON = "contactperson";
        public static final String MEMBER = "member";
        public static final String MANAGER = "manager";
    }

    public String getRole() {
        return role;
    }
}
