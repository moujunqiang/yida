package com.android.yida;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.yida.http.model.HttpData;
import com.android.yida.http.request.LoginApi;
import com.android.yida.http.response.LoginBean;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.http.listener.OnHttpListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnHttpListener {

    /**
     * 请输入手机号
     */
    private EditText mEtLoginPhone;
    /**
     * 请输入密码
     */
    private EditText mEtLoginPwd;
    /**
     * 登 录
     */
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mEtLoginPhone = (EditText) findViewById(R.id.et_login_phone);
        mEtLoginPwd = (EditText) findViewById(R.id.et_login_pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                if (mEtLoginPhone.getText().toString().length() != 11) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mEtLoginPwd.getText().toString())) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                EasyHttp.post(this)
                        .api(new LoginApi().setPassword(mEtLoginPwd.getText().toString())
                                .setPhone(mEtLoginPhone.getText().toString()))
                        .request(new HttpCallback<HttpData<LoginBean>>(this) {

                            @Override
                            public void onSucceed(HttpData<LoginBean> data) {
                                // 跳转到主页
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();

                            }

                            @Override
                            public void onFail(Exception e) {
                                super.onFail(e);
                            }
                        });
                break;
        }
    }

    @Override
    public void onSucceed(Object result) {

    }

    @Override
    public void onFail(Exception e) {

    }
}