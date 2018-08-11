package com.example.tomaszek.drfeverworld;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class IbuprofenCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_calc);

        int age = 0;
        int weight = 0;
        String Mg = "";
        String Ml = "";


        final TextView text_view_id = (TextView) findViewById(R.id.text_view_id);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        age = pref.getInt("age", 0); // getting Integer
        weight = pref.getInt("weight", 0); // getting Integer
        Mg = pref.getString("Mg", "buba"); // getting Integer
        Ml = pref.getString("Ml", "buba"); // getting Integer


        text_view_id.setText(" Age : " + String.valueOf(age) +
                "\nWeight : " + String.valueOf(weight) +
                "\nMg : " + String.valueOf(Mg) +
                "\nMl : " + String.valueOf(Ml));

    }
}
