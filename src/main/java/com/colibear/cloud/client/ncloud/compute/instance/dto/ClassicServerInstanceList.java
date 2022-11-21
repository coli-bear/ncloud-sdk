package com.colibear.cloud.client.ncloud.compute.instance.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class ClassicServerInstanceList {
    private Integer totalRows;
    private List<ClassicServerInstance> serverInstanceList = new ArrayList<>();
}

