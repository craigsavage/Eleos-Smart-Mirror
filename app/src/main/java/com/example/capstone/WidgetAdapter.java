package com.example.capstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WidgetAdapter extends ArrayAdapter<WidgetObject> {

    private final Context context;
    private final ArrayList<WidgetObject> mirrorWidgets;

    public WidgetAdapter(@NonNull Context context, ArrayList<WidgetObject> mirrorWidgets) {
        super(context, R.layout.layout_widgets, mirrorWidgets);
        this.context = context;
        this.mirrorWidgets = mirrorWidgets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Link to layout_widget activity
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View widgetRows = inflater.inflate(R.layout.layout_widgets, parent, false);

        TextView tvWidgetName = (TextView) widgetRows.findViewById(R.id.tvWidgetName);
        TextView tvWidgetLocation = (TextView) widgetRows.findViewById(R.id.tvWidgetLocation);

        tvWidgetName.setText(mirrorWidgets.get(position).getWidgetName());
        tvWidgetLocation.setText(mirrorWidgets.get(position).getWidgetLocation());

        return widgetRows;
    }
}
