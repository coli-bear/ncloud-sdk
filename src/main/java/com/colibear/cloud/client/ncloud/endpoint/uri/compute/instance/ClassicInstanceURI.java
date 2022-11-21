package com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance;

import com.colibear.cloud.client.ncloud.endpoint.uri.NCloudURI;

public enum ClassicInstanceURI implements NCloudURI {
    CLASSIC_GET_INSTANCE_LIST("/server/v2/getServerInstanceList"),
    CLASSIC_GET_SERVER_PRODUCT_LIST("/server/v2/getServerProductList"),
    CLASSIC_GET_SERVER_IMAGE_PRODUCT_LIST("/server/v2/getServerImageProductList"),
    CLASSIC_GET_ROOT_PASSWORD("/server/v2/getRootPassword");

    private String uri;

    ClassicInstanceURI(String uri) {
        this.uri = uri;
    }

    @Override
    public String getUri() {
        return this.uri;
    }
}
