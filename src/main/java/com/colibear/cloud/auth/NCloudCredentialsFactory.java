package com.colibear.cloud.auth;

import com.colibear.core.net.data.RequestEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Validated
@Component
public class NCloudCredentialsFactory {

    private RequestEndpoint requestEndpoint;
    private CloudCredentials credentials;

    public NCloudCredentialsFactory endpoint(@NotNull RequestEndpoint requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
        return this;
    }

    public NCloudSignatureCreator credentials(@NotNull CloudCredentials credentials) {
        if (requestEndpoint == null) {
            throw new NullPointerException(RequestEndpoint.class.getSimpleName());
        }
        this.credentials = credentials;
        return new NCloudSignatureCreator();
    }


    public class NCloudSignatureCreator {

        private class NCloudHeaders {
            private static final String TIME_STAMP = "x-ncp-apigw-timestamp";
            private static final String ACCESS_KEY = "x-ncp-iam-access-key";
            private static final String SIGNATURE = "x-ncp-apigw-signature-v2";
        }

        public void makeHeaders()
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {

            final String timeMillisString = String.valueOf(System.currentTimeMillis());

            String signature = makeSignature(timeMillisString);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            headers.add(NCloudHeaders.TIME_STAMP, timeMillisString);
            headers.add(NCloudHeaders.ACCESS_KEY, credentials.getAccessKey());
            headers.add(NCloudHeaders.SIGNATURE, signature);

            requestEndpoint.addHeaders(headers);
        }

        private String makeSignature(String timeMillisString) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
            String space = " ";          // one space
            String newLine = "\n";          // new line

            String message = new StringBuilder()
                .append(requestEndpoint.getMethod())
                .append(space)
                .append(requestEndpoint.getUri())
                .append(newLine)
                .append(timeMillisString)
                .append(newLine)
                .append(credentials.getAccessKey())
                .toString();

            SecretKeySpec signingKey = new SecretKeySpec(credentials.getSecretKey().getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            String encodeBase64String = Base64.encodeBase64String(rawHmac);

            return encodeBase64String;
        }
    }

    public RequestEndpoint getRequestEndpoint() {
        return this.requestEndpoint;
    }

    @Override
    public String toString() {
        return "[NCloudCredentialsFactory]" +
            "\n" + requestEndpoint.toString() +
            "\n" + credentials.toString();
    }
}
