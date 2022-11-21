package com.colibear.cloud.client.ncloud;

import lombok.Data;

@Data
public class BaseResponse {
    private String requestId;
    private Integer returnCode;
    private  String returnMessage;
}
