package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static java.lang.Math.min;

public class ParacetamolDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol_dosage);

        final ImageView imageViewSirop = (ImageView) findViewById(R.id.imageViewSirop);
        final ImageView imageViewCzop = (ImageView) findViewById(R.id.imageViewCzop);
        final ImageView imageViewTabl = (ImageView) findViewById(R.id.imageViewTabl);

        imageViewCzop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolDosageActivity.this, ParacetamolConcentrationSuppActivity.class);
                ParacetamolDosageActivity.this.startActivity(myIntent);
            }
        });

        imageViewSirop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolDosageActivity.this, ParacetamolConcentration.class);
                ParacetamolDosageActivity.this.startActivity(myIntent);
            }
        });
        imageViewTabl.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolDosageActivity.this, ParacetamolConcentrationPillsActivity.class);
                ParacetamolDosageActivity.this.startActivity(myIntent);
            }
        });


        final Button buttonParacetamolDosage = (Button) findViewById(R.id.buttonParacetamolDosage);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        int age = pref.getInt("age", 50); // getting Integer
        int weight = pref.getInt("weight", 50); // getting Integer

        /**
         * Dawkowanie:

         Doustnie. Dorośli: 1-2 tabletki 2-4 razy na dobę, nie częściej niż co 4 godziny
         (maksymalna dawka dobowa w leczeniu doraźnym wynosi 4 g, w leczeniu długotrwałym 2,6 g).
         Dzieci: dawkę leku ustala się w zależności od wieku i masy ciała dziecka, zazwyczaj
         10-15 mg/kg masy ciała. Dzieci 7-12 rok życia: 1/2 tabletki co 6-8 godzin.
         Należy zasięgnąć opinii lekarza jeśli ból utrzymuje się dłużej niż 10 dni,
         a gorączka dłużej niż 3 dni.   W czasie stosowania leku nie należy pić alkoholu.
         Zapoznaj się z właściwościami leku opisanymi w ulotce przed jego zastosowaniem.
         Przed zastosowaniem leku należy sprawdzić datę ważności podaną na opakowaniu (etykiecie).
         Nie należy stosować leku po terminie ważności. Przechowuj lek w szczelnie zamkniętym
         opakowaniu, w miejscu niedostępnym i niewidocznym dla dzieci, zgodnie z wymogami producenta.
         */

        int totalDosage = 60 * weight;


        //totalDosage=weight * 15;  weight * 15 /mg /kg

        //dorosli -> 2/4 razy na dobe;
        //7-12 - 3, 4 razy na dobre
        //ponizej 7 -> co 4 , 6

        if (age <= 12 || weight <= 39) {
            totalDosage = min(totalDosage, 2000);
        } else {
            totalDosage = min(totalDosage, 4000);
        }

        String dosageText = String.valueOf(totalDosage / 4) + " mg " + getString(R.string.every) + "  6h\n  " + getString(R.string.or) + "\n" + String.valueOf(totalDosage / 6) + " mg " + getString(R.string.every) + "  4h";
        if (age < 7) {
            dosageText = String.valueOf(totalDosage / 4) + " mg " + getString(R.string.every) + "  6h\n  " + getString(R.string.or) + "\n" + String.valueOf(totalDosage / 6) + " mg " + getString(R.string.every) + "  4h";
        } else if (age >= 7 && age <= 12) {
            dosageText = String.valueOf(totalDosage / 3) + " mg " + getString(R.string.every) + "  8h\n   " + getString(R.string.or) + "\n" + String.valueOf(totalDosage / 4) + " mg " + getString(R.string.every) + "  6h";
        } else if (age > 12) {
            dosageText = String.valueOf(totalDosage / 6) + " mg " + getString(R.string.every) + "  4h\n   " + getString(R.string.or) + "\n" + String.valueOf(totalDosage / 4) + " mg " + getString(R.string.every) + "  6h";
        }
        buttonParacetamolDosage.setText(dosageText);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ParacetamolTotal", Integer.valueOf(totalDosage));
        editor.commit();

    }

}
