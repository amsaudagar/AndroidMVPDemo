package com.android.mvpdemo.network.interfaces;

import com.android.volley.Response;

/**
 * Network response listener for success and failed
 */
public interface INetworkResponseListener<T> extends
        Response.Listener<T>,
        Response.ErrorListener {
}
