package com.example.todayinformation.base;

import com.example.http.IRequest;
import com.example.http.annotation.RequestMethod;

/**
 * on  2020/7/14}
 */
public class JHRequest extends LfRequest {
    public static IRequest sendHttp(String path, @RequestMethod int requestMethod, Type type) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        request.type = type;
        request.resultParser = DefaultResultParser.getInstance();
        return request;
    }
}
