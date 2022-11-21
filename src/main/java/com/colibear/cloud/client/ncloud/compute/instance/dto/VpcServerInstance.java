package com.colibear.cloud.client.ncloud.compute.instance.dto;

import com.colibear.cloud.client.ncloud.CommonCode;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public final class VpcServerInstance {
    private String serverInstanceNo;
    private String serverName;
    private String serverDescription;
    private Integer cpuCount;
    private Long memorySize;
    private CommonCode platformType;
    private String loginKeyName;
    private String publicIpInstanceNo;
    private String publicIp;
    private CommonCode serverInstanceStatus;
    private CommonCode serverInstanceOperation;
    private String serverInstanceStatusName;
    private Date createDate;
    private Date uptime;
    private String serverImageProductCode;
    private String serverProductCode;
    private Boolean isProtectServerTermination;
    private String zoneCode;
    private String regionCode;
    private String vpcNo;
    private String subnetNo;
    private List<String> networkInterfaceNoList;
    private String initScriptNo;
    private CommonCode serverInstanceType;
    private CommonCode baseBlockStorageDiskType;
    private CommonCode baseBlockStorageDiskDetailType;
    private String placementGroupNo;
    private String placementGroupName;
    private String memberServerImageInstanceNo;
}
