package com.example.tomaszek.drfeverworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class ParacetamolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol);

        final SeekBar seekBarWaga = (SeekBar) findViewById(R.id.seekBarWaga);
        final SeekBar seekBarWiek = (SeekBar) findViewById(R.id.seekBarWiek);

        final TextView textViewWiek = (TextView) findViewById(R.id.textViewWiek);
        final TextView textViewWaga = (TextView) findViewById(R.id.textViewWaga);


        seekBarWaga.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
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

    }
}

