package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IbuprofenConcentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_concentration);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenConcentration.this, IbuprofenCalcActivity.class);
                IbuprofenConcentration.this.startActivity(myIntent);
            }
        });
    }
}
