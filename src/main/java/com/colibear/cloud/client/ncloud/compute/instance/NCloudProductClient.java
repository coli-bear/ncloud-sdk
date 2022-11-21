package com.colibear.cloud.client.ncloud.compute.instance;

import com.colibear.cloud.auth.CloudCredentials;
import com.colibear.cloud.auth.NCloudCredentialsFactory;
import com.colibear.cloud.client.ncloud.NCloudBaseClient;
import com.colibear.cloud.client.ncloud.compute.instance.dto.GetServerImageProductListResponse;
import com.colibear.cloud.client.ncloud.compute.instance.dto.GetServerProductListResponse;
import com.colibear.cloud.client.ncloud.compute.instance.dto.ProductList;
import com.colibear.cloud.client.ncloud.endpoint.NCloudServerEndpoint;
import com.colibear.cloud.client.ncloud.endpoint.NCloudZone;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.ClassicGetServerProductListQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.ClassicInstanceURI;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.VpcGetServerProductListQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.VpcServerURI;
import com.colibear.core.net.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
@Component
public class NCloudProductClient extends NCloudBaseClient {
    public NCloudProductClient(Client client, NCloudCredentialsFactory nCloudCredentialsFactory) {
        super(client, nCloudCredentialsFactory);
    }

    public ProductList getVpcServerProductList(NCloudZone zone, CloudCredentials credentials, @NotNull String serverImageProductCode) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        VpcGetServerProductListQuery serverProductListQuery = VpcGetServerProductListQuery.builder().serverImageProductCode(serverImageProductCode).build();

        Optional<GetServerProductListResponse> call = call(new NCloudServerEndpoint(zone, VpcServerURI.VPC_GET_SERVER_PRODUCT_LIST), credentials, serverProductListQuery, GetServerProductListResponse.class);

        if (call.isPresent()) {
            return call.get().getGetServerProductListResponse();
        }
        return null;
    }

    public ProductList getClassicServerProductList(NCloudZone zone, CloudCredentials credentials, @NotNull String serverImageProductCode) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        ClassicGetServerProductListQuery serverProductListQuery = ClassicGetServerProductListQuery.builder().serverImageProductCode(serverImageProductCode).build();

        Optional<GetServerProductListResponse> call = call(new NCloudServerEndpoint(zone, ClassicInstanceURI.CLASSIC_GET_SERVER_PRODUCT_LIST), credentials, serverProductListQuery, GetServerProductListResponse.class);

        if (call.isPresent()) {
            return call.get().getGetServerProductListResponse();
        }

        return null;
    }

    public ProductList getVpcServerImageProductList(NCloudZone zone, CloudCredentials credentials) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Optional<GetServerImageProductListResponse> call = call(new NCloudServerEndpoint(zone, VpcServerURI.VPC_GET_SERVER_IMAGE_PRODUCT_LIST), credentials, GetServerImageProductListResponse.class);
        if (call.isPresent()) {
            return call.get().getGetServerImageProductListResponse();
        }

        return null;
    }

    public ProductList getClassicServerImageProductList(NCloudZone zone, CloudCredentials credentials) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Optional<GetServerImageProductListResponse> call = call(new NCloudServerEndpoint(zone, ClassicInstanceURI.CLASSIC_GET_SERVER_IMAGE_PRODUCT_LIST), credentials, GetServerImageProductListResponse.class);
        if (call.isPresent()) {
            return call.get().getGetServerImageProductListResponse();
        }

        return null;
    }
}
