package com.spiderx.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class RequestFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);
    @Autowired
    private HttpServletRequest httpServletRequest;
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        String userId = requestContext.getHeaderString("user_id");
        String accessToken = requestContext.getHeaderString("access_token");
        String filterInfo = "Request filter params: [path: %s], [method:  %s], [user_id: %s], [access_token: %s]";
        LOGGER.info(String.format(filterInfo, path, method, userId, accessToken));
    }
}