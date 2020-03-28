package com.example.capstone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class WidgetLocationLayout extends AppCompatDialogFragment {

    Button btnTopBar;
    Button btnTopLeft;
    Button btnTopCenter;
    Button btnTopRight;
    Button btnUpperThird;
    Button btnMiddleCenter;
    Button btnLowerThird;
    Button btnBottomLeft;
    Button btnBottomCenter;
    Button btnBottomRight;
    Button btnBottomBar;

    private String location = "";
    private int position;
    private WidgetLocationLayoutListener listener;

    /**
     * Gets the position of the newly created constructed object
     * @param position list position of the selected item
     */
    public WidgetLocationLayout(int position) {
        this.position = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_widget_location, null);

        builder.setView(view)
//                .setTitle("Select A Location")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Dismisses the dialog
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Gets selected location
                        if (location.isEmpty()) {
                            Toast.makeText(getContext(), "Select a location", Toast.LENGTH_LONG).show();
                        } else {
                            // Send the selected location with the position of the selected list item
                            listener.applyLocations(position, location);
                        }
                    }
                });

        // Link variables to the buttons
        btnTopBar = view.findViewById(R.id.btnTopBar);
        btnTopLeft = view.findViewById(R.id.btnTopLeft);
        btnTopCenter = view.findViewById(R.id.btnTopCenter);
        btnTopRight = view.findViewById(R.id.btnTopRight);
        btnUpperThird = view.findViewById(R.id.btnUpperThird);
        btnMiddleCenter = view.findViewById(R.id.btnMiddleCenter);
        btnLowerThird = view.findViewById(R.id.btnLowerThird);
        btnBottomLeft = view.findViewById(R.id.btnBottomLeft);
        btnBottomCenter = view.findViewById(R.id.btnBottomCenter);
        btnBottomRight = view.findViewById(R.id.btnBottomRight);
        btnBottomBar = view.findViewById(R.id.btnBottomBar);

        // Assigns the clicked location to the "location" variable
        btnTopBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Top Bar clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Top Bar";
                colorButtons(btnTopBar);   // Highlight button
            }
        });
        btnTopLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Top Left clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Top Left";
                colorButtons(btnTopLeft);   // Highlight button
            }
        });
        btnTopCenter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Top Center clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Top Center";
                colorButtons(btnTopCenter);   // Highlight button
            }
        });
        btnTopRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Top Right clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Top Right";
                colorButtons(btnTopRight);   // Highlight button
            }
        });
        btnUpperThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Upper Third clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Upper Third";
                colorButtons(btnUpperThird);   // Highlight button
            }
        });
        btnMiddleCenter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Middle Center clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Middle Center";
                colorButtons(btnMiddleCenter);   // Highlight button
            }
        });
        btnLowerThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Lower Third clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Lower Third";
                colorButtons(btnLowerThird);   // Highlight button
            }
        });
        btnBottomLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Bottom Left clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Bottom Left";
                colorButtons(btnBottomLeft);   // Highlight button
            }
        });
        btnBottomCenter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Bottom Center clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Bottom Center";
                colorButtons(btnBottomCenter);   // Highlight button
            }
        });
        btnBottomRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Bottom Right clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Bottom Right";
                colorButtons(btnBottomRight);   // Highlight button
            }
        });
        btnBottomBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getContext(), "Bottom Bar clicked", Toast.LENGTH_SHORT).show();
                location = "Location: Bottom Bar";
                colorButtons(btnBottomBar);   // Highlight button
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (WidgetLocationLayoutListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement WidgetLocationLayoutListener");
        }
    }

    public interface WidgetLocationLayoutListener {
        void applyLocations(int position, String location);
    }

    /**
     * Highlights the selected button blue and removes highlight from previously selected button
     * @param button The selected button
     */
    public void colorButtons(Button button) {
        // Restores each button to it's unselected look
        btnTopBar.setBackgroundResource(R.drawable.unselected_button);
        btnTopLeft.setBackgroundResource(R.drawable.unselected_button);
        btnTopCenter.setBackgroundResource(R.drawable.unselected_button);
        btnTopRight.setBackgroundResource(R.drawable.unselected_button);
        btnUpperThird.setBackgroundResource(R.drawable.unselected_button);
        btnMiddleCenter.setBackgroundResource(R.drawable.unselected_button);
        btnLowerThird.setBackgroundResource(R.drawable.unselected_button);
        btnBottomLeft.setBackgroundResource(R.drawable.unselected_button);
        btnBottomCenter.setBackgroundResource(R.drawable.unselected_button);
        btnBottomRight.setBackgroundResource(R.drawable.unselected_button);
        btnBottomBar.setBackgroundResource(R.drawable.unselected_button);

        // Make the select colour blue
        button.setBackgroundResource(R.drawable.selected_button);
    }
}
