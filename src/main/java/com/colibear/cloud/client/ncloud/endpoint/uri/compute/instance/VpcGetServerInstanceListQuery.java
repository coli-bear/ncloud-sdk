package com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance;

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
public final class VpcGetServerInstanceListQuery extends CommonQuery {
    private String regionCode;
    private String vpcNo;
    private String serverName;
    private String serverInstanceStatusCode;
    private String baseBlockStorageDiskTypeCode;
    private String baseBlockStorageDiskDetailTypeCode;
    private String ip;
    private Integer pageNo;
    private Integer pageSize;
    private String sortedBy;
    private String sortingOrder;
    private List<String> serverInstanceNoList;
    private List<String> placementGroupNoList;
}
