package com.example.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpController;

/**
 * on  2020/7/8}
 */
public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (this.mvpController == null) {
            this.mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=this.getArguments();

        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onCreate(savedInstanceState, null, bundle );
            mvpController.onActivityCreated(savedInstanceState, null, bundle );
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=this.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onActivityCreated(savedInstanceState,null,bundle);

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onViewDestroy();

        }
    }

    @Override
   public void onStart() {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onStart();

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onResume();

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onPause();

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onStop();

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onDestroy();

        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onSaveInstanceState(outState);

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onActivityResult(requestCode, resultCode, data);

        }
    }


}
