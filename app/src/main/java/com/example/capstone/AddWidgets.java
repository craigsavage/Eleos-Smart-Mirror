package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AddWidgets extends AppCompatActivity implements WidgetLocationLayout.WidgetLocationLayoutListener {

    ListView lvAddItems;
    WidgetAdapter mirrorItemsAdapter;
    SwipeRefreshLayout widgetListRefresh;
    ArrayList<WidgetObject> mirrorWidgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_widgets);

        lvAddItems = findViewById(R.id.lvAddItems);
        widgetListRefresh = findViewById(R.id.srWidgetRefresh);

        mirrorWidgets = new ArrayList<>();

        // Create widget objects
        WidgetObject clockWidget = new WidgetObject("Clock");
        WidgetObject calendarWidget = new WidgetObject("Calendar");
        WidgetObject currentWeatherWidget = new WidgetObject("Current Weather");
        WidgetObject WeatherForecastWidget = new WidgetObject("Weather Forecast");
        WidgetObject NewsFeedWidget = new WidgetObject("News Feed");
        WidgetObject ComplimentsWidget = new WidgetObject("Compliments");

        // Add objects to the array list
        mirrorWidgets.add(clockWidget);
        mirrorWidgets.add(calendarWidget);
        mirrorWidgets.add(currentWeatherWidget);
        mirrorWidgets.add(WeatherForecastWidget);
        mirrorWidgets.add(NewsFeedWidget);
        mirrorWidgets.add(ComplimentsWidget);

        // Populate list with mirror items
        mirrorItemsAdapter = new WidgetAdapter(this, mirrorWidgets);
        lvAddItems.setAdapter(mirrorItemsAdapter);

        widgetListRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mirrorItemsAdapter = new WidgetAdapter(AddWidgets.this, mirrorWidgets);
                lvAddItems.setAdapter(mirrorItemsAdapter);
                widgetListRefresh.setRefreshing(false);
            }
        });

        lvAddItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(AddWidgets.this,"You clicked: " + mirrorWidgets.get(position).getWidgetName() + "!!", Toast.LENGTH_SHORT).show();
                openDialog(position);
                lvAddItems.setAdapter(mirrorItemsAdapter);
            }
        });
    }

    public void openDialog(int position) {
        // Creates a new instance of the widgetLocationLayout object
        WidgetLocationLayout widgetLocationLayout = new WidgetLocationLayout(position);
        widgetLocationLayout.show(getSupportFragmentManager(), "widget locations");
    }

    @Override
    public void applyLocations(int position, String location) {
        // Set location to object position
        mirrorWidgets.get(position).setWidgetLocation(location);
        mirrorItemsAdapter.notifyDataSetChanged();  // Updates list view
        // Toast.makeText(AddWidgets.this, "Position clicked: " + position + "\nLocation: " + location, Toast.LENGTH_LONG).show();
    }

    /**
     * Sends info to smart mirror
     */
    public void sendLocations(View v) throws InterruptedException {
        sleepFunc(1);  // Sleep
        Toast.makeText(AddWidgets.this, "Data received!", Toast.LENGTH_LONG).show();

        finish();
    }

    /**
     * Returns user to the main activity
     */
    public void goHome(View v) {
        finish();
    }

    /**
     * Sleeps for x seconds
     * @param x is the time in seconds to sleep
     * @throws InterruptedException
     */
    public void sleepFunc(int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
}
