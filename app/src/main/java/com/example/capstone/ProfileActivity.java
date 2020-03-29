package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class ProfileActivity extends AppCompatActivity {

    EditText et_name, et_iCal;
    Button btnSend, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Linking variables to their respective id
        et_name = findViewById(R.id.et_name);
        et_iCal = findViewById(R.id.et_iCal);
        btnSend = findViewById(R.id.btnSend);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void sendProfileInfo(View V) throws InterruptedException {
        // Get provided Name from text fields
        String name = et_name.getText().toString();
        String iCal = et_iCal.getText().toString();

        // Confirm that user has provided their full name
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, "Please provide your name.", Toast.LENGTH_SHORT).show();
        } else {
            // Properly capitalize the provided name
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

            // Confirm that the profile has been created
            String confirmationMsg = String.format("Thank you %s, your profile has been submitted successfully to the Mirror! Please Stand infront of the Mirror.", name);

            sleepFunc(1);  // Sleep
            Toast.makeText(this, confirmationMsg , Toast.LENGTH_LONG).show();

            finish();
        }
    }

    /**
     * Returns user to the main activity
     */
    public void cancelProfile(View v) { finish(); }

    /**
     * Sleeps for x seconds
     * @param x is the time in seconds to sleep
     * @throws InterruptedException
     */
    public void sleepFunc(int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
}
