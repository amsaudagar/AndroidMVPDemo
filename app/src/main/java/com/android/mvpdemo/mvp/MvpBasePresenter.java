package com.android.mvpdemo.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.android.mvpdemo.mvp.interfaces.IMvpBasePresenter;
import com.android.mvpdemo.mvp.interfaces.IMvpView;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Utilized to retrieved an attached view. Presenters can call a view that has attached itself
 * to the presenter by calling getMvpView(). This allows the presenter to handle complex logic,
 * and update the view accordingly.
 *
 */
public abstract class MvpBasePresenter implements IMvpBasePresenter {

    /**
     * The stored view object.
     */
    protected WeakReference<IMvpView> mView;

    /**
     * Used to attach the view to the presenter to allow the presenter direct view access.
     *
     * @param view the view to bind to the presenter.
     */

    @CallSuper
    @Override
    public void attachView(@NonNull IMvpView view) {
        this.mView = new WeakReference<>(view);
    }

    /**
     * This should be called when the view is detached. It mocks the functionality
     * of the view that was attached. The mock will not take any action,
     * but it allows the presenter to make any lingering asynchronous calls to update
     * the view that may occur after the view has been destroyed without checking if
     * the view is null before accessing it.
     */
    @CallSuper
    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }


    /**
     * Used by the presenter to gain control over its view.
     * Note: The only time this will return null is if it does not have a fragment
     * associated with it, i.e. a fragment that inherits from MvpBaseFragment
     * and sets the presenter inheriting from this class as its controller.
     *
     * @return the view attached to the presenter.
     */
    protected final IMvpView getMvpView() {
        if(mView != null & mView.get() != null){
            return mView.get();
        }
        return null;
    }


    @Override
    public final void close() throws IOException {
        disposePresenter();

        if (mView != null) {
            mView.clear();
        }
    }

    /**
     * Free up all the resources and dispose all the references
     */
    protected abstract void disposePresenter();

}