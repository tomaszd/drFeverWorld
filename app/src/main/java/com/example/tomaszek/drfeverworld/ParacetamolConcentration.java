package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ParacetamolConcentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol_concentration);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);
        final EditText editTextMl = (EditText) findViewById(R.id.editTextMl);


        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();
        int ParacMg = sharedPref.getInt("ParacMg", 100);
        int ParacMl = sharedPref.getInt("ParacMl", 100);
        editTextMg.setText(String.valueOf(ParacMg));
        editTextMl.setText(String.valueOf(ParacMl));


        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ParacetamolConcentration.this, ParacetamolCalcActivity.class);
                myIntent.putExtra("paracetamol_way_of_giving", "syrup");
                String Mg = editTextMg.getText().toString();
                String Ml = editTextMl.getText().toString();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("ParacMg", Integer.valueOf(Mg));
                editor.putInt("ParacMl", Integer.valueOf(Ml));
                editor.commit();
                ParacetamolConcentration.this.startActivity(myIntent);
            }
        });


    }
}
