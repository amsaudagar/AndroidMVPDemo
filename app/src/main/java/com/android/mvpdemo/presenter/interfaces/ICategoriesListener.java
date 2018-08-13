package com.android.mvpdemo.presenter.interfaces;

import com.android.mvpdemo.gsonmodel.Categories;

public interface ICategoriesListener {

    void onDataReceived(Categories categories);

    void onResponseFailed();
}
