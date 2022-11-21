package com.colibear.cloud.client.ncloud.compute.instance.dto;

import com.colibear.cloud.client.ncloud.CommonCode;
import com.colibear.cloud.client.ncloud.Region;
import com.colibear.cloud.client.ncloud.Zone;
import lombok.Data;

import java.util.Date;

@Data
public final class ClassicServerInstance {
    private String serverInstanceNo;
    private String serverName;
    private String serverDescription;
    private Integer cpuCount;
    private Long memorySize;
    private Long baseBlockStorageSize;
    private CommonCode platformType;
    private String loginKeyName;
    private Boolean isFeeChargingMonitoring;
    private String publicIp;
    private String privateIp;
    private String serverImageName;
    private CommonCode serverInstanceStatus;
    private CommonCode serverInstanceOperation;
    private String serverInstanceStatusName;
    private Date createDate;
    private Date uptime;
    private String serverImageProductCode;
    private String serverProductCode;
    private Boolean isProtectServerTermination;
    private String portForwardingPublicIp;
    private Integer portForwardingExternalPort;
    private Integer portForwardingInternalPort;
    private Zone zone;
    private Region region;
    private CommonCode baseBlockStorageDiskType;
    private CommonCode baseBlockStroageDiskDetailType;
    private CommonCode serverInstanceType;
    private String userData;
}
