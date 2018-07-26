package com.android.mvpdemo.mvp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mvpdemo.mvp.interfaces.IMvpBasePresenter;
import com.android.mvpdemo.mvp.interfaces.IMvpView;


/**
 * Uses a fragment delegate to implement a Model-View-Presenter architecture by allowing fragments
 * that extend from this view to attach themselves to a presenter. The intent behind this structure
 * is to allow complex logic to remain in the presenter, allowing the presenter to make calls to a
 * simplified view as needed.
 */
public abstract class MvpBaseFragment extends Fragment {

    /**
     * Initializes the new instance of activity
     * Stores the class of the presenter in a member variable
     */
    protected MvpBaseFragment() {
        super();
    }

    /**
     * Gets the presenter that will be used to control the current view.
     * @return the presenter that will be used to control the current view
     */
    abstract public IMvpBasePresenter getPresenter();


    /**
     * Overrides the base Fragment onViewCreated method to ensure the view is linked to the presenter
     * when it is created.
     *
     * @param view               the view that will be linked
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     */
    @CallSuper
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getPresenter() != null) {
            getPresenter().attachView((IMvpView) this);
        }
    }

    /**
     * Overrides the base Fragment onCreateView method to ensure the view is linked to the presenter
     * when it is created.
     *
     * @param inflater           layout inflater used for inflating other views
     * @param container          the parent view of this fragment
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     */
    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (getPresenter() != null) {
            getPresenter().attachView((IMvpView) this);
        }
        return view;
    }

    /**
     * Overrides the base onDestroyView method to ensure that any presenter references to the view
     * are destroyed when the view is destroyed to prevent memory leaks.
     */
    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}