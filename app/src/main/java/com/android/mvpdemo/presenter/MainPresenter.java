package com.android.mvpdemo.presenter;

import com.android.mvpdemo.mvp.MvpBasePresenter;
import com.android.mvpdemo.presenter.interfaces.IMainPresenter;
import com.android.mvpdemo.view.interfaces.IMainView;

/**
 * Implementation of main presenter
 */
public class MainPresenter extends MvpBasePresenter implements IMainPresenter {

    @Override
    public IMainView getView() {
        return (IMainView) getMvpView();
    }

    @Override
    protected void disposePresenter() {

    }

}
