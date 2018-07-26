package com.android.mvpdemo.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mvpdemo.R;
import com.android.mvpdemo.mvp.MvpBaseFragment;
import com.android.mvpdemo.mvp.interfaces.IMvpView;
import com.android.mvpdemo.presenter.interfaces.IMainPresenter;

/**
 * Fragment to display details
 */
public class MainFragment extends MvpBaseFragment implements IMvpView {

    private View mMainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (mMainView == null) {
            //Inflate only if does not exist, else just update it
            mMainView = inflater.inflate(R.layout.activity_main, container, false);
        }

        return mMainView;
    }

    @Override
    public IMainPresenter getPresenter() {
        return null;
    }
}

