package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static java.lang.Math.min;

public class IbuprofenDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_dosage);
        final ImageView imageViewSirop = (ImageView) findViewById(R.id.imageViewSirop);
        final ImageView imageViewTabl = (ImageView) findViewById(R.id.imageViewTabl);
        final ImageView imageViewCzop = (ImageView) findViewById(R.id.imageViewCzop);

        imageViewSirop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenDosageActivity.this, IbuprofenConcentration.class);
                IbuprofenDosageActivity.this.startActivity(myIntent);
            }
        });

        imageViewTabl.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenDosageActivity.this, IbuprofenConcentrationPillsActivity.class);
                IbuprofenDosageActivity.this.startActivity(myIntent);
            }
        });

        imageViewCzop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenDosageActivity.this, IbuprofenCalculationSuppActivity.class);
                IbuprofenDosageActivity.this.startActivity(myIntent);
            }
        });


        final Button buttonIbuprofenDosage = (Button) findViewById(R.id.buttonIbuprofenDosage);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        int age = pref.getInt("age", 50); // getting Integer
        int weight = pref.getInt("weight", 50); // getting Integer
        int totalDosage = 10 * weight;


        if (age <= 9 || weight <= 29) {
            totalDosage = min(totalDosage, 600);
        }
        if ((age > 9 && age < 12) || (weight > 29 && weight < 39)) {
            totalDosage = min(totalDosage, 800);
        }

        if (age > 12 || weight >= 39) {
            totalDosage = min(totalDosage, 1200);
        }


        String dosageText = String.valueOf(totalDosage / 4) + " mg every 6h\n or\n" + String.valueOf(totalDosage / 6) + " mg every 4h";
        if (age < 7) {
            dosageText = String.valueOf(totalDosage / 4) + " mg every 6h\n or\n" + String.valueOf(totalDosage / 6) + " mg every 4h";
        } else if (age >= 7 && age <= 12) {
            dosageText = String.valueOf(totalDosage / 3) + " mg every 8h\n or\n" + String.valueOf(totalDosage / 4) + " mg every 6h";
        } else if (age > 12) {
            dosageText = String.valueOf(totalDosage / 2) + " mg every 12h\n or\n" + String.valueOf(totalDosage / 4) + " mg every 6h";
        }
        buttonIbuprofenDosage.setText(dosageText);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("IbuprofenTotal", Integer.valueOf(totalDosage));
        editor.commit();
    }
}
