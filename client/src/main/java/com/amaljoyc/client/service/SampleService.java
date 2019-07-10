package com.amaljoyc.client.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by amaljoyc on 14.06.18.
 */
@Service
public class SampleService {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    public String getHello() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service", false);
        String baseUrl = instanceInfo.getHomePageUrl();
        ResponseEntity<String> response = oAuth2RestTemplate.getForEntity(baseUrl, String.class);
        return response.getBody();
    }
}
