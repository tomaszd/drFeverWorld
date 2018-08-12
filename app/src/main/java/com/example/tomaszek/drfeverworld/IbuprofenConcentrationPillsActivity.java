package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class IbuprofenConcentrationPillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_concentration_pills);

        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();
        int Mg = sharedPref.getInt("IbuprofenMgPill", 100);
        editTextMg.setText(String.valueOf(Mg));

        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenConcentrationPillsActivity.this, IbuprofenCalcActivity.class);
                String Mg = editTextMg.getText().toString();
                editor.putInt("IbuprofenMgPill", Integer.valueOf(Mg));
                editor.commit();
                IbuprofenConcentrationPillsActivity.this.startActivity(myIntent);
            }
        });


    }
}
