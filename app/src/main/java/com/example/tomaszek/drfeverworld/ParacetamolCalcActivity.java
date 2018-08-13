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
        int ParacMg = 0;
        int ParacMl = 0;
        int ParacMgSupp = 0;
        int ParacMgPill = 0;
        int ParacetamolTotal = 0;

        final TextView text_view_id = (TextView) findViewById(R.id.text_view_id);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 0); // getting Integer
        weight = pref.getInt("weight", 0); // getting Integer
        ParacMg = pref.getInt("ParacMg", 0); // getting Integer
        ParacMl = pref.getInt("ParacMl", 0); // getting Integer
        ParacMgSupp = pref.getInt("ParacMgSupp", 0); // getting Integer
        ParacMgPill = pref.getInt("ParacMgPill", 0); // getting Integer
        ParacetamolTotal = pref.getInt("ParacetamolTotal", 0); // getting Integer

        Intent intent = getIntent();

        String paracetamol_way_of_giving = intent.getStringExtra("paracetamol_way_of_giving");

        //"  GIVE xxx ml 6a day\n                or\n    give e them or 4 days "

        if (paracetamol_way_of_giving.equals("pills")) {
            String dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " pill every 6h\n or\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + "pill every 4h";
            if (age < 7) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " pill every 6h\n or\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + " pill every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(ParacetamolTotal, 3, ParacMgPill) + " pill every 8h\n or\n" + getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " pill every 6h";
            } else if (age > 12) {
                dosageText = getStringDosage(ParacetamolTotal, 2, ParacMgPill) + " pill every 12h\n or\n" + getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " pill every 6h";
            }
            text_view_id.setText(dosageText);
        }
        if (paracetamol_way_of_giving.equals("supp")) {
            String dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " supp every 6h\n or\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + "supp every 4h";
            if (age < 7) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " supp every 6h\n or\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + " supp every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(ParacetamolTotal, 3, ParacMgSupp) + " supp every 8h\n or\n" + getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " supp every 6h";
            } else if (age > 12) {
                dosageText = getStringDosage(ParacetamolTotal, 2, ParacMgSupp) + " supp every 12h\n or\n" + getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " supp every 6h";
            }
            text_view_id.setText(dosageText);
        }

        if (paracetamol_way_of_giving.equals("syrup")) {
            String dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml every 6h\n or\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + "ml every 4h";
            if (age < 7) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml every 6h\n or\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + " ml every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 3, ParacMg, ParacMl) + " ml every 8h\n or\n" + getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml every 6h";
            } else if (age > 12) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 2, ParacMg, ParacMl) + " ml every 12h\n or\n" + getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml every 6h";
            }
            text_view_id.setText(dosageText);
        }

    }

    private String getStringDosage(int paracetamolTotal, int amount_in_day, int dosageOInOneItem) {
        return String.format("%.01f", (((float) paracetamolTotal) / ((float) amount_in_day)) / (float) dosageOInOneItem);
    }

    private String getStringDosageSyrup(int paracetamolTotal, int amount_in_day, int dosageMg, int dosageMl) {
        return String.format("%.01f", (((float) paracetamolTotal) * (float) dosageMl / ((float) amount_in_day)) / (float) dosageMg);
    }
}
