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

public class IbuprofenConcentrationPillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen_concentration_pills);
        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        final ImageView imageViewCalc = (ImageView) findViewById(R.id.imageViewCalc);

        final EditText editTextMg = (EditText) findViewById(R.id.editTextMg);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();
        int Mg = sharedPref.getInt("IbuprofenMgPill", 200);
        editTextMg.setText(String.valueOf(Mg));

        editTextMg.startAnimation(shake);

        imageViewCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(IbuprofenConcentrationPillsActivity.this, IbuprofenCalcActivity.class);
                myIntent.putExtra("ibuprofen_way_of_giving", "pills");
                String Mg = editTextMg.getText().toString();
                editor.putInt("IbuprofenMgPill", Integer.valueOf(Mg));
                editor.commit();
                IbuprofenConcentrationPillsActivity.this.startActivity(myIntent);
            }
        });


    }
}
