package com.colibear.cloud.client.ncloud.compute.instance.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class ProductList {
    private Integer totalRows;
    private List<Product> productList = new ArrayList<>();
}
