package com.spring.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);


    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getParameter("token");
        if(null==accessToken){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        log.info("access token ok");

        return null;
    }
}
