package com.android.yida.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.yida.CollectActivity;
import com.android.yida.LoginActivity;
import com.android.yida.PersonInfoActivity;
import com.android.yida.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

public class MeFragment extends Fragment implements View.OnClickListener {

    private View inflate;
    private LinearLayout llInfo, llCollect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        return inflate;
    }

    public void initView() {
        llInfo = inflate.findViewById(R.id.rl_me_person_info);
        llCollect = inflate.findViewById(R.id.rl_me_collection);
        llInfo.setOnClickListener(this);
        llCollect.setOnClickListener(this);
        //点击注销跳转到登陆页面
        inflate.findViewById(R.id.tv_me_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });

    }

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_me_collection:
                startActivity(new Intent(getContext(), CollectActivity.class));

                break;
            case R.id.rl_me_person_info:
                startActivity(new Intent(getContext(), PersonInfoActivity.class));
                break;
        }
    }
}
