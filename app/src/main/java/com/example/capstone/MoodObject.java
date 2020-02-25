package com.example.capstone;

public class MoodObject {

    private String moodName;
    private String moodColor;

    public MoodObject(String moodName) {
        this.moodName = moodName;
        this.moodColor = "Dark Blue";
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public String getMoodColor() {
        return moodColor;
    }

    public void setMoodColor(String moodColor) {
        this.moodColor = moodColor;
    }
}
