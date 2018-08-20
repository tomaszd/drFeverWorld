package com.example.tomaszek.drfeverworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        final ImageView imageViewOK = (ImageView) findViewById(R.id.imageViewOK);

        imageViewOK.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(InformationActivity.this, MainActivity.class);
                InformationActivity.this.startActivity(myIntent);
            }
        });


    }
}
