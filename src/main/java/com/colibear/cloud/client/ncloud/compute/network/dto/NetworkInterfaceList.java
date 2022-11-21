package com.colibear.cloud.client.ncloud.compute.network.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class NetworkInterfaceList {
    private Integer totalRows;
    private List<NetworkInterface> networkInterfaceList = new ArrayList<>();
}
