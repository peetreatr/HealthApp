package com.codepath.android.HCS_Productsearch.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The HCS_ProductList class, used to get the imformation  of Theraneutic HCS_Products
 */
public class HCS_ProductList {
    //private static final String API_BASE_URL = ???;
    private AsyncHttpClient client;

    /**
     * create a HCS_ProductClient object
     */
    public HCS_ProductClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    /**
     * Method for accessing the search API
     * @param message A <code>query, handler</code> for this object
     */
    public void getHCS_Products(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("search.json?q=");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * MMethod for accessing details of the HCS_Products
     * @param message A <code>HCS_ProductId, handler</code> for this object
     */
    public void getExtraDetails(String HCS_ProductId, JsonHttpResponseHandler handler) {
        String url = getApiUrl("HCS_Products/");
        client.get(url + producctsId + ".json", handler);
    }
}