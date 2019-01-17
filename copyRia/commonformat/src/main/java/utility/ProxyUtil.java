package com.luxottica.ria.commonformat.utility;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by Kevin Pontzloff on 11/14/2018.
 */
public class ProxyUtil {

    public static RestTemplate initRestTemplate(String timeoutValue) {
        return new RestTemplate(getClientHttpRequestFactory(timeoutValue, false));
    }

    public static RestTemplate initRestTemplate(String timeoutValue, boolean routeThroughProxy) {
        return new RestTemplate(getClientHttpRequestFactory(timeoutValue, routeThroughProxy));
    }

    private static ClientHttpRequestFactory getClientHttpRequestFactory(String timeoutValue, boolean routeThroughProxy) {
        int timeout = Integer.parseInt(timeoutValue);
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        if (routeThroughProxy) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(CommonConstants.PROXY_ADDRESS, CommonConstants.PROXY_PORT));
            clientHttpRequestFactory.setProxy(proxy);
        }
        return  clientHttpRequestFactory;
    }
}

