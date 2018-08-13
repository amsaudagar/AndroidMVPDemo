package com.android.mvpdemo.presenter.interfaces;


import com.android.mvpdemo.mvp.interfaces.IMvpBasePresenter;
import com.android.mvpdemo.view.interfaces.IMainView;

/**
 * The presenter interface for main screen through which the View will notify of user input
 */
public interface IMainPresenter extends IMvpBasePresenter {
    /**
     * Returns the instance of IMainView
     * @return
     */
    IMainView getView();

    void loadProductDetails();
}


