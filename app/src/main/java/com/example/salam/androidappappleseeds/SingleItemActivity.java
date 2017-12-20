package com.example.salam.androidappappleseeds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inneractive.api.ads.sdk.InneractiveAdManager;
import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.squareup.picasso.Picasso;

/**
 * Created by salam on 12/20/2017.
 */

public class SingleItemActivity extends AppCompatActivity implements View.OnClickListener{

    ListItem product;
    ImageView img;
    TextView title;
    TextView desc;
    Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        Intent intent = getIntent();

        product = (ListItem) intent.getSerializableExtra("product");

        img = (ImageView) findViewById(R.id.imgItem);
        title = (TextView) findViewById(R.id.titleItem);
        desc = (TextView) findViewById(R.id.descItem);
        buyBtn = (Button) findViewById(R.id.buyBtn);

        initFields();

        buyBtn.setOnClickListener(this);

        showAdv();

        InneractiveAdManager.initialize(this);
        InneractiveAdManager.setLogLevel(Log.VERBOSE);
    }

    private void initFields() {
        Picasso.with(getApplicationContext()).load(Uri.parse(product.getImg())).into(img);
        title.setText(product.getName());
        desc.setText(product.getDescription());
    }

    @Override
    public void onClick(View v) {

        Intent nextPageIntent = new Intent(getApplicationContext(), ItemViewOnWebActivity.class);
        nextPageIntent.putExtra("url", product.getProductUrl());
        startActivity(nextPageIntent);

    }


    private void showAdv() {

        LinearLayout parent = (LinearLayout) findViewById(R.id.singleParent);

        InneractiveAdView mBanner = new InneractiveAdView(this, "Nirit_MobileSchool_Android", InneractiveAdView.AdType.Banner);
        mBanner.setRefreshInterval(30);
        parent.addView(mBanner);
        mBanner.loadAd();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();


        if (isFinishing()) {
            InneractiveAdManager.destroy();
        }
    }
}
