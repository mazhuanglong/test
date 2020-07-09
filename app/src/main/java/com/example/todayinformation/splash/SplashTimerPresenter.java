package com.example.todayinformation.splash;

import android.util.Log;

import com.example.todayinformation.mvp.ISplashActivityContract;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

/**
 * on  2020/7/7}
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview>  implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }


    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "s");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresenter", "onDestroy");
    }


    /*防止空指针 异常*/
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
