package com.colibear.cloud.client.ncloud.compute.network;

import com.colibear.cloud.auth.CloudCredentials;
import com.colibear.cloud.auth.NCloudCredentialsFactory;
import com.colibear.cloud.client.ncloud.NCloudBaseClient;
import com.colibear.cloud.client.ncloud.compute.network.dto.GetNetworkInterfaceListResponse;
import com.colibear.cloud.client.ncloud.compute.network.dto.NetworkInterfaceList;
import com.colibear.cloud.client.ncloud.endpoint.NCloudServerEndpoint;
import com.colibear.cloud.client.ncloud.endpoint.NCloudZone;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.network.GetNetworkInterfaceDetailQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.network.GetNetworkInterfaceListQuery;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.network.VpcNetworkURI;
import com.colibear.core.net.Client;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Component("nCloudNetworkClient")
public class NCloudNetworkClient extends NCloudBaseClient {


    public NCloudNetworkClient(Client client, NCloudCredentialsFactory nCloudCredentialsFactory) {
        super(client, nCloudCredentialsFactory);
    }

    public NetworkInterfaceList getVpcNetworkList(NCloudZone zone, CloudCredentials cloudCredentials) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Optional<GetNetworkInterfaceListResponse> call = this.call(new NCloudServerEndpoint(zone, VpcNetworkURI.VPC_GET_SERVER_NETWORK_LIST), cloudCredentials, GetNetworkInterfaceListResponse.class);
        if (call.isPresent()) {
            return call.get().getGetNetworkInterfaceListResponse();
        }
        return null;
    }

    public NetworkInterfaceList getVpcNetworkDetail(NCloudZone zone, CloudCredentials cloudCredentials, String networkInterfaceNo) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        GetNetworkInterfaceDetailQuery networkInterfaceDetailQuery = GetNetworkInterfaceDetailQuery.builder().networkInterfaceNo(networkInterfaceNo).build();
        Optional<GetNetworkInterfaceListResponse> call = this.call(new NCloudServerEndpoint(zone, VpcNetworkURI.VPC_GET_SERVER_NETWORK_LIST), cloudCredentials, networkInterfaceDetailQuery, GetNetworkInterfaceListResponse.class);
        if (call.isPresent()) {
            return call.get().getGetNetworkInterfaceListResponse();
        }
        return null;
    }
}
