package com.android.yida.http.request;

import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestType;
import com.hjq.http.model.BodyType;

public final class LoginApi implements IRequestApi, IRequestType {

    @Override
    public String getApi() {
        return "forelogin";
    }

    private String phone;

    private String password;

    public LoginApi setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LoginApi setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public BodyType getType() {
        return BodyType.JSON;
    }
}