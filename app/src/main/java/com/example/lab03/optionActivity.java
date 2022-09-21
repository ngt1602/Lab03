package com.example.lab03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class optionActivity extends Activity {
    private int index1 = 0, index2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionactivity);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                index1 = arg2; // get index
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                index2 = arg2; // get index
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
        public void onOK(View view) {
            // give data for previous activity
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("ForeColor", index1); // get textColor value
            bundle.putInt("BackColor", index2); // get background color value
            intent.putExtras(bundle); //send with data
            setResult(RESULT_OK, intent); // return result
            finish(); // close activity
        }
    }




