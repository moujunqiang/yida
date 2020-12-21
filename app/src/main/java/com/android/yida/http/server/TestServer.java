package com.android.yida.http.server;

import com.hjq.http.config.IRequestType;
import com.hjq.http.model.BodyType;

/**
 * desc   : 测试环境
 */
public class TestServer extends ReleaseServer implements IRequestType {

    @Override
    public String getHost() {
        return "http://test-api.hqcashmart.com/nigeria_v3/public/index.php/";
    }

    @Override
    public BodyType getType() {
        return BodyType.JSON;
    }
}