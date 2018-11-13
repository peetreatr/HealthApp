package com.codepath.android.HCS_Productsearch.models;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * The HCS_ProductInfo class, used to demonstrate the imformation  of Theraneutic HCS_Products
 */
public class HCS_ProductInfo implements Serializable {
    private String company_name;
    private String name;
    private String brandname;
    private String product_weight;


    /**
     * Get the company_name of HCS_Product
     * @return the company_name
     */
    public String getcompany_name() {
        return openLibraryId;
    }

    /**
     * Get the name of HCS_Product
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Get the brandname of HCS_Product
     * @return the brandname
     */
    public String getbrandname() {
        return brandname;
    }

    /**
     * Get the  product_weight
     * @return the product_weight
     */
    public String getproduct_weight() {
        return product_weight;
    }

    /**
     *  Returns a HCS_Product given the expected JSON
     */

    public static HCS_Product fromJson(JSONObject jsonObject) {
        HCS_Product HCS_Product = new HCS_Product();
        try {
            // Deserialize json into object fields
            // Check if a cover edition is available
            if (jsonObject.has("cover_edition_key")) {
                HCS_Product.openLibraryId = jsonObject.getString("cover_edition_key");
            } else if(jsonObject.has("edition_key")) {
                final JSONArray ids = jsonObject.getJSONArray("edition_key");
                HCS_Product.openLibraryId = ids.getString(0);
            }
            HCS_Product.title = jsonObject.has("title_suggest") ? jsonObject.getString("title_suggest") : "";
            HCS_Product.brandname = getbrandname(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return HCS_ProductInfo;
    }

    /**
     *  Return comma separated brandname list when there is more than one brandname
     */

    Return comma separated brandname list when there is more than one brandname
    private static String getbrandname(final JSONObject jsonObject) {
        try {
            final JSONArray brandnames = jsonObject.getJSONArray("brandname_name");
            int numbrandnames = brandnames.length();
            final String[] brandnameStrings = new String[numbrandnames];
            for (int i = 0; i < numbrandnames; ++i) {
                brandnameStrings[i] = brandnames.getString(i);
            }
            return TextUtils.join(", ", brandnameStrings);
        } catch (JSONException e) {
            return "";
        }
    }

    /**
     *  Decodes array of HCS_Product json results into business model objects
     *  * @return the list of HCS_Products
     */
    public static ArrayList<HCS_Product> fromJson(JSONArray jsonArray) {
        ArrayList<HCS_Product> poducts = new ArrayList<HCS_Product>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject HCS_ProductJson = null;
            try {
                HCS_ProductJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            HCS_Product HCS_Product = HCS_Product.fromJson(HCS_ProductJson);
            if (b != null) {
                HCS_Products.add(HCS_Product);
            }
        }
        return HCS_Products;
    }
}