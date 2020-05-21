package com.qindal.brakecoolingschedule;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner autobrake_spinner = (Spinner) findViewById(R.id.autobrake_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> autobrake_adapter = ArrayAdapter.createFromResource(this,
                R.array.landing_brakes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        autobrake_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        autobrake_spinner.setAdapter(autobrake_adapter);

        Spinner category_spinner = (Spinner) findViewById(R.id.category_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> category_adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        category_spinner.setAdapter(category_adapter);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Calculate();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean Calculate(){
        int result;
        int weight, OAT, speed, altitude, autobrake, brakeType;
        boolean reverse;
        EditText text;
        String textValue;

        BrakeEnergy data = new BrakeEnergy();

        text = (EditText) findViewById(R.id.txtWeight);
        textValue = text.getText().toString();
        if (textValue.matches("")) {
            Toast.makeText(this, "You did not enter a valid weight", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            weight = Integer.valueOf(textValue);
            if(weight > 80000 || weight < 45000){
                Toast.makeText(this, "You did not enter a valid weight", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        text = (EditText) findViewById(R.id.txtTemperature);
        textValue = text.getText().toString();
        if (textValue.matches("")) {
            Toast.makeText(this, "You did not enter a valid OAT", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            OAT = Integer.valueOf(text.getText().toString());
            if(OAT > 50 || OAT < 0){
                Toast.makeText(this, "You did not enter a valid OAT", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        text = (EditText) findViewById(R.id.txtAltitude);
        textValue = text.getText().toString();
        if (textValue.matches("")) {
            Toast.makeText(this, "You did not enter a valid altitude", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            altitude = Integer.valueOf(text.getText().toString());
            if(altitude > 10000 || altitude < 0){
                Toast.makeText(this, "You did not enter a valid altitude", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        text = (EditText) findViewById(R.id.txtSpeed);
        textValue = text.getText().toString();
        if (textValue.matches("")) {
            Toast.makeText(this, "You did not enter a valid speed", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            speed = Integer.valueOf(text.getText().toString());
            if(speed > 180 || speed < 80){
                Toast.makeText(this, "You did not enter a valid speed", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        Spinner autobrakeSpinner=(Spinner) findViewById(R.id.autobrake_spinner);
        autobrake = autobrakeSpinner.getSelectedItemPosition();

        RadioGroup radioReverse = (RadioGroup) findViewById(R.id.radio_ReverseUsed);
        reverse = R.id.radio_Reverse == radioReverse.getCheckedRadioButtonId();

        Spinner brakeTypeSpinner=(Spinner) findViewById(R.id.category_spinner);
        brakeType = brakeTypeSpinner.getSelectedItemPosition();

        result = data.CoolingTime(weight, OAT, speed, altitude, autobrake, reverse, brakeType);

        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        if(result > 0) {

            txtResult.setTextColor(Color.GRAY);
            txtResult.setText(String.valueOf(result));
            return true;
        }
        else{
            switch (result){
                case -1:
                    txtResult.setTextColor(Color.GREEN);
                    txtResult.setText("NO SPECIAL PROCEDURE REQUIRED");
                    break;
                case -2:
                    txtResult.setTextColor(Color.YELLOW);
                    txtResult.setText("CAUTION");
                    break;
                case -3:
                    txtResult.setTextColor(Color.RED);
                    txtResult.setText("FUSE PLUG MELT ZONE");
                    break;
            }
        }

        return true;
    }
}
