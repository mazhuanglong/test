package com.example.todayinformation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // ButterKnife.bind(this);
        changeAnima(rgMainBottom,rgMainTop);
    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:

                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnima(rgMainTop,rgMainBottom);
                } else {
                    changeAnima(rgMainBottom,rgMainTop);
                }
                break;
        }
    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //消失的动画
        gone.clearAnimation();//清除动画;
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_hide );
        gone.startAnimation(animation);
        gone.setVisibility(View.GONE);

        //展示的动画
        show.clearAnimation();;
        Animation animationShow = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_show );
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);

    }
}
