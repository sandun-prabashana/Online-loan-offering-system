package com.bumblebee.project.utility.constant;
/*
 * @author Yohan Samitha
 * @since 4/1/2023
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("security")
@Data
public class SecurityConfigurationProperties {
    private boolean allowedCredentials;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private List<String> exposedHeaders;
    private List<String> validApplicationRoles;
}
