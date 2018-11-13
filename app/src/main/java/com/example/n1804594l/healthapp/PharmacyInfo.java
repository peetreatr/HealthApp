package com.codepath.android.pharmacysearch.models;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * The pharmacyInfo class, used to demonstrate the imformation  of Theraneutic pharmacys
 */
public class PharmacyInfo implements Serializable {

    private String name;
    private String address;
    private String Pharmacist;
    private double latitude;
    private double longitude;

    /**
     * Get the name of pharmacy
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Get the address of pharmacy
     * @return the address     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the  Pharmacist
     * @return the Pharmacist
     */
    public String getPharmacist() {
        return Pharmacist;
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

    /**
     * Get the imformation about longitude
     * @return the longitude
     */
    public double getLongitude(){
        return longitude;
    }


    /**
     *  Returns a pharmacy given the expected JSON
     * @return  Returns a pharmacy given the expected JSON
     */
    Returns a pharmacy given the expected JSON
    public static pharmacy fromJson(JSONObject jsonObject) {
        pharmacy pharmacy = new pharmacy();
        try {
            // Deserialize json into object fields
            // Check if a cover edition is available
            if (jsonObject.has("cover_edition_key")) {
                pharmacy.openLibraryId = jsonObject.getString("cover_edition_key");
            } else if(jsonObject.has("edition_key")) {
                final JSONArray ids = jsonObject.getJSONArray("edition_key");
                pharmacy.openLibraryId = ids.getString(0);
            }
            pharmacy.title = jsonObject.has("title_suggest") ? jsonObject.getString("title_suggest") : "";
            pharmacy.pharmacist = getpharmacist(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return pharmacyInfo;
    }

    // Return comma separated pharmacist list when there is more than one pharmacist
    private static String getpharmacist(final JSONObject jsonObject) {
        try {
            final JSONArray pharmacists = jsonObject.getJSONArray("pharmacist_name");
            int numpharmacists = pharmacists.length();
            final String[] pharmacistStrings = new String[numpharmacists];
            for (int i = 0; i < numpharmacists; ++i) {
                pharmacistStrings[i] = pharmacists.getString(i);
            }
            return TextUtils.join(", ", pharmacistStrings);
        } catch (JSONException e) {
            return "";
        }
    }

    /**
     *  Decodes array of pharmacy json results into business model objects
     *  * @return the list of pharmacys
     */
    public static ArrayList<pharmacy> fromJson(JSONArray jsonArray) {
        ArrayList<pharmacy> poducts = new ArrayList<pharmacy>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject pharmacyJson = null;
            try {
                pharmacyJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            pharmacy pharmacy = pharmacy.fromJson(pharmacyJson);
            if (b != null) {
                pharmacys.add(pharmacy);
            }
        }
        return pharmacys;
    }
}