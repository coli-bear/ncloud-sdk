package com.colibear.cloud.client.ncloud.compute.instance.dto;

import com.colibear.cloud.client.ncloud.CommonCode;
import lombok.Data;

@Data
public final class Product {
    private String productCode;
    private String productName;
    private CommonCode productType;
    private String productDescription;
    private CommonCode infraResourceType;
    private CommonCode infraResourceDetailType;
    private Integer cpuCount;
    private Long memorySize;
    private Long baseBlockStorageSize;
    private CommonCode platformType;
    private String osInformation;
    private CommonCode diskType;
    private String dbKindCode;
    private Long addBlockStorageSize;
    private String generationCode;
    private Long addBlockStroageSize;
}
