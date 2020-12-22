package com.android.yida;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class PersonInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvInfoBack;
    private ImageView mIvInfoHead;
    private ImageView mImage;
    /**
     * Mary
     */
    private TextView mTvInfoName;
    private ImageView mImage1;
    /**
     * 女
     */
    private TextView mTvInfoGender;
    private ImageView mImage2;
    /**
     * 请输入身高（cm）
     */
    private EditText mEtInfoHeight;
    private ImageView mImage3;
    /**
     * 请输入体重（kg）
     */
    private EditText mEtInfoWeight;
    private ImageView mImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        initView();
    }

    private void initView() {
        mIvInfoBack = (ImageView) findViewById(R.id.iv_info_back);
        mIvInfoBack.setOnClickListener(this);
        mIvInfoHead = (ImageView) findViewById(R.id.iv_info_head);
        mImage = (ImageView) findViewById(R.id.image);
        mTvInfoName = (TextView) findViewById(R.id.tv_info_name);
        mImage1 = (ImageView) findViewById(R.id.image1);
        mTvInfoGender = (TextView) findViewById(R.id.tv_info_gender);
        mImage2 = (ImageView) findViewById(R.id.image2);
        mEtInfoHeight = (EditText) findViewById(R.id.et_info_height);
        mImage3 = (ImageView) findViewById(R.id.image3);
        mEtInfoWeight = (EditText) findViewById(R.id.et_info_weight);
        mImage4 = (ImageView) findViewById(R.id.image4);
        mIvInfoHead.setOnClickListener(this);
        mTvInfoName = (EditText) findViewById(R.id.tv_info_name);
        mTvInfoGender.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_info_back:
                finish();
                break;
            case R.id.iv_info_head:
                // 自由配置选项
              /*  ISListConfig config = new ISListConfig.Builder()
                        // 是否多选, 默认true
                        .multiSelect(false)
                        // 是否记住上次选中记录, 仅当multiSelect为true的时候配置，默认为true
                        .rememberSelected(false)
                        // “确定”按钮背景色
                        .btnBgColor(Color.GRAY)
                        // “确定”按钮文字颜色
                        .btnTextColor(Color.BLUE)
                        // 使用沉浸式状态栏
                        .statusBarColor(Color.parseColor("#3F51B5"))
                        // 返回图标ResId
                        .backResId(R.drawable.ic_back)
                        // 标题
                        .title("图片")
                        // 标题文字颜色
                        .titleColor(Color.WHITE)
                        // TitleBar背景色
                        .titleBgColor(Color.parseColor("#3F51B5"))
                        // 裁剪大小。needCrop为true的时候配置
                        .cropSize(1, 1, 200, 200)
                        .needCrop(true)
                        // 第一个是否显示相机，默认true
                        .needCamera(false)
                        // 最大选择图片数量，默认9
                        .maxNum(9)
                        .build();

// 跳转到图片选择器
                ISNav.getInstance().toListActivity(this, config, 100);*/
                break;
            case R.id.tv_info_gender:

                break;
        }
    }
 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 图片选择结果回调
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra("result");
            for (String path : pathList) {
            }
        }
    }*/
}