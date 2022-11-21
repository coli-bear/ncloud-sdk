package com.colibear.core.net;

import com.colibear.core.net.data.RequestEndpoint;

import javax.validation.constraints.NotNull;

public interface Client {
    <T> T call(@NotNull RequestEndpoint endpoint, @NotNull Class<T> clazz);
}
