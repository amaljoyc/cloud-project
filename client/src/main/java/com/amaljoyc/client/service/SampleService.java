package com.amaljoyc.client.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amaljoyc on 14.06.18.
 */
@Service
public class SampleService {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public String getHello() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service", false);
        String baseUrl = instanceInfo.getHomePageUrl();
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
        return response.getBody();
    }
}
