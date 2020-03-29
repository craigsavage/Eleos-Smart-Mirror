package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class DeviceRegistrationActivity extends AppCompatActivity {

    String key = "T3MPC0D3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_registration);
    }

    public void requestKey(View v) {
        Toast.makeText(this, "Code is displayed on the Mirror", Toast.LENGTH_SHORT).show();
    }

    public void registerDevice(View v) {
        Toast.makeText(this, "Device Successfully Registered", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * Returns user to the main activity
     */
    public void cancelRegistration(View v) { finish(); }

    /**
     * Sleeps for x seconds
     * @param x is the time in seconds to sleep
     * @throws InterruptedException
     */
    public void sleepFunc(int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
}
