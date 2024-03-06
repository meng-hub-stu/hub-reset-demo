package com.mdx.resource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Mengdl
 * @date 2023/12/01
 */
@Component
@ConfigurationProperties(prefix = "century")
@PropertySource("classpath:century.properties")
@Data
public class CenturyResource {

    private String realUrl;

    private String coupon;

    private String token;

    private String appId;

    private String appSecret;

    private String apiVersion;

}
