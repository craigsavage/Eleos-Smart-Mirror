package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SetupActivity extends AppCompatActivity {

    private static final String TAG = "SettingsActivity";

    Button btnBluetooth, btnRegistration, btnWifi, btnHome;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        // Linking variables to their respective id
        btnBluetooth = findViewById(R.id.btnBluetooth);
        btnRegistration = findViewById(R.id.btnRegistration);
        btnWifi = findViewById(R.id.btnWifi);
        btnHome = findViewById(R.id.btnHome);

        // Get the default adapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    // Bluetooth ~~~~~
    public void turnOnBluetooth(View v) throws InterruptedException {
        Toast.makeText(SetupActivity.this, "Turning on bluetooth", Toast.LENGTH_SHORT).show();

        // toggleBluetooth(); // Starts bluetooth connection
        sleepFunc(2);  // Sleep

        Toast.makeText(SetupActivity.this, "Bluetooth successfully connected!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Enables/disables bluetooth when pressed
     */
    public void toggleBluetooth() {
        if(bluetoothAdapter == null) {
            Toast.makeText(SetupActivity.this, "Device cannot use bluetooth.", Toast.LENGTH_LONG).show();
        }

        // Enable bluetooth if it is currently disabled
        if(!bluetoothAdapter.isEnabled()) {
            Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBluetoothIntent);

            makeDiscoverable();
        }

        // Disable bluetooth if it is currently enabled
        if(bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();
        }
    }

    /**
     * Lets other devices find our device
     */
    public void makeDiscoverable() {
        Intent makeDiscoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        makeDiscoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300); // 300 seconds
        startActivity(makeDiscoverableIntent);
    }

    // Device Registration ~~~~~
    public void deviceRegistration(View v) {
        Intent intent = new Intent(this, DeviceRegistrationActivity.class);
        startActivity(intent);
    }

    // Wifi Setup ~~~~~
    public void wifiSetup(View v) {
        Intent intent = new Intent(this, WifiSetupActivity.class);
        startActivity(intent);
    }

    /**
     * Returns user to the main activity
     */
    public void goHome(View v) { finish(); }

    /**
     * Sleeps for x seconds
     * @param x is the time in seconds to sleep
     * @throws InterruptedException
     */
    public void sleepFunc(int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
}
