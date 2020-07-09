package com.example.todayinformation.mvp;

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
