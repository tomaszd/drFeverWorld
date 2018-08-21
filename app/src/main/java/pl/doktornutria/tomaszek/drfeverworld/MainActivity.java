package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonParacetamol = (Button) findViewById(R.id.buttonParacetamol);
        final Button buttonIbuprofen = (Button) findViewById(R.id.buttonIbuprofen);

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
    }
}
