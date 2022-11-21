package com.colibear.cloud.client.ncloud.endpoint;

public enum NCloudZone {
    BILLING("https://billingapi.apigw.ntruss.com"),
    PRIVATE("https://ncloud.apigw.ntruss.com"),
    PUBLIC("https://ncloud.apigw.gov-ntruss.com");

    private String url;

    NCloudZone(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this. url;
    }
}