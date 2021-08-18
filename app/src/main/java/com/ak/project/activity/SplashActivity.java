package com.ak.project.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.ak.project.R;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint("CustomSplashScreen")
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
public class SplashActivity extends AppCompatActivity {
    private long                startTimeMillis     = 0;
    private static final int    PERMISSIONS_REQUEST = 1234;


    public int getTimeoutMillis() {
        return 1500;
    }

    @SuppressWarnings("rawtypes")
    public Class getNextActivityClass() {
        return HomeActivity.class;
    }


    public String[] getRequiredPermissions() {
        String[] permissions =  {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
        };

        return permissions.clone();
    }

    @TargetApi(23)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        startTimeMillis = System.currentTimeMillis();

        if (Build.VERSION.SDK_INT >= 23) {
            checkPermissions();
        } else {
            startNextActivity();
        }
    }


    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST) {
            checkPermissions();
        }
    }

    private void startNextActivity() {
        runOnUiThread(() -> {

        });
        long delayMillis = getTimeoutMillis() - (System.currentTimeMillis() - startTimeMillis);
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, getNextActivityClass()));
            finish();
        }, delayMillis);
    }


    private void checkPermissions() {
        String[] ungrantedPermissions = requiredPermissionsStillNeeded();
        if (ungrantedPermissions.length == 0) {
            startNextActivity();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(ungrantedPermissions, PERMISSIONS_REQUEST);
            }
        }
    }
    @TargetApi(23)
    private String[] requiredPermissionsStillNeeded() {

        Set<String> permissions = new HashSet<>();
        Collections.addAll(permissions, getRequiredPermissions());
        for (Iterator<String> i = permissions.iterator(); i.hasNext();) {
            String permission = i.next();
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                Log.d(SplashActivity.class.getSimpleName(),
                        "Permission: " + permission + " already granted.");
                i.remove();
            } else {
                Log.d(SplashActivity.class.getSimpleName(),
                        "Permission: " + permission + " not yet granted.");
            }
        }
        return permissions.toArray(new String[0]);
    }
}