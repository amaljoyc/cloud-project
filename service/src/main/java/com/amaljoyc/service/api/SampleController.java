package com.amaljoyc.service.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amaljoyc on 14.06.18.
 */
@RestController
public class SampleController {

    @Value("${some.property:amal}")
    private String someProperty;

    @RequestMapping("/")
    public String hello() {
        return "HelloWorld " + someProperty;
    }
}
