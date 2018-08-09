package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.tomaszek.drfeverworld.R.drawable.age;

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
                IbuprofenActivity.this.startActivity(myIntent);
            }
        });

    }

}
