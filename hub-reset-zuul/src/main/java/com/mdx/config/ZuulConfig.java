package com.mdx.config;

import com.mdx.filter.Myfilter;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/13 15:55
 **/
@Configuration
@EnableZuulProxy
public class ZuulConfig {

    @Bean
    public Myfilter mfilter() {
        return new Myfilter();
    }

    /**
     * 配置负载均衡的方式
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

    /**
     * 配置restTemplet
     * @param restTemplateBuilder
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

}
