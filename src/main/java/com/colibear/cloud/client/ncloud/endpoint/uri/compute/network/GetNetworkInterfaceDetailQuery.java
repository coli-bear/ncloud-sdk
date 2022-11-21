package com.colibear.cloud.client.ncloud.endpoint.uri.compute.network;

import com.colibear.cloud.client.ncloud.endpoint.uri.CommonQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public final class GetNetworkInterfaceDetailQuery extends CommonQuery {
    private String regionCode;
    private String networkInterfaceNo;
}
