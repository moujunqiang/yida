package com.android.yida;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.yida.adapter.CollectAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvInfoBack;
    private RecyclerView mRvCollect;
    private CollectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
    }

    private void initView() {
        mIvInfoBack = (ImageView) findViewById(R.id.iv_info_back);
        mIvInfoBack.setOnClickListener(this);
        mRvCollect = (RecyclerView) findViewById(R.id.rv_collect);
        mRvCollect.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new CollectAdapter();
        mRvCollect.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_info_back:
                finish();
                break;
        }
    }
}