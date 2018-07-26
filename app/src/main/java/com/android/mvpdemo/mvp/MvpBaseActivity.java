package com.android.mvpdemo.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.android.mvpdemo.mvp.interfaces.IMvpBasePresenter;
import com.android.mvpdemo.mvp.interfaces.IMvpView;


/**
 * Attaches or detaches itself from the presenter based on the Activity lifecycle.
 */
public abstract class MvpBaseActivity  extends Activity {

    /**
     * Initializes the new instance of activity
     * <p/>
     * Stores the class of the presenter in a member variable
     */
    protected MvpBaseActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Gets the presenter that will be used to control the current view.
     * @return the presenter that will be used to control the current view
     */
    abstract public IMvpBasePresenter getPresenter();

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().attachView((IMvpView) this);
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().attachView((IMvpView) this);
    }

    @CallSuper
    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().detachView();
    }

    @CallSuper
    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().detachView();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }
}