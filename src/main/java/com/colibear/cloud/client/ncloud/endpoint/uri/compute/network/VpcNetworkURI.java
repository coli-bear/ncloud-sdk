package com.colibear.cloud.client.ncloud.endpoint.uri.compute.network;

import com.colibear.cloud.client.ncloud.endpoint.uri.NCloudURI;

public enum VpcNetworkURI implements NCloudURI {
      VPC_GET_SERVER_NETWORK_LIST("/vserver/v2/getNetworkInterfaceList")
    , VPC_GET_SERVER_NETWORK_DETAIL("/vserver/v2/getNetworkInterfaceDetail")
    ;

    private String uri;

    VpcNetworkURI(String uri) {
        this.uri = uri;
    }

    @Override
    public String getUri() {
        return this.uri;
    }
}
