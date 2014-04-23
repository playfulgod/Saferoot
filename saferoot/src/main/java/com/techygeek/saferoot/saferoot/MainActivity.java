package com.techygeek.saferoot.saferoot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {
    /** The view to show the ad. */
    //private AdView adView;

    /* Your ad unit id. Replace with your actual ad unit id. */
    //private static final String AD_UNIT_ID = "ca-app-pub-6428811458148980/5367725117";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*// Create an ad.
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AD_UNIT_ID);

        // Add the AdView to the view hierarchy. The view will have no size
        // until the ad is loaded.
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout2);
        layout.addView(adView);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("0DE03E6D3F16381D069654B06F38077D")
                .build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);*/


    }

    public void startroot(View view){
    	Intent intent = new Intent(this, RooterActivity.class);
        startActivity(intent);
    }

    public void unroot(View view){
        Intent intent = new Intent(this, UnRooterActivity.class);
        startActivity(intent);
    }

    public void rootcheck(View view){
        Intent intent = new Intent(this, RootChecker.class);
        startActivity(intent);
    }

   	public void info(View view) {
        AlertDialog.Builder about = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        about.setTitle(R.string.title_activity_info);
        about.setCancelable(false);
        about.setIcon(R.drawable.apple);
        about.setView(inflater.inflate(R.layout.activity_info, null));
        about.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        about.show();
    }
 }
