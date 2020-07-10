package com.example.todayinformation.main;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.base.ViewInject;
import com.example.todayinformation.main.tool.MainConstantTool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_nav_home_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_nav_home_shenzhen)
    RadioButton rbMainNavHomeShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    private boolean isChangeTopOrBottom;


    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnima(rgMainBottom, rgMainTop);
        initCheckListener();
    }

    private void initCheckListener() {
//        rbMainShanghai.playAnimation();
//        rbMainShanghai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rbMainShanghai.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
//                rbMainShanghai.playAnimation();
//                rbMainHangzhou.reverseAnimation();
//            }
//        });
//
//        rbMainHangzhou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rbMainHangzhou.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
//                rbMainHangzhou.playAnimation();
//                rbMainShanghai.reverseAnimation();
//            }
//        });
        rbMainShanghai.setChecked(true);
        rgMainTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_shanghai:
                        mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                        break;
                    case R.id.rb_main_hangzhou:
                        mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                        break;
                }
            }
       });

        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_nav_home_beijing:
                        mPresenter.replaceFragment(MainConstantTool.BEIJING);
                        break;
                    case R.id.rb_main_nav_home_shenzhen:
                        mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                        break;
                }
            }
        });
    }


    //初始化Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnima(rgMainTop, rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnima(rgMainBottom, rgMainTop);
                    handleBottomPosition();
                }
                break;
        }
    }

    //北京深圳
    private void handleBottomPosition() {

        if(mPresenter.getTopPosition()!=MainConstantTool.HANGZHOU){
            mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
            rbMainShanghai.setChecked(true);
        }else {
            mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
            rbMainHangzhou.setChecked(true);
        }


    }

    //上海 杭州
    private void handleTopPosition() {
        if(mPresenter.getBottomPosition()!=MainConstantTool.SHENZHEN){
            mPresenter.replaceFragment(MainConstantTool.BEIJING);
            rbMainNavHomeBeijing.setChecked(true);
        }else {
            mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
            rbMainNavHomeShenzhen.setChecked(true);
        }

    }


    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //消失的动画
        gone.clearAnimation();//清除动画;
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animation);
        gone.setVisibility(View.GONE);

        //展示的动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);

    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}
