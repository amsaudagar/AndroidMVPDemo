package com.android.mvpdemo.network.interfaces;

/**
 * Callback interface for network failure
 */
public interface INetworkResponse {
    void onNetworkError(String errorMessage);
}
