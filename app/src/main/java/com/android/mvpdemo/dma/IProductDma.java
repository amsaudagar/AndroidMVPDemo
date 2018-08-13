package com.android.mvpdemo.dma;

import com.android.mvpdemo.network.interfaces.INetworkResponseListener;

import org.json.JSONObject;

public interface IProductDma {

    void requestData(JSONObject requestJson);
}
