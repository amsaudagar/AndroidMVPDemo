package com.android.mvpdemo.network;

import com.android.mvpdemo.network.interfaces.INetworkDataManager;
import com.android.mvpdemo.network.interfaces.INetworkResponseListener;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * The implementation of {@link INetworkDataManager}.<br/>
 * This will have the implementation of all the requests which 3PA is
 * going to make.
 */

public class NetworkDataManager implements INetworkDataManager {

    private RequestQueue mQueue;

    private enum RequestType {
        JSON_OBJECT_REQUEST,
        JSON_ARRAY_REQUEST;
    }

    public NetworkDataManager() {
        mQueue = VolleyRequestQueue.getInstance().getRequestQueue();
    }


    @Override
    public void getProductDetails(JSONObject responseJson, INetworkResponseListener networkResponseListener) {
        addRequest(RequestType.JSON_ARRAY_REQUEST, responseJson, networkResponseListener);
    }


    /**
     *
     * @param requestType
     * @param requestJson - Json for request
     */
    private void addRequest(final RequestType requestType, JSONObject requestJson,
                            INetworkResponseListener networkResponseListener) {
        Request request = null;

        String url = "";

        switch (requestType) {
            case JSON_OBJECT_REQUEST:
                request = new JsonObjectRequest(Request.Method.GET, url,
                        requestJson, networkResponseListener, networkResponseListener);
                break;
            case JSON_ARRAY_REQUEST:
                break;
        }

        mQueue.add(request);
    }

}
