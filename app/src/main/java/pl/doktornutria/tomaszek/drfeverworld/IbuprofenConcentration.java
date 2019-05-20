package pl.doktornutria.tomaszek.drfeverworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class IbuprofenConcentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_concentration);

        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);
        final EditText editTextMl = (EditText) findViewById(R.id.editTextMl);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();
        int IbupMg = sharedPref.getInt("IbupMg", 200);
        int IbupMl = sharedPref.getInt("IbupMl", 5);
        editTextMg.setText(String.valueOf(IbupMg));
        editTextMl.setText(String.valueOf(IbupMl));
        editTextMg.startAnimation(shake);
        editTextMl.startAnimation(shake);


        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenConcentration.this, IbuprofenCalcActivity.class);
                myIntent.putExtra("ibuprofen_way_of_giving", "syrup");
                String IbupMg = editTextMg.getText().toString();
                String IbupMl = editTextMl.getText().toString();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("IbupMg", Integer.valueOf(IbupMg));
                editor.putInt("IbupMl", Integer.valueOf(IbupMl));
                editor.commit();
                IbuprofenConcentration.this.startActivity(myIntent);
            }
        });
    }
}
