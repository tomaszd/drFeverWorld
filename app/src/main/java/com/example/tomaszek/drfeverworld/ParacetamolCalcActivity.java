package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ParacetamolCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol_calc);

        int age = 0;
        int weight = 0;
        int Mg = 0;
        int Ml = 0;
        int ParacMgSupp = 0;
        int ParacMgPill = 0;
        int ParacetamolTotal = 0;

        final TextView text_view_id = (TextView) findViewById(R.id.text_view_id);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 0); // getting Integer
        weight = pref.getInt("weight", 0); // getting Integer
        Mg = pref.getInt("Mg", 0); // getting Integer
        Ml = pref.getInt("Ml", 0); // getting Integer
        ParacMgSupp = pref.getInt("ParacMgSupp", 0); // getting Integer
        ParacMgPill = pref.getInt("ParacMgPill", 0); // getting Integer
        ParacetamolTotal = pref.getInt("ParacetamolTotal", 0); // getting Integer

        Intent intent = getIntent();

        String paracetamol_way_of_giving = intent.getStringExtra("paracetamol_way_of_giving");

        //"  GIVE xxx ml 6a day\n                or\n    give e them or 4 days "

        if (paracetamol_way_of_giving.equals("pills")) {

            String dosageText = String.valueOf((ParacetamolTotal / 4) / ParacMgPill) + " pill every 6h\n or\n" + String.valueOf((ParacetamolTotal / 6) / ParacMgPill) + "pill every 4h";
            if (age < 7) {
                dosageText = String.valueOf((ParacetamolTotal / 4) / ParacMgPill) + " pill every 6h\n or\n" + String.valueOf((ParacetamolTotal / 6) / ParacMgPill) + " pill every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = String.valueOf((ParacetamolTotal / 3) / ParacMgPill) + " pill every 8h\n or\n" + String.valueOf((ParacetamolTotal / 4) / ParacMgPill) + " pill every 6h";
            } else if (age > 12) {
                dosageText = String.valueOf((ParacetamolTotal / 2) / ParacMgPill) + " pill every 12h\n or\n" + String.valueOf((ParacetamolTotal / 4) / ParacMgPill) + " pill every 6h";
            }
            text_view_id.setText(dosageText);
        }
        if (paracetamol_way_of_giving.equals("supp")) {
            String dosageText = String.valueOf((ParacetamolTotal / 4) / ParacMgSupp) + " supp every 6h\n or\n" + String.valueOf((ParacetamolTotal / 6) / ParacMgSupp) + "supp every 4h";
            if (age < 7) {
                dosageText = String.valueOf((ParacetamolTotal / 4) / ParacMgSupp) + " supp every 6h\n or\n" + String.valueOf((ParacetamolTotal / 6) / ParacMgSupp) + " supp every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = String.valueOf((ParacetamolTotal / 3) / ParacMgSupp) + " supp every 8h\n or\n" + String.valueOf((ParacetamolTotal / 4) / ParacMgSupp) + " supp every 6h";
            } else if (age > 12) {
                dosageText = String.valueOf((ParacetamolTotal / 2) / ParacMgSupp) + " supp every 12h\n or\n" + String.valueOf((ParacetamolTotal / 4) / ParacMgSupp) + " supp every 6h";
            }
            text_view_id.setText(dosageText);
        }

        //@todo syrup


        //"  GIVE xxx ml 6a day\n                or\n    give e them or 4 days "

    }
}
