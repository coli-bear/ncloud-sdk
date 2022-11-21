package com.colibear.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

public class OpenApiUtil {
    public static String getOpenApiUrl(@NotEmpty String uri, Object requestDto) {
        final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(uri);
        if (requestDto == null)
            return uri;

        return uriAndParamMerge(uriBuilder, "", requestDto).toUriString();
    }

    private static UriComponentsBuilder uriAndParamMerge(UriComponentsBuilder uriBuilder, String keyPrefix, final Object getParameters) {
        final Map<String, Object> map = ApplicationContextUtil.getObjectMapper().convertValue(getParameters, new TypeReference<Map>() {
        });
        for (final Map.Entry<String, Object> entry : map.entrySet()) {
            final Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            if (value instanceof List) {
                if (((List<?>) value).isEmpty()) {
                    continue;
                }
                final List<Map> list = ApplicationContextUtil.getObjectMapper().convertValue(value, new TypeReference<List>() {
                });
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof Map) {
                        uriBuilder = uriAndParamMerge(uriBuilder, keyPrefix + entry.getKey() + "." + (i + 1) + ".", list.get(i));
                    } else {
                        uriBuilder = uriBuilder.replaceQueryParam(keyPrefix + entry.getKey() + "." + (i + 1), list.get(i));
                    }
                }
            } else {
                uriBuilder = uriBuilder.replaceQueryParam(keyPrefix + entry.getKey(), value);
            }
        }
        return uriBuilder;
    }
}
