package pl.doktornutria.tomaszek.drfeverworld;

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
        final TextView text_view_total = (TextView) findViewById(R.id.text_view_total);
        final TextView text_view_info = (TextView) findViewById(R.id.text_view_info);

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


        text_view_total.setText(getString(R.string.suggested_summary_daily_dose) + " " + String.valueOf(IbuprofenTotal) + " mg");


        String ibuprofen_way_of_giving = intent.getStringExtra("ibuprofen_way_of_giving");
        if (ibuprofen_way_of_giving == null) {
            ibuprofen_way_of_giving = "syrup";
        }
        if (ibuprofen_way_of_giving.equals("pills")) {
            String dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 8h";
            if (age < 7) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 8h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 8h";
            } else if (age > 12) {
                dosageText = getStringDosage(IbuprofenTotal, 3, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 8h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgPill) + " " + getString(R.string.pill) + " " + getString(R.string.every) + " 6h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.your_suggester_single_dose_ibuprofen);
        }
        if (ibuprofen_way_of_giving.equals("supp")) {
            String dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 8h";
            if (age < 7) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 8h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 3, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 8h";
            } else if (age > 12) {
                dosageText = getStringDosage(IbuprofenTotal, 3, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 8h\n          "+ getString(R.string.or) +"\n" + getStringDosage(IbuprofenTotal, 4, IbuprofenMgSupp) + " " + getString(R.string.supp) + " " + getString(R.string.every) + " 6h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.your_suggester_single_dose_ibuprofen);
        }

        if (ibuprofen_way_of_giving.equals("syrup")) {
            String dosageText = getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(IbuprofenTotal, 3, IbupMg, IbupMl) + "ml " + getString(R.string.every) + " 8h";
            if (age < 7) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 6h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(IbuprofenTotal, 3, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 8h";
            } else if (age >= 7 && age <= 12) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 68h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(IbuprofenTotal, 3, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 8h";
            } else if (age > 12) {
                dosageText = getStringDosageSyrup(IbuprofenTotal, 3, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 8h\n          "+ getString(R.string.or) +"\n" + getStringDosageSyrup(IbuprofenTotal, 4, IbupMg, IbupMl) + " ml " + getString(R.string.every) + " 6h";
            }
            text_view_id.setText(dosageText);
            text_view_info.setText(R.string.your_suggester_single_dose_ibuprofen);
        }

    }

    private String getStringDosage(int IbuprofenTotal, int amount_in_day, int dosageOInOneItem) {
        return String.format("%.01f", (((float) IbuprofenTotal) / ((float) amount_in_day)) / (float) dosageOInOneItem);
    }

    private String getStringDosageSyrup(int IbuprofenTotal, int amount_in_day, int dosageMg, int dosageMl) {
        return String.format("%.01f", (((float) IbuprofenTotal) * (float) dosageMl / ((float) amount_in_day)) / (float) dosageMg);
    }

}
