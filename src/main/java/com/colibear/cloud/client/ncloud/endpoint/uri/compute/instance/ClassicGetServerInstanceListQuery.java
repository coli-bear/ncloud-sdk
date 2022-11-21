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
public final class ClassicGetServerInstanceListQuery extends CommonQuery {
    private List<String> serverInstanceNoList;
    private String searchFilterName;
    private String searchFilterValue;
    private Integer pageNo;
    private Integer pageSize;
    private String serverInstanceStatusCode;
    private String regionNo;
    private String zoneNo;
    private String baseBlockStorageDiskTypeCode;
    private String baseBlockStorageDiskDetailTypeCode;
    private String sortedBy;
    private String sortingOrder;
    private List<String> serverInstanceTypeCodeList;
    private List<String> tagKeyList;
    private List<String> tagKeyValue;
}
