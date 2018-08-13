package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class IbuprofenCalculationSuppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_calculation_supp);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();
        int Mg = sharedPref.getInt("IbuprofenMgSupp", 100);
        editTextMg.setText(String.valueOf(Mg));

        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenCalculationSuppActivity.this, ParacetamolCalcActivity.class);
                myIntent.putExtra("ibuprofen_way_of_giving", "supp");
                String Mg = editTextMg.getText().toString();
                editor.putInt("IbuprofenMgSupp", Integer.valueOf(Mg));
                editor.commit();
                IbuprofenCalculationSuppActivity.this.startActivity(myIntent);
            }
        });

    }
}
