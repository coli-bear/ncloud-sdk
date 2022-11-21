package com.colibear.core.net.data;

import com.colibear.util.OpenApiUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.servlet.http.Cookie;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RequestEndpoint {

    private HttpMethod method;
    private String endpoint;
    private String uri;
    private Object body;

    private HttpHeaders headers;
    private List<Cookie> cookies;

    public static RequestEndpoint newInstance() {
        return new RequestEndpoint();
    }

    public RequestEndpoint method(@NotNull HttpMethod httpMethod) {
        this.method = httpMethod;
        return this;
    }

    public RequestEndpoint endpoint(@NotEmpty String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public RequestEndpoint uriWithQueryString(@NotEmpty String uri, Object param) {
        this.uri = OpenApiUtil.getOpenApiUrl(uri, param);
        return this;
    }

    public RequestEndpoint uri(@NotEmpty String uri) {
        this.uri = uri;
        return this;
    }

    public RequestEndpoint body(@NotNull Object body) {
        this.body = body;
        return this;
    }

    public RequestEndpoint addHeaders(@NotNull HttpHeaders headers) {
        if (this.headers == null) {
            this.headers = new HttpHeaders();
        }

        this.headers.addAll(headers);
        return this;
    }

    public RequestEndpoint cookie(@NotNull List<Cookie> cookies) {
        this.cookies = cookies;
        return this;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getUri() {
        return this.uri;
    }

    public Object getBody() {
        return this.body;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public List<Cookie> getCookies() {
        return this.cookies;
    }

    public boolean availableURI() {
        return this.uri != null && this.uri.isEmpty() && this.uri.isBlank();
    }

    public boolean availableHeaders() {
        return this.headers != null && !this.headers.isEmpty();
    }

    public boolean availableCookies() {
        return this.cookies != null && !this.cookies.isEmpty();
    }

    public boolean availableBody() {
        return this.body != null;
    }

    @Override
    public String toString() {
        return "[RequestEndpoint]\n$ " + method + " " + endpoint + uri +
            "\nbody\t" + body +
            "\nheaders\t" + headers +
            "\ncookies\t" + cookies +
            "\n";
    }
}
