package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IbuprofenDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_dosage);
        final ImageView imageViewSirop = (ImageView) findViewById(R.id.imageViewSirop);

        imageViewSirop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenDosageActivity.this, IbuprofenConcentration.class);
                IbuprofenDosageActivity.this.startActivity(myIntent);
            }
        });

        final Button buttonParacetamolDosage = (Button) findViewById(R.id.buttonParacetamolDosage);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        int age = pref.getInt("age", 50); // getting Integer
        int weight = pref.getInt("weight", 50); // getting Integer
        int totalDosage = 10 * weight;

        //dorosli -> 2/4 razy na dobe;
        //7-12 - 3, 4 razy na dobre
        //ponizej 7 -> co 4 , 6  @Todo dobre dawkowanie!!!!

        String dosageText = String.valueOf(totalDosage / 4) + " mg every 6h\n or\n" + String.valueOf(totalDosage / 6) + " mg every 4h";
        if (age < 7) {
            dosageText = String.valueOf(totalDosage / 4) + " mg every 6h\n or\n" + String.valueOf(totalDosage / 6) + " mg every 4h";
        } else if (age >= 7 && age <= 12) {
            dosageText = String.valueOf(totalDosage / 3) + " mg every 8h\n or\n" + String.valueOf(totalDosage / 4) + " mg every 6h";
        } else if (age > 12) {
            dosageText = String.valueOf(totalDosage / 2) + " mg every 12h\n or\n" + String.valueOf(totalDosage / 4) + " mg every 6h";
        }
        buttonParacetamolDosage.setText(dosageText);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("IbuprofenTotal", Integer.valueOf(totalDosage));
        editor.commit();
    }
}
