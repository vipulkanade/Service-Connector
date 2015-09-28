package com.cfi.teamwarrior.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cfi.teamwarrior.R;
import com.cfi.teamwarrior.constants.Constants;
import com.cfi.teamwarrior.model.DataModelManager;
import com.cfi.teamwarrior.model.JobList;
import com.cfi.teamwarrior.webservices.WebserviceURL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity {

    private BaseActivity mInstance;

    private ListView mListView;

    private List<JobList> mJobList = new ArrayList<JobList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        mInstance = new BaseActivity();

        mListView = (ListView) findViewById(R.id.product_listview);

        makeRequest();

    }

    private void makeRequest() {

        Log.d(TAG, "In here");
        showProgressBar();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, WebserviceURL.GET_LIST_OF_JOB_SEEKER, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                hideProgressBar();
                JSONArray oResponse = response.optJSONArray(Constants.RESULTS_DATA);
                DataModelManager.getInstance().getJobList().clear();
                for (int i = 0; i < oResponse.length(); i++) {
                    JobList oGetProduct = new JobList(oResponse.optJSONObject(i));
                    DataModelManager.getInstance().getJobList().add(oGetProduct);
                }
                setDisplay();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                VolleyLog.e(TAG, error);
                hideProgressBar();
            }
        });
        mInstance.addToRequestQueue(jsObjRequest);
    }

    private void setDisplay() {
        mJobList = DataModelManager.getInstance().getJobList();

        if (mJobList.size() > 0 && mJobList != null) {
            mListView.setAdapter(new ListAdapter(this, mJobList));
        }
    }

    private void showProgressBar() {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        mListView.setVisibility(View.GONE);
    }

    private void hideProgressBar() {
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        mListView.setVisibility(View.VISIBLE);
    }
}