package com.android.yida.http.request;

import com.hjq.http.config.IRequestApi;

/**
获取用户信息
 */
public final class UserInfoApi implements IRequestApi {

    @Override
    public String getApi() {
        return "getuserinfo";
    }
    private String name;

    public UserInfoApi setName(String name) {
        this.name = name;
        return this;
    }
}