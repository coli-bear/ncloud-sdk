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
public class ClassicGetServerImageProductListQuery extends CommonQuery {
    private String regionNo;
    private Integer blockStorageSize;
    private String exclusionProductCode;
    private String productCode;
    private String infraResourceDetailTypeCode;
    private List<String> platformTypeCodeList;
}
