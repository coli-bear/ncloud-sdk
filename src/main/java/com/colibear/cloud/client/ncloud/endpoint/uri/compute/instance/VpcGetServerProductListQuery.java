package com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance;

import com.colibear.cloud.client.ncloud.endpoint.uri.CommonQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VpcGetServerProductListQuery extends CommonQuery {
    private String regionCode;
    private String zoneCode;
    private String serverImageProductCode;
    private String exclusionProductCode;
    private String productCode;
    private String generationCode;
}
