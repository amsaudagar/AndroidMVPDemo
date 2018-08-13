package com.android.mvpdemo.presenter;

import com.android.mvpdemo.dma.IProductDma;
import com.android.mvpdemo.gsonmodel.Categories;
import com.android.mvpdemo.mvp.MvpBasePresenter;
import com.android.mvpdemo.presenter.interfaces.ICategoriesListener;
import com.android.mvpdemo.presenter.interfaces.IMainPresenter;
import com.android.mvpdemo.view.interfaces.IMainView;

import org.json.JSONObject;

/**
 * Implementation of main presenter
 */
public class MainPresenter extends MvpBasePresenter implements IMainPresenter,
        ICategoriesListener {

    private final IProductDma mProductDma;

    public MainPresenter(IProductDma productDma) {
        mProductDma = productDma;
    }

    @Override
    public void loadProductDetails() {
        mProductDma.requestData(new JSONObject());
    }

    @Override
    public IMainView getView() {
        return (IMainView) getMvpView();
    }

    @Override
    protected void disposePresenter() {

    }

    @Override
    public void onDataReceived(Categories categories) {
        //TODO Complete data is available we can pass this to view to update the UI
        // We may perform the operation on received categories here and sent filtered data to view
        getView().refreshView(categories);
    }

    @Override
    public void onResponseFailed() {
        getView().onNetworkError();
    }
}
