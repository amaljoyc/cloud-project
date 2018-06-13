package com.amaljoyc.client.api;

import com.amaljoyc.client.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amaljoyc on 14.06.18.
 */
@RestController
public class SampleController {

    @Autowired
    SampleService service;

    @RequestMapping("/")
    public String getHelloFromService() {
        return service.getHello();
    }
}
