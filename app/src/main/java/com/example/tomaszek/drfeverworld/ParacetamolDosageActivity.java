package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ParacetamolDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol_dosage);

        final ImageView imageViewSirop = (ImageView) findViewById(R.id.imageViewSirop);

        imageViewSirop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolDosageActivity.this, ParacetamolConcentration.class);
                ParacetamolDosageActivity.this.startActivity(myIntent);
            }
        });


    }

}
