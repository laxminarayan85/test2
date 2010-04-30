package com.efi.printsmith.network;


public interface HttpCredentials {
    /**
     * No credentials - pass this rather than null, for documentation and convenience in avoiding null tests
     */
    public static HttpCredentials NULL_CREDENTIALS = new HttpCredentials() {public String headerString() {return null;}};

    /**
     * @return properly-encoded string for use in HTTP Authorization (and other) headers
     */
    public String headerString();
}
