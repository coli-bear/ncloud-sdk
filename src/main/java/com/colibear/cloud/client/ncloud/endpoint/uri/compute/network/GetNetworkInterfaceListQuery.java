package com.colibear.cloud.client.ncloud.endpoint.uri.compute.network;

import com.colibear.cloud.client.ncloud.endpoint.uri.CommonQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public final class GetNetworkInterfaceListQuery extends CommonQuery {
    private String regionCode;
    private String subnetName;
    private String networkInterfaceName;
    private String networkInterfaceStatusCode;
    private String ip;
    private String instanceNo;
    private Boolean isDefault;
    private String deviceName;
    private String serverName;
    private Integer pageNo;
    private Integer pageSize;
    private List<String> networkInterfaceNoList;
    private List<String> secondaryIpList;
}
