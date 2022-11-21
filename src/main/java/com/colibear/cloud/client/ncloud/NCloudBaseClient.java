package com.colibear.cloud.client.ncloud;

import com.colibear.cloud.auth.CloudCredentials;
import com.colibear.cloud.auth.NCloudCredentialsFactory;
import com.colibear.cloud.client.ncloud.endpoint.CloudEndpoint;
import com.colibear.cloud.client.ncloud.endpoint.uri.CommonQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.Query;
import com.colibear.core.net.Client;
import com.colibear.core.net.data.RequestEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public abstract class NCloudBaseClient {
    private Client client;
    private NCloudCredentialsFactory nCloudCredentialsFactory;

    @Autowired
    public NCloudBaseClient(Client client, NCloudCredentialsFactory nCloudCredentialsFactory) {
        this.client = client;
        this.nCloudCredentialsFactory = nCloudCredentialsFactory;
    }

    protected <T> Optional<T> call(CloudEndpoint cloudEndpoint, CloudCredentials cloudCredentials, Class<T> clazz) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return this.call(cloudEndpoint, cloudCredentials, new CommonQuery(), clazz);
    }

    protected <T> Optional<T> call(CloudEndpoint cloudEndpoint, CloudCredentials cloudCredentials, Query queryString, Class<T> clazz) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        RequestEndpoint endpoint = RequestEndpoint.newInstance()
            .method(HttpMethod.GET)
            .endpoint(cloudEndpoint.endpoint())
            .uriWithQueryString(cloudEndpoint.uri(), queryString);

        nCloudCredentialsFactory
            .endpoint(endpoint)
            .credentials(cloudCredentials)
            .makeHeaders();

        T call = client.call(endpoint, clazz);

        return Optional.of(call);
    }
}
