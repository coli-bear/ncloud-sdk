package com.colibear.cloud.client.ncloud.compute.instance;

import com.colibear.cloud.auth.CloudCredentials;
import com.colibear.cloud.auth.NCloudCredentialsFactory;
import com.colibear.cloud.client.ncloud.NCloudBaseClient;
import com.colibear.cloud.client.ncloud.compute.instance.dto.ClassicServerInstanceList;
import com.colibear.cloud.client.ncloud.compute.instance.dto.GetClassicInstanceListResponse;
import com.colibear.cloud.client.ncloud.compute.instance.dto.GetVpcInstanceListResponse;
import com.colibear.cloud.client.ncloud.compute.instance.dto.VpcServerInstanceList;
import com.colibear.cloud.client.ncloud.endpoint.NCloudServerEndpoint;
import com.colibear.cloud.client.ncloud.endpoint.NCloudZone;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.ClassicInstanceURI;
import com.colibear.cloud.client.ncloud.endpoint.uri.compute.instance.VpcServerURI;
import com.colibear.core.net.Client;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Component("nCloudInstanceClient")
public class NCloudInstanceClient extends NCloudBaseClient {

    public NCloudInstanceClient(Client client, NCloudCredentialsFactory nCloudCredentialsFactory) {
        super(client, nCloudCredentialsFactory);
    }

    public VpcServerInstanceList getVpcInstanceList(NCloudZone zone, CloudCredentials cloudCredentials) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Optional<GetVpcInstanceListResponse> call = this.call(new NCloudServerEndpoint(zone, VpcServerURI.VPC_GET_SERVER_INSTANCE_LIST), cloudCredentials, GetVpcInstanceListResponse.class);

        if (call.isPresent()) {
            return call.get().getGetServerInstanceListResponse();
        }

        return null;
    }

    public ClassicServerInstanceList getClassicInstanceList(NCloudZone zone, CloudCredentials cloudCredentials) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Optional<GetClassicInstanceListResponse> call = this.call(new NCloudServerEndpoint(zone, ClassicInstanceURI.CLASSIC_GET_INSTANCE_LIST), cloudCredentials, GetClassicInstanceListResponse.class);
        if (call.isPresent()) {
            return call.get().getGetServerInstanceListResponse();
        }
        return null;
    }
}
