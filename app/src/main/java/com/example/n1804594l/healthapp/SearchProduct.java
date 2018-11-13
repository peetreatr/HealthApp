package com.codepath.android.productsearch.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The productList class, used to get the imformation  of Theraneutic products
 */
public class productList {
    //private static final String API_BASE_URL = ???;
    private AsyncHttpClient client;

    /**
     * create a ProductClient object
     */
    public ProductClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    /**
     * Method for accessing the search API
     * @param message A <code>query, handler</code> for this object
     */
    public void getproducts(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("search.json?q=");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * MMethod for accessing details of the products
     * @param message A <code>productId, handler</code> for this object
     */
    public void getExtraDetails(String productId, JsonHttpResponseHandler handler) {
        String url = getApiUrl("products/");
        client.get(url + producctsId + ".json", handler);
    }
}