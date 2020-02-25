package com.example.capstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MoodAdapter extends ArrayAdapter<MoodObject> {

    private final Context context;
    private final ArrayList<MoodObject> moodList;

    public MoodAdapter(@NonNull Context context, ArrayList<MoodObject> moodList) {
        super(context, R.layout.layout_mood_rows, moodList);
        this.context = context;
        this.moodList = moodList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Link to layout_mood_row activity
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View moodRows = inflater.inflate(R.layout.layout_mood_rows, parent, false);

        TextView tvMood = moodRows.findViewById(R.id.tvMood);
        TextView tvMoodColour = moodRows.findViewById(R.id.tvMoodColour);
        ImageView ivMood = moodRows.findViewById(R.id.ivMood);

        tvMood.setText("Mood: " + moodList.get(position).getMoodName());
        tvMoodColour.setText("Colour: " + moodList.get(position).getMoodColor());

        if (moodList.get(position).getMoodName().equalsIgnoreCase("Happy")) {
            ivMood.setImageResource(R.drawable.mood_happy);
        } else if (moodList.get(position).getMoodName().equalsIgnoreCase("Surprised")) {
            ivMood.setImageResource(R.drawable.mood_surprised);
        } else if (moodList.get(position).getMoodName().equalsIgnoreCase("Neutral")) {
            ivMood.setImageResource(R.drawable.mood_neutral);
        } else if (moodList.get(position).getMoodName().equalsIgnoreCase("Sad")) {
            ivMood.setImageResource(R.drawable.mood_sad);
        } else if (moodList.get(position).getMoodName().equalsIgnoreCase("Angry")) {
            ivMood.setImageResource(R.drawable.mood_angry);
        } else if (moodList.get(position).getMoodName().equalsIgnoreCase("Disgusted")) {
            ivMood.setImageResource(R.drawable.mood_ecstatic);
        }

        ivMood.setColorFilter(context.getResources().getColor(R.color.colorPrimaryDark));

        return moodRows;
    }
}
