package com.android.mvpdemo.network;

/**
 * Holds the network response
 */
public class NetworkResponse {
    private int mErrorCode;
    private String mErrorMessage;

    public void setErrorCode(int errorCode) {
        mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }
}
