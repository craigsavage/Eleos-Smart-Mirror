package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Moods extends AppCompatActivity {

    ArrayList<MoodObject> moodList;
    MoodAdapter moodAdapter;
    SwipeRefreshLayout srMoodListRefresh;
    ListView lvMoodList;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        lvMoodList = findViewById(R.id.lvMoodList);
        srMoodListRefresh = findViewById(R.id.srMoodListRefresh);
        btnHome = findViewById(R.id.btnHome);

        moodList = new ArrayList<>();

        // Create Mood objects
        MoodObject happyMood = new MoodObject("Happy");
        MoodObject surprisedMood = new MoodObject("Surprised");
        MoodObject neutralMood = new MoodObject("Neutral");
        MoodObject sadMood = new MoodObject("Sad");
        MoodObject angryMood = new MoodObject("Angry");
        MoodObject disgustedMood = new MoodObject("Disgusted");

        // Add objects to the array list
        moodList.add(happyMood);
        moodList.add(surprisedMood);
        moodList.add(neutralMood);
        moodList.add(sadMood);
        moodList.add(angryMood);
        moodList.add(disgustedMood);

        // Populate list with moods
        moodAdapter = new MoodAdapter(this, moodList);
        lvMoodList.setAdapter(moodAdapter);

//        ivEcstaticMood = findViewById(R.id.ivEcstaticMood);
//        ivHappyMood = findViewById(R.id.ivHappyMood);
//        ivNeutralMood = findViewById(R.id.ivNeutralMood);
//        ivSadMood = findViewById(R.id.ivSadMood);
//        ivAngryMood = findViewById(R.id.ivAngryMood);
//        ivSurprisedMood = findViewById(R.id.ivSurprisedMood);
//
//        // Assign colours to the default brand colour
//        ivEcstaticMood.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
//        ivHappyMood.setColorFilter(Color.argb(255, 230, 75, 75));
//        ivNeutralMood.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
//        ivSadMood.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
//        ivAngryMood.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
//        ivSurprisedMood.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
    }

    public void goHome(View v) {
        Intent intent = new Intent(Moods.this, MainActivity.class);
        startActivity(intent);
    }
}
