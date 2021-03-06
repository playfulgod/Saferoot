package com.techygeek.saferoot.saferoot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;

public class RooterActivity extends Activity {
    Handler updateBarHandler;
    String tagname = "GetRoot";
    String dir = "/data/data/com.techygeek.saferoot.saferoot/saferoot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooter);
        updateBarHandler = new Handler();

        //chmod some stuff
        root_tools.executeAsSH("chmod 0755 " + dir + "/getroot_finish.sh");
        root_tools.executeAsSH("chmod 0755 " + dir + "/getroot_begin.sh");
        root_tools.executeAsSH("chmod 0755 " + dir + "/getroot");

    }

    //all the work for rooting
    public void getRoot(){
        //set up directories && chmod
        root_tools.executeAsSH(dir + "/getroot_begin.sh");
        Log.i(tagname, "getroot_begin.sh executed...");
        Log.i(tagname, "Starting actual root now...");

        //the actual get root
        root_tools.executeAsSH(dir + "/getroot");
        root_tools.executeAsSH(dir + "/getroot" + " > " + dir + "/log.text");
        Log.i(tagname, "getroot executed...");

        //clean up
        root_tools.executeAsSH(dir + "/getroot_finish.sh");
        Log.i(tagname, "getroot_finish.sh executed...");

    }

    //the method to start the root.
    public void start(View view) {
        final ProgressDialog RingProgressDialog = ProgressDialog.show(RooterActivity.this, "Please Wait", "Rooting", true);
        RingProgressDialog.setCancelable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //this is the runnable stuff for the progress bar
                    getRoot();
                } catch (Exception e) {
                    Log.e(tagname, "something went wrong");
                }
                RingProgressDialog.dismiss();

            }
        }).start();
    }
}

