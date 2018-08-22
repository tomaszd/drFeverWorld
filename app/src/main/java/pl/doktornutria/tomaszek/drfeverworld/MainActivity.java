package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonParacetamol = (Button) findViewById(R.id.buttonParacetamol);
        final Button buttonIbuprofen = (Button) findViewById(R.id.buttonIbuprofen);
        final ImageView imageViewInfo = (ImageView) findViewById(R.id.imageViewInfo);

        buttonParacetamol.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ParacetamolActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        buttonIbuprofen.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, IbuprofenActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        imageViewInfo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                myIntent.putExtra("explicitCall", true); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });


    }
}
