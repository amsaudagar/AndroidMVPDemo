package com.android.mvpdemo.dma;

import com.android.mvpdemo.gsonmodel.Categories;
import com.android.mvpdemo.network.interfaces.INetworkDataManager;
import com.android.mvpdemo.network.interfaces.INetworkResponseListener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

public class ProductDma implements IProductDma, INetworkResponseListener<JSONObject> {

    private final INetworkDataManager mNetworkDataManager;
    private final Gson mGson;

    public ProductDma(INetworkDataManager networkDataManager, Gson gson) {
        mNetworkDataManager = networkDataManager;
        mGson = gson;
    }

    @Override
    public void requestData(JSONObject requestJson) {
        mNetworkDataManager.getProductDetails(requestJson, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        Categories categories = mGson.fromJson(response.toString(), Categories.class);
    }
}
