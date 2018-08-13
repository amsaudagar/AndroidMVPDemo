package com.android.mvpdemo.view.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.android.mvpdemo.R;
import com.android.mvpdemo.gsonmodel.Categories;
import com.android.mvpdemo.mvp.MvpBaseActivity;
import com.android.mvpdemo.presenter.interfaces.IMainPresenter;
import com.android.mvpdemo.view.interfaces.IMainView;

import javax.inject.Inject;


/**
 * Main activity
 */
public class MainActivity extends MvpBaseActivity implements IMainView {

    @Inject
    private IMainPresenter mMainPresenter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPresenter().loadProductDetails();
    }

    @Override
    public IMainPresenter getPresenter() {
        return mMainPresenter;
    }

    @Override
    public void refreshView(Categories categories) {
        // TODO We can have the RecyclerView in this activity layout.
        // We can create the adapter by passing this categories to set the adapter to RecyclerView
    }

    @Override
    public void onNetworkError() {
        Toast.makeText(this, "There is network error, try again",
                Toast.LENGTH_SHORT).show();
    }
}
