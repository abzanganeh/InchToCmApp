package edu.pcc.alizanganeh.feetintocmapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private  OutputFragment mOutputFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(getResources().getBoolean(R.bool.two_panel)) {
            InputFragment input = new InputFragment();
            mOutputFragment  = new OutputFragment();
            transaction.replace(R.id.input_content, input);
            transaction.replace(R.id.output_content, mOutputFragment);
            transaction.commit();

        } else {
            InputFragment input = new InputFragment();
            transaction.replace(R.id.content, input);
            transaction.commit();
        }

    }

    public void calculate(View view) {

        int feet = 0;
        int inch = 0;

        EditText mFeet = (EditText) findViewById(R.id.feet);
        EditText mInch = (EditText) findViewById(R.id.inch);
        try{
            feet = Integer.parseInt(mFeet.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid integer number!", Toast.LENGTH_SHORT).show();
        }

        try {
            inch = Integer.parseInt(mInch.getText().toString());
        } catch (NumberFormatException e) {
        Toast.makeText(this, "Please enter valid integer number!", Toast.LENGTH_SHORT).show();
        }

        double cm = (double) (((feet * 12) + inch) * 2.54);
        NumberFormat formatter = new DecimalFormat("#0.00");
        String result  =  formatter.format(cm);

        if (!getResources().getBoolean(R.bool.two_panel)){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            OutputFragment output = new OutputFragment();
            transaction.addToBackStack("input frame");
            transaction.replace(R.id.content, output);
            transaction.commit();
            output.setValues(result);
        } else {
            mOutputFragment.setValues(result);
        }



    }
}
