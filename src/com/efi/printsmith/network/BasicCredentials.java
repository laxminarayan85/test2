package com.efi.printsmith.network;


public class BasicCredentials implements HttpCredentials {
    private static sun.misc.BASE64Encoder ENCODER = new sun.misc.BASE64Encoder();

    public BasicCredentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String headerString() {
        String userPassword = this.user + ":" + this.password;
        return "Basic " + ENCODER.encode(userPassword.getBytes());
    }

    private String user = null;
    private String password = null;
}
