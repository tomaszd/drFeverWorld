package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        final ImageView imageViewHome = (ImageView) findViewById(R.id.imageViewHome);
        final TextView text_view_total = (TextView) findViewById(R.id.text_view_total);
        final TextView text_view_info = (TextView) findViewById(R.id.text_view_info);

        imageViewHome.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolCalcActivity.this, MainActivity.class);
                ParacetamolCalcActivity.this.startActivity(myIntent);
            }
        });

        final ImageView imageViewInfo = (ImageView) findViewById(R.id.imageViewInfo);
        imageViewInfo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolCalcActivity.this, InformationActivity.class);
                ParacetamolCalcActivity.this.startActivity(myIntent);
            }
        });

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 0); // getting Integer
        weight = pref.getInt("weight", 0); // getting Integer
        ParacMg = pref.getInt("ParacMg", 100); // getting Integer
        ParacMl = pref.getInt("ParacMl", 100); // getting Integer
        ParacMgSupp = pref.getInt("ParacMgSupp", 100); // getting Integer
        ParacMgPill = pref.getInt("ParacMgPill", 100); // getting Integer
        ParacetamolTotal = pref.getInt("ParacetamolTotal", 0); // getting Integer

        Intent intent = getIntent();


        text_view_total.setText(getString(R.string.suggested_summary_daily_dose) + " " + String.valueOf(ParacetamolTotal) + " mg");

        String paracetamol_way_of_giving = intent.getStringExtra("paracetamol_way_of_giving");
        if (paracetamol_way_of_giving == null) {
            paracetamol_way_of_giving = "syrup";

        }
        if (paracetamol_way_of_giving.equals("pills")) {
            String dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + "  4h";
            if (age < 7) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 4h";
            } else if (age > 12) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 4h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.single_dose_paracetamol);
        }
        if (paracetamol_way_of_giving.equals("supp")) {
            String dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 4h";
            if (age < 7) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 4h";
            } else if (age > 12) {
                dosageText = getStringDosage(ParacetamolTotal, 4, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(ParacetamolTotal, 6, ParacMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 4h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.single_dose_paracetamol);
        }

        if (paracetamol_way_of_giving.equals("syrup")) {
            String dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + "ml " + getString(R.string.every) + " 4h";
            if (age < 7) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 4h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 4h";
            } else if (age > 12) {
                dosageText = getStringDosageSyrup(ParacetamolTotal, 4, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(ParacetamolTotal, 6, ParacMg, ParacMl) + " ml " + getString(R.string.every) + " 4h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.single_dose_paracetamol);
        }

    }

    private String getStringDosage(int paracetamolTotal, int amount_in_day, int dosageOInOneItem) {
        return String.format("%.01f", (((float) paracetamolTotal) / ((float) amount_in_day)) / (float) dosageOInOneItem);
    }

    private String getStringDosageSyrup(int paracetamolTotal, int amount_in_day, int dosageMg, int dosageMl) {
        return String.format("%.01f", (((float) paracetamolTotal) * (float) dosageMl / ((float) amount_in_day)) / (float) dosageMg);
    }
}
