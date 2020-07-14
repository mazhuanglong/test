package com.example.todayinformation.main.shanghai.model;

import com.example.http.IRequest;

/**
 * on  2020/7/14}
 */

public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get, ShangHaiDetailBean.class);
}

