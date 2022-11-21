package com.colibear.cloud.client.ncloud.endpoint;

import com.colibear.cloud.client.ncloud.endpoint.uri.NCloudURI;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public final class NCloudServerEndpoint implements CloudEndpoint{

    private final String endpoint;
    private final NCloudURI uri;

    public NCloudServerEndpoint(@NotNull NCloudZone NCloudZone, @NotNull NCloudURI uri) {
        this.endpoint = NCloudZone.getUrl();
        this.uri = uri;
    }

    @Override
    public String endpoint() {
        return this.endpoint;
    }

    @Override
    public String uri() {
        return this.uri.getUri();
    }
}
