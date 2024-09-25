package com.example.colorpickerwithslider;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private TextView textViewRed;
    private TextView textViewGreen;
    private TextView textviewBlue;
    private FrameLayout displayArea;
    private TextView displayColor;

    private int red_value = 0;
    private int green_value = 0;
    private int blue_value = 0;
    private String color = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();



        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red_value = i;
                textViewRed.setText("Red: " + red_value);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                green_value = i;
                textViewGreen.setText("Green: " + green_value);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blue_value = i;
                textviewBlue.setText("Blue: " + blue_value);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void updateColor(){
        displayArea.setBackgroundColor(Color.rgb(red_value, green_value, blue_value));
        color = "(" + red_value + ", " + green_value + ", " + blue_value + ")";
        displayColor.setText(color);
        if (red_value + green_value + blue_value < 200) {
            displayColor.setTextColor(Color.WHITE);
        }
        else {
            displayColor.setTextColor(Color.BLACK);
        }
    }

    public void init(){
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);
        textViewRed = findViewById(R.id.textViewRed);
        textViewGreen = findViewById(R.id.textViewGreen);
        textviewBlue = findViewById(R.id.textViewBlue);
        displayArea = findViewById(R.id.displayArea);
        displayColor = findViewById(R.id.displayColor);

    }
}