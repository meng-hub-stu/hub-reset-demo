package com.mdx.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/13 15:55
 **/
public class Myfilter extends ZuulFilter {

    private static final RateLimiter rateLimiter = RateLimiter.create(10);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!rateLimiter.tryAcquire()) {
            throw new ZuulException("Too many requests", HttpStatus.TOO_MANY_REQUESTS.value(), "rate limit");
        }
        // 过滤器的业务逻辑
        return null;
    }

}
