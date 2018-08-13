package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IbuprofenCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_calc);


        int age = 0;
        int weight = 0;
        int IbupMg = 0;
        int IbupMl = 0;
        int IbuprofenMgSupp = 0;
        int IbuprofenMgPill = 0;
        int IbuprofenTotal = 0;


        final TextView text_view_id = (TextView) findViewById(R.id.text_view_id);

        final ImageView imageViewHome = (ImageView) findViewById(R.id.imageViewHome);
        imageViewHome.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenCalcActivity.this, MainActivity.class);
                IbuprofenCalcActivity.this.startActivity(myIntent);
            }
        });

        final ImageView imageViewInfo = (ImageView) findViewById(R.id.imageViewInfo);
        imageViewInfo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenCalcActivity.this, InformationActivity.class);
                IbuprofenCalcActivity.this.startActivity(myIntent);
            }
        });


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 0); // getting Integer
        weight = pref.getInt("weight", 0); // getting Integer
        IbupMg = pref.getInt("IbupMg", 100); // getting Integer
        IbupMl = pref.getInt("IbupMl", 100); // getting Integer
        IbuprofenMgSupp = pref.getInt("IbuprofenMgSupp", 100); // getting Integer
        IbuprofenMgPill = pref.getInt("IbuprofenMgPill", 100); // getting Integer
        IbuprofenTotal = pref.getInt("IbuprofenTotal", 0); // getting Integer

        Intent intent = getIntent();

        String ibuprofen_way_of_giving = intent.getStringExtra("ibuprofen_way_of_giving");

        if (ibuprofen_way_of_giving.equals("pills")) {
            String dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " pill every 6h\n          or\n" + getStringDosage(IbuprofenTotal, 6, IbuprofenMgPill) + "pill every 4h";
            if (age < 7) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " pill every 6h\n          or\n" + getStringDosage(IbuprofenTotal, 6, IbuprofenMgPill) + " pill every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(IbuprofenTotal, 3, IbuprofenMgPill) + " pill every 8h\n          or\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " pill every 6h";
            } else if (age > 12) {
                dosageText = getStringDosage(IbuprofenTotal, 2, IbuprofenMgPill) + " pill every 12h\n          or\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " pill every 6h";
            }
            text_view_id.setText(dosageText);
        }
        if (ibuprofen_way_of_giving.equals("supp")) {
            String dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " supp every 6h\n          or\n" + getStringDosage(IbuprofenTotal, 6, IbuprofenMgSupp) + "supp every 4h";
            if (age < 7) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " supp every 6h\n          or\n" + getStringDosage(IbuprofenTotal, 6, IbuprofenMgSupp) + " supp every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(IbuprofenTotal, 3, IbuprofenMgSupp) + " supp every 8h\n          or\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " supp every 6h";
            } else if (age > 12) {
                dosageText = getStringDosage(IbuprofenTotal, 2, IbuprofenMgSupp) + " supp every 12h\n          or\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " supp every 6h";
            }
            text_view_id.setText(dosageText);
        }

        if (ibuprofen_way_of_giving.equals("syrup")) {
            String dosageText = getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml every 6h\n          or\n" + getStringDosageSyrup(IbuprofenTotal, 6, IbupMg, IbupMl) + "ml every 4h";
            if (age < 7) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml every 6h\n          or\n" + getStringDosageSyrup(IbuprofenTotal, 6, IbupMg, IbupMl) + " ml every 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 3, IbupMg, IbupMl) + " ml every 8h\n          or\n" + getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml every 6h";
            } else if (age > 12) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 2, IbupMg, IbupMl) + " ml every 12h\n          or\n" + getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml every 6h";
            }
            text_view_id.setText(dosageText);
        }

    }

    private String getStringDosage(int IbuprofenTotal, int amount_in_day, int dosageOInOneItem) {
        return String.format("%.01f", (((float) IbuprofenTotal) / ((float) amount_in_day)) / (float) dosageOInOneItem);
    }

    private String getStringDosageSyrup(int IbuprofenTotal, int amount_in_day, int dosageMg, int dosageMl) {
        return String.format("%.01f", (((float) IbuprofenTotal) * (float) dosageMl / ((float) amount_in_day)) / (float) dosageMg);
    }

}
