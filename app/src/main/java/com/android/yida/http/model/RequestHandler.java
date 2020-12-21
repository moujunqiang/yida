package com.android.yida.http.model;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.LifecycleOwner;

import com.android.yida.LoginActivity;
import com.android.yida.R;
import com.android.yida.http.json.BooleanTypeAdapter;
import com.android.yida.http.json.DoubleTypeAdapter;
import com.android.yida.http.json.FloatTypeAdapter;
import com.android.yida.http.json.IntegerTypeAdapter;
import com.android.yida.http.json.ListTypeAdapter;
import com.android.yida.http.json.LongTypeAdapter;
import com.android.yida.http.json.StringTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;

import com.hjq.http.EasyLog;
import com.hjq.http.config.IRequestHandler;
import com.hjq.http.exception.CancelException;
import com.hjq.http.exception.DataException;
import com.hjq.http.exception.HttpException;
import com.hjq.http.exception.ResponseException;
import com.hjq.http.exception.TimeoutException;
import com.hjq.http.exception.TokenException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * desc   : 请求处理类
 */
public final class RequestHandler implements IRequestHandler {

    private final Application mApplication;

    private Gson mGson;

    public RequestHandler(Application application) {
        mApplication = application;
    }

    @Override
    public Object requestSucceed(LifecycleOwner lifecycle, Response response, Type type) throws Exception {

        if (Response.class.equals(type)) {
            return response;
        }

        if (!response.isSuccessful()) {
            // 返回响应异常
            if (response.code() == 401) {
                throw new TokenException("");
            } else {
                throw new ResponseException(mApplication.getString(R.string.http_response_error) + "，responseCode：" + response.code() + "，message：" + response.message(), response);

            }
        }

        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }

        if (Bitmap.class.equals(type)) {
            // 如果这是一个 Bitmap 对象
            return BitmapFactory.decodeStream(body.byteStream());
        }

        String text;
        try {
            text = body.string();
        } catch (IOException e) {
            // 返回结果读取异常
            throw new DataException(mApplication.getString(R.string.http_data_explain_error), e);
        }

        // 打印这个 Json
        EasyLog.json(text);

        final Object result;
        if (String.class.equals(type)) {
            // 如果这是一个 String 对象
            result = text;
        } else if (JSONObject.class.equals(type)) {
            try {
                // 如果这是一个 JSONObject 对象
                result = new JSONObject(text);
            } catch (JSONException e) {
                throw new DataException(mApplication.getString(R.string.http_data_explain_error), e);
            }
        } else if (JSONArray.class.equals(type)) {
            try {
                // 如果这是一个 JSONArray 对象
                result = new JSONArray(text);
            } catch (JSONException e) {
                throw new DataException(mApplication.getString(R.string.http_data_explain_error), e);
            }
        } else {

            try {
                if (mGson == null) {
                    // Json 容错处理
                    mGson = new GsonBuilder()
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new StringTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, new BooleanTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
                            .registerTypeHierarchyAdapter(List.class, new ListTypeAdapter())
                            .create();
                }
                result = mGson.fromJson(text, type);
            } catch (JsonSyntaxException e) {
                // 返回结果读取异常
                throw new DataException(mApplication.getString(R.string.http_data_explain_error), e);
            }

            if (result instanceof HttpData) {
                HttpData model = (HttpData) result;


            }
        }
        return result;
    }

    @Override
    public Exception requestFail(LifecycleOwner lifecycle, Exception e) {
        // 判断这个异常是不是自己抛的
        if (e instanceof HttpException) {
            if (e instanceof TokenException) {
                // 登录信息失效，跳转到登录页

            }
        } else {
            if (e instanceof SocketTimeoutException) {
                e = new TimeoutException(mApplication.getString(R.string.http_server_out_time), e);
            } else if (e instanceof IOException) {
                //e = new CancelException(context.getString(R.string.http_request_cancel), e);
                e = new CancelException("", e);
            } else {
                e = new HttpException(e.getMessage(), e);
            }
        }
        return e;
    }
}