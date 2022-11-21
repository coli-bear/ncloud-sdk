package com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance;

import com.colibear.cloud.client.ncloud.endpoint.uri.NCloudURI;

public enum VpcServerURI implements NCloudURI {
      VPC_GET_SERVER_INSTANCE_LIST("/vserver/v2/getServerInstanceList")
    , VPC_GET_SERVER_INSTANCE_DETAIL("/vserver/v2/getServerInstanceDetail")
    , VPC_GET_SERVER_PRODUCT_LIST("/vserver/v2/getServerProductList")
    , VPC_GET_SERVER_IMAGE_PRODUCT_LIST("/vserver/v2/getServerImageProductList")
    , VPC_GET_ROOT_PASSWORD("/vserver/v2/getRootPassword")
    ;

    private String uri;

    VpcServerURI(String uri) {
        this.uri = uri;
    }

    @Override
    public String getUri() {
        return this.uri;
    }

}
