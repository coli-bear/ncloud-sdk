package com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance;

import com.colibear.cloud.client.ncloud.endpoint.uri.CommonQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClassicGetServerProductListQuery extends CommonQuery {
    private String regionNo;
    private String zoneNo;
    private String serverImageProductCode;
    private String exclusionProductCode;
    private String productCode;
    private String generationCode;
}
