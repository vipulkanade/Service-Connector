package com.cfi.teamwarrior.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cfi.teamwarrior.R;
import com.cfi.teamwarrior.constants.Constants;
import com.cfi.teamwarrior.webservices.WebserviceURL;

import org.json.JSONException;
import org.json.JSONObject;

public class PostJobActivity extends BaseActivity implements View.OnClickListener {

    private EditText mJobName;
    private EditText mPersonName;
    private EditText mWage;

    private Button mButton;

    private BaseActivity mInstance;

    private JSONObject jsonObject = new JSONObject();

    // Progress dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        mInstance = new BaseActivity();

        mJobName = (EditText) findViewById(R.id.enter_job);
        mPersonName = (EditText) findViewById(R.id.enter_name);
        mWage = (EditText) findViewById(R.id.enter_wage);

        mButton = (Button) findViewById(R.id.post_job_button);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Posting Job...");
        pDialog.setCancelable(false);

        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_job_button:
                try {
                    jsonObject.put(Constants.JOB_SKILL, mJobName.getText().toString());
                    jsonObject.put(Constants.PERSON_NAME, mPersonName.getText().toString());
                    jsonObject.put(Constants.WAGE, mWage.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                postRequest();
            break;

            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

    }


    private void postRequest() {
        showpDialog();

        JsonObjectRequest req = new JsonObjectRequest(WebserviceURL.POST_JOB, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            hidepDialog();
                            VolleyLog.v("Response:%n %s", response.toString(4));
                            Toast.makeText(getApplicationContext(), "Job Request Posted Succesfully", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hidepDialog();
                VolleyLog.e("Error: ", error.getMessage());
                Toast.makeText(getApplicationContext(), "Job Request Posted Succesfully", Toast.LENGTH_SHORT).show();
            }
        });

        // add the request object to the queue to be executed
        mInstance.addToRequestQueue(req);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
