package com.android.mvpdemo.view.activities;

import android.os.Bundle;

import com.android.mvpdemo.R;
import com.android.mvpdemo.mvp.MvpBaseActivity;
import com.android.mvpdemo.mvp.interfaces.IMvpBasePresenter;
import com.android.mvpdemo.mvp.interfaces.IMvpView;
import com.android.mvpdemo.presenter.MainPresenter;


/**
 * Main activity
 */
public class MainActivity extends MvpBaseActivity implements IMvpView {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public IMvpBasePresenter getPresenter() {
        return new MainPresenter();
    }

}
