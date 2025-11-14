package com.taprify.musicservice.interfaces.rest.dto.login;

import feign.form.FormProperty;

public class LoginRequest {

    @FormProperty("grant_type")
    private String grantType;
    @FormProperty("client_id")
    private String ClientId;
    @FormProperty("client_secret")
    private String clientSecret;


    public LoginRequest() {
    }

    public LoginRequest(String grantType, String clientId, String clientSecret) {
        this.grantType = grantType;
        this.ClientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        this.ClientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
