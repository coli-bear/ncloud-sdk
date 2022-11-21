package com.colibear.cloud.auth;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@Validated
public final class CloudCredentials {
    private final String accessKey;
    private final String secretKey;

    public CloudCredentials(
        @NotNull String accessKey,
        @NotNull String secretKey
    ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "CloudCredentials{" +
            "accessKey='" + accessKey + '\'' +
            ", secretKey='" + secretKey + '\'' +
            '}';
    }
}
