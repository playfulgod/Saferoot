package com.techygeek.saferoot.saferoot;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class UnRooterActivity extends Activity {
    Handler updateBarHandler;
    String tagname = "UnRoot";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unrooter);
        updateBarHandler = new Handler();

    }

    //all the work for rooting
    public void unRoot(){
    // unroot
        String cmd_unroot = "mount -o remount rw /system && rm -f /system/etc/install-recovery-2.sh* && rm /system/app/Superuser.apk && rm -f /system/xbin/selinuxoff* &&  find /system/xbin -type l | xargs rm && rm /system/xbin/busybox && mount -o remount,ro /system";
        root_tools.execute(cmd_unroot);
        Log.i(tagname, "UnRooting");

    }

    //the method to start the root.
    public void start(View view) {
        final ProgressDialog RingProgressDialog = ProgressDialog.show(UnRooterActivity.this, "Please Wait", "UnRooting", true);
        RingProgressDialog.setCancelable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //this is the runnable stuff for the progress bar
                    unRoot();
                } catch (Exception e) {
                    Log.e(tagname, "something went wrong");
                }
                RingProgressDialog.dismiss();

            }
        }).start();

        Context context = getApplicationContext();
        CharSequence text = "Device unrooted!";
        int duration = Toast.LENGTH_LONG;

        Toast.makeText(context, text, duration).show();
    }
}

