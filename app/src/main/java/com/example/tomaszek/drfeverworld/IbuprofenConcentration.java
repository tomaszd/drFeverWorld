package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class IbuprofenConcentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_concentration);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);
        final EditText editTextMl = (EditText) findViewById(R.id.editTextMl);


        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenConcentration.this, IbuprofenCalcActivity.class);
                String Mg = editTextMg.getText().toString();
                String Ml = editTextMl.getText().toString();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Mg", Integer.valueOf(Mg));
                editor.putInt("Ml", Integer.valueOf(Ml));


                IbuprofenConcentration.this.startActivity(myIntent);
            }
        });
    }
}
