package com.codepath.android.productsearch.models;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * The productInfo class, used to demonstrate the imformation  of Theraneutic products
 */
public class productInfo implements Serializable {
    private String licenseNo;
    private String name;
    private String holder;
    private String forensic_classification;
    private String atcCode;
    private String dosage_form;
    private String route_of_administration;

    /**
     * Get the licenseNo of product
     * @return the licenseNo
     */
    public String getLicenseNo() {
        return openLibraryId;
    }

    /**
     * Get the name of product
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Get the holder of product
     * @return the holder
     */
    public String getHolder() {
        return holder;
    }

    /**
     * Get the  forensic_classification
     * @return the forensic_classification
     */
    public String getForensic_classification() {
        return forensic_classification;
    }

    /**
     * Get the AtcCode
     * @return the AtcCode
     */
    public String getAtcCode() {
        return atcCode;
    }

    /**
     * Get the Dosage_form()
     * @return the Dosage_form()
     */
    public String getDosage_form() {
        return dosage_form;
    }

    /**
     * Get the route_of_administration
     * @return theroute_of_administration
     */
    public String getRoute_of_administration() {
        return  route_of_administration;
    }


    // Returns a product given the expected JSON
    public static product fromJson(JSONObject jsonObject) {
        product product = new product();
        try {
            // Deserialize json into object fields
            // Check if a cover edition is available
            if (jsonObject.has("cover_edition_key")) {
                product.openLibraryId = jsonObject.getString("cover_edition_key");
            } else if(jsonObject.has("edition_key")) {
                final JSONArray ids = jsonObject.getJSONArray("edition_key");
                product.openLibraryId = ids.getString(0);
            }
            product.title = jsonObject.has("title_suggest") ? jsonObject.getString("title_suggest") : "";
            product.holder = getholder(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return productInfo;
    }

    // Return comma separated holder list when there is more than one holder
    private static String getholder(final JSONObject jsonObject) {
        try {
            final JSONArray holders = jsonObject.getJSONArray("holder_name");
            int numholders = holders.length();
            final String[] holderStrings = new String[numholders];
            for (int i = 0; i < numholders; ++i) {
                holderStrings[i] = holders.getString(i);
            }
            return TextUtils.join(", ", holderStrings);
        } catch (JSONException e) {
            return "";
        }
    }

    /**
     *  Decodes array of product json results into business model objects
     *  * @return the list of products
     */
    public static ArrayList<Product> fromJson(JSONArray jsonArray) {
        ArrayList<Product> poducts = new ArrayList<Product>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productJson = null;
            try {
                productJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Product product = Product.fromJson(productJson);
            if (b != null) {
                products.add(product);
            }
        }
        return products;
    }
}