package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class IbuprofenActivity extends AppCompatActivity {
    int age = 0;
    int weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen);

        final SeekBar seekBarWaga = (SeekBar) findViewById(R.id.seekBarWaga);
        final SeekBar seekBarWiek = (SeekBar) findViewById(R.id.seekBarWiek);

        final TextView textViewWiek = (TextView) findViewById(R.id.textViewWiek);
        final TextView textViewWaga = (TextView) findViewById(R.id.textViewWaga);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 50); // getting Integer
        weight = pref.getInt("weight", 50); // getting Integer
        seekBarWaga.setProgress(weight);
        seekBarWiek.setProgress(age);


        seekBarWaga.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                weight = progresValue;
                textViewWaga.setText(progress + "\nkg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewWaga.setText(progress + "\nkg");
            }

        });
        seekBarWiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                age = progresValue;
                textViewWiek.setText(progress + "\nyears");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewWiek.setText(progress + "\nyears");
            }
        });

        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenActivity.this, IbuprofenDosageActivity.class);
                myIntent.putExtra("age", age);
                myIntent.putExtra("weight", weight);

                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("age", age);
                editor.putInt("weight", weight);
                editor.commit();


                IbuprofenActivity.this.startActivity(myIntent);
            }
        });

    }

}
