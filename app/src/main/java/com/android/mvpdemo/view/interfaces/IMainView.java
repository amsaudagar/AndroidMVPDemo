package com.android.mvpdemo.view.interfaces;

import com.android.mvpdemo.gsonmodel.Categories;
import com.android.mvpdemo.mvp.interfaces.IMvpView;

/**
 * Represents the main screen details view interface
 */
public interface IMainView extends IMvpView {
    void refreshView(Categories categories);
    void onNetworkError();
}
