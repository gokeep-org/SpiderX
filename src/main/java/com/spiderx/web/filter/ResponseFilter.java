package com.spiderx.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        if (responseContext.getStatus() == 200)
            LOGGER.info("Response filter response success status code is :" + responseContext.getStatus());
        else
            LOGGER.error("Response filter response error code is :" + responseContext.getStatus());
    }
}