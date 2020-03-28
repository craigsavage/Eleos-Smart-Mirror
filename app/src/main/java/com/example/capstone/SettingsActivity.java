package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = "SettingsActivity";

    Button btnHome;
    ImageView ivRecord;

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnHome = findViewById(R.id.btnHome);
        ivRecord = findViewById(R.id.ivRecord);

        // Get the default adapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // OnClick buttons
        ivRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void turnOnBluetooth(View v) {
        Toast.makeText(SettingsActivity.this, "Turning on bluetooth", Toast.LENGTH_SHORT).show();

        toggleBluetooth();
    }

    /**
     * Enables/disables bluetooth when pressed
     */
    public void toggleBluetooth() {
        if(bluetoothAdapter == null) {
            Toast.makeText(SettingsActivity.this, "Device cannot use bluetooth.", Toast.LENGTH_LONG).show();
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
}
