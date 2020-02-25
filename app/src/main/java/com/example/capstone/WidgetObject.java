package com.example.capstone;

public class WidgetObject {

    private String widgetName;
    private String widgetLocation;

    public WidgetObject(String widgetName) {
        this.widgetName = widgetName;
        this.widgetLocation = "Location: Not assigned";
    }

    public String getWidgetName() {
        return widgetName;
    }

    public String getWidgetLocation() {
        return widgetLocation;
    }

    public void setWidgetLocation(String widgetLocation) {
        this.widgetLocation = widgetLocation;
    }

}
