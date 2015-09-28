package com.cfi.teamwarrior.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.cfi.teamwarrior.R;


public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mShopItemsImageButton;
    private ImageButton mEmployeeLoginImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_activity);

        mShopItemsImageButton = (ImageButton) findViewById(R.id.shop_items);
        mEmployeeLoginImageButton = (ImageButton) findViewById(R.id.login);

        mShopItemsImageButton.setOnClickListener(this);
        mEmployeeLoginImageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop_items:
                Intent intent = new Intent(this, PostJobActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.login:
                Intent oIntent = new Intent(this, MainActivity.class);
                startActivity(oIntent);
                finish();
                break;

            default:
                break;
        }
    }
}
