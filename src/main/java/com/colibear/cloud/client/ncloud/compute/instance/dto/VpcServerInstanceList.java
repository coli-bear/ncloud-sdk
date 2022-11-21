package com.colibear.cloud.client.ncloud.compute.instance.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class VpcServerInstanceList {
    private Integer totalRows;
    private List<VpcServerInstance> serverInstanceList = new ArrayList<>();
}
