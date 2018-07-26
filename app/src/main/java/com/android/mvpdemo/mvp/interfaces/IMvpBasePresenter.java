package com.android.mvpdemo.mvp.interfaces;

import java.io.Closeable;

/**
 * Exposes necessary functionality for linking a presenter with a view. Any presenter that needs
 * to be linked to a view should implement this interface.
 */
public interface IMvpBasePresenter extends Closeable {

    /**
     * Attach the view to the presenter.
     */
    void attachView(IMvpView view);

    /**
     * Called if the view is destroyed.
     */
    void detachView();
}