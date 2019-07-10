package com.amaljoyc.client.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by amaljoyc on 10.07.19.
 */
@Configuration
@ConfigurationProperties(prefix = "oauth2.client")
@Getter
@Setter
public class SecurityProperties {

    private String clientId;
    private String clientSecret;
    private String accessTokenUri;
}
