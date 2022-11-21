package com.colibear.cloud.client.ncloud.compute.network.dto;

import com.colibear.cloud.client.ncloud.CommonCode;
import lombok.Data;

import java.util.List;

@Data
public final class NetworkInterface {
    private String networkInterfaceNo;
    private String networkInterfaceName;
    private String subnetNo;
    private Boolean deleteOnTermination;
    private Boolean isDefault;
    private String deviceName;
    private CommonCode networkInterfaceStatus;
    private CommonCode instanceType;
    private String instanceNo;
    private String ip;
    private String macAddress;
    private String networkInterfaceDescription;
    private List<String> secondaryIpList;
}
