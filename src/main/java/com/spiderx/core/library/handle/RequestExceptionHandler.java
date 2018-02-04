package com.spiderx.core.library.handle;


import com.spiderx.core.domain.HttpStatusCode;
import com.spiderx.core.exception.AppException;
import com.spiderx.core.exception.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.UUID;


@Provider
public class RequestExceptionHandler implements ExceptionMapper<Throwable> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestExceptionHandler.class);
    private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
    @Context
    private ServletContext servletContext;
    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

    @Override
    public Response toResponse(Throwable exception) {
        String code = HttpStatusCode.SERVER_ERROR;
        try{
            code = String.valueOf((200==response.getStatus())?HttpStatusCode.SERVER_ERROR:response.getStatus());
        }catch (Exception e){
            code = HttpStatusCode.SERVER_ERROR;
        }
        String SERVER_ERROR = "inside server error";

        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(CONTEXT_ATTRIBUTE);
        if (exception instanceof AppException) {
            AppException appException = (AppException) exception;
            code = appException.getCode();
            code = (null == code ? HttpStatusCode.SERVER_ERROR : appException.getCode());
            String uuid = appException.getUuid();
            String message = appException.getMessage();
            message = (null == message) ? context.getMessage(code, null, exception.getMessage(),
                    request.getLocale()) : message;
            ErrorInfo errorOutput = new ErrorInfo(String.valueOf(code), message, uuid);
            syncErrorLogOutput(errorOutput);
            return Response.ok(errorOutput, MediaType.APPLICATION_JSON_TYPE).status(Integer.parseInt(code))
                    .build();
        }
        ErrorInfo errorInfo = new ErrorInfo(code, SERVER_ERROR, UUID.randomUUID().toString());
        return Response.ok(errorInfo, MediaType.APPLICATION_JSON_TYPE).status(Integer.parseInt(code))
                .build();
    }

    private void syncErrorLogOutput(ErrorInfo errorInfoOutput) {
        String userId = request.getHeader("user_id");
        String path = request.getRequestURI();
        String method = request.getMethod();
        Map<String, String[]> params = request.getParameterMap();
        String error = "Request event found error info: [user_id: %s], [path: %s], [method: %s], [params: %s] [message: %s]. [code: %s], [uuid: %s]";
        error = String.format(error,
                userId,
                path,
                method,
                params,
                errorInfoOutput.getMesssage(),
                errorInfoOutput.getCode(),
                errorInfoOutput.getUuid());
        LOGGER.error(error);
    }
}