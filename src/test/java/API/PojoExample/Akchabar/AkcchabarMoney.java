package API.PojoExample.Akchabar;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.server.RMISocketFactory;
import java.security.NoSuchAlgorithmException;

public class AkcchabarMoney {

    @Test
    public void akchbar11() throws URISyntaxException, IOException, NoSuchAlgorithmException {
        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http").setHost("rates.akchabar.kg").setPath("get.json");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application.json");

//        SSLContext sslContext=SSLContext.getInstance("TLS");
//        SSLSocketFactory ssf = (SSLSocketFactory) sslContext.getSocketFactory();
//        SSLSocket sslSocket = (SSLSocket) ssf.createSocket("untrusted.host.example",
//                443);
//        SSLSession sslSession = sslSocket.getSession();
//        // sslSession.getPeerCertificates();
//        sslSocket.getInputStream().read();

        HttpResponse httpResponse=httpClient.execute(httpGet);
        //javax.net.ssl.SSLPeerUnverifiedException:
        // Certificate for <rates.akchabar.kg> doesn't match any of the subject alternative names: [akchabar.kg]

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }
        ObjectMapper objectMapper=new ObjectMapper();


        ResponseBodyAkcahbar parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), ResponseBodyAkcahbar.class);

        System.out.println(parsedObject.getRates().getBtc());

    }

}
