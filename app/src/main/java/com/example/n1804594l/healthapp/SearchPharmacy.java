package com.codepath.android.pharmacysearch.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The pharmacyList class, used to get the imformation  of Theraneutic pharmacys
 */
public class pharmacyList {
    //private static final String API_BASE_URL = ???;
    private AsyncHttpClient client;

    /**
     * create a pharmacyClient object
     */
    public pharmacyClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    /**
     * Method for accessing the search API
     * @param message A <code>query, handler</code> for this object
     */
    public void getpharmacys(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("search.json?q=");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * MMethod for accessing details of the pharmacys
     * @param message A <code>pharmacyId, handler</code> for this object
     */
    public void getExtraDetails(String pharmacyId, JsonHttpResponseHandler handler) {
        String url = getApiUrl("pharmacys/");
        client.get(url + producctsId + ".json", handler);
    }
}