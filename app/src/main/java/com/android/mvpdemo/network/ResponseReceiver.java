package com.android.mvpdemo.network;

/**
 * Interface to receive callbacks from {@link ICommunicationManager} on
 * successful request or if the request fails.
 *
 */

public interface ResponseReceiver {

    /**
     * Callback if the request was success with the response as json.
     * @param json the json
     */
    void onResponseReceived(String json);

    /**
     * Callback if request fails.
     * @param json The json describing the reason for failure
     * @param reasonCode The code related to failure
     */
    void onFailure(String json, int reasonCode);
}
