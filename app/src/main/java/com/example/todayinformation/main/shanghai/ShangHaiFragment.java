package com.example.todayinformation.main.shanghai;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseFragment;
import com.example.todayinformation.base.ViewInject;
import com.example.todayinformation.main.shanghai.adapter.ShanghaiAdapter;
import com.example.todayinformation.main.shanghai.dto.ShanghaiDataManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;

/**
 * on  2020/7/9}
 */

@ViewInject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {
    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_collapsingtoolbarlayout)
    CollapsingToolbarLayout shanghaiCollapsingtoolbarlayout;
    @BindView(R.id.shanghai_app_barlayout)
    AppBarLayout shanghaiAppBarlayout;
    @BindView(R.id.shanghai_recycleview)
    RecyclerView mRecycleView;

    @Override
    public void afterBindView() {
        initRecycleView();
        initListener();
    }

    private void initRecycleView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));

        mRecycleView.setAdapter(new ShanghaiAdapter(getActivity(), ShanghaiDataManager.getData(), false));
    }

    private void initListener() {
        shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (-verticalOffset < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
