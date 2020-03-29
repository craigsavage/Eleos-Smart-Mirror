package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class WifiSetupActivity extends AppCompatActivity {

    EditText et_wifiName, et_wifiPassword;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_setup);

        // Linking variables to their respective id
        et_wifiName = findViewById(R.id.et_wifiName);
        et_wifiPassword = findViewById(R.id.et_wifiPassword);
        btnSend = findViewById(R.id.btnSend);
    }

    public void connectWifi(View v) throws InterruptedException {
        // Get provided Name from text fields
        String wifiName = et_wifiName.getText().toString();
        String wifiPassword = et_wifiPassword.getText().toString();

        sleepFunc(1);  // Sleep
        Toast.makeText(this, "Wifi information sent to Smart Mirror", Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
     * Returns user to the main activity
     */
    public void cancelWifi(View v) { finish(); }

    /**
     * Sleeps for x seconds
     * @param x is the time in seconds to sleep
     * @throws InterruptedException
     */
    public void sleepFunc(int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
}
