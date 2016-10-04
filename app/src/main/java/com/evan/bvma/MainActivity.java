package com.evan.bvma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.evan.bvma.http.ApplicationController;
import com.evan.bvma.http.Helpers;
import com.evan.bvma.model.DealDetail;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image_id)
    ImageView imageView;

    @BindView(R.id.deal)
    TextView dealView;

    @BindView(R.id.retailer)
    TextView retailerView;

    @BindView(R.id.location)
    TextView locationView;

    @BindView(R.id.cat_cod)
    TextView categoryView;

    @BindView(R.id.item)
    TextView itemNameView;

    @BindView(R.id.original_price)
    TextView originalPriceView;

    @BindView(R.id.discount_price)
    TextView discountPriceView;

    @BindView(R.id.percentage)
    TextView percentageView;

    @BindView(R.id.units)
    TextView unitsView;

    @BindView(R.id.quantity)
    TextView quantityView;

    @BindView(R.id.effective_date)
    TextView effectiveDateView;

    @BindView(R.id.expiry_date)
    TextView expiryDateView;

    @BindView(R.id.active)
    TextView activeView;

    @BindView(R.id.views)
    TextView countOfViewsView;

    @BindView(R.id.description)
    TextView descriptionView;

    @BindView(R.id.table_layout)
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        getData(Helpers.URL);
    }

    private void getData(String endpoint) {
        StringRequest jsonObjRequest = new StringRequest(Request.Method.GET,
                endpoint, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    parseData(new JSONArray(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Oops! Something went wrong", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjRequest);
    }

    private void parseData(JSONArray jsonArray) {

        DealDetail dealDetail;
        String deal;
        String retailer;
        String location;
        String catCode;
        String itemName;
        String originalPrice;
        String discountPrice;
        String percentage;
        String units;
        String quantity;
        String imagePath;
        String imageFileName;
        String effectiveDate;
        String expiryDate;
        String active;
        String countOfView;
        String description;

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jSONObject = jsonArray.getJSONObject(i);
                deal = jSONObject.getString("DealId");
                retailer = jSONObject.getString("RetailerId");
                location = jSONObject.getString("LocationId");
                catCode = jSONObject.getString("CatCode");
                itemName = jSONObject.getString("ItemName");
                originalPrice = jSONObject.getString("OriginalPrice");
                discountPrice = jSONObject.getString("DiscountPrice");
                percentage = jSONObject.getString("Percentage");
                units = jSONObject.getString("Units");
                quantity = jSONObject.getString("Quantity");
                imagePath = jSONObject.getString("ImagePath");
                imageFileName = jSONObject.getString("ImageFileName");
                effectiveDate = jSONObject.getString("EffectiveDate");
                expiryDate = jSONObject.getString("ExpiryDate");
                active = jSONObject.getString("Active");
                countOfView = jSONObject.getString("CountOfViews");
                description = jSONObject.getString("Description");

                dealDetail = new DealDetail(deal, retailer, location, catCode, itemName, originalPrice, discountPrice, percentage
                             , units, quantity, imagePath, imageFileName, effectiveDate, expiryDate, active, countOfView, description);

                dealView.setText(dealDetail.getDealId());
                retailerView.setText(dealDetail.getRetailerId());
                locationView.setText(dealDetail.getLocationId());
                categoryView.setText(dealDetail.getCatCode());
                itemNameView.setText(dealDetail.getItemName());
                originalPriceView.setText(dealDetail.getOriginalPrice());
                discountPriceView.setText(dealDetail.getDiscountPrice());
                percentageView.setText(dealDetail.getPercentage());
                unitsView.setText(dealDetail.getUnits());
                quantityView.setText(dealDetail.getQuantity());
                Picasso.with(this).load(imagePath + imageFileName).into(imageView); //load image to image view using picasso
                effectiveDateView.setText(dealDetail.getEffectiveDate());
                expiryDateView.setText(dealDetail.getExpiryDate());
                activeView.setText(dealDetail.getActive());
                countOfViewsView.setText(dealDetail.getCountOfViews());
                descriptionView.setText(dealDetail.getDescription());
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
