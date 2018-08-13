package com.android.mvpdemo.network.interfaces;

import org.json.JSONObject;

/**
 * Contract to define the ways in which the order can be placed, edited or deleted from the system.<br/>
 * Same contract can be used to submit the feedback as well.
 */

public interface INetworkDataManager {

    /**
     * Method to place the selected item as Order
     * @param responseJson the items in the form of Order as JSON object
     * @return The response when order is placed. The response can be success or failure
     */
    void getProductDetails(JSONObject responseJson, INetworkResponseListener networkResponseListener);

}
