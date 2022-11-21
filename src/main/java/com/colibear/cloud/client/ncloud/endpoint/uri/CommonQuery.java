package com.colibear.cloud.client.ncloud.endpoint.uri;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommonQuery implements Query {
    @Builder.Default
    private String responseFormatType = "json";
}
