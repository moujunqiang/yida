package com.android.yida.http.server;

import com.hjq.http.config.IRequestServer;
import com.hjq.http.config.IRequestType;
import com.hjq.http.model.BodyType;

/**
 * desc   : 正式环境
 */
public class ReleaseServer implements IRequestServer, IRequestType {

    @Override
    public String getHost() {
        return "http://test-api.hqcashmart.com/nigeria_v3/public/index.php/";
    }

    @Override
    public String getPath() {
        return "";
    }

    @Override
    public BodyType getType() {
        return BodyType.JSON;
    }
}