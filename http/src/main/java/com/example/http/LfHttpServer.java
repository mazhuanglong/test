package com.example.http;

import java.util.Map;

/**
 * on  2020/7/14}
 */
public class LfHttpServer {
    protected <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
