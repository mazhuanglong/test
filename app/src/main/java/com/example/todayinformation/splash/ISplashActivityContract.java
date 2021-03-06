package com.example.todayinformation.splash;

import com.example.todayinformation.mvp.ILifeCircle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

/**
 * on  2020/7/8}
 */
public interface ISplashActivityContract {
    interface Iview extends IMvpView {
        void setTvTimer(String timer);

    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView=new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }



        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
