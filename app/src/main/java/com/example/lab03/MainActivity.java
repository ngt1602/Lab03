package com.example.lab03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //get context menu of app
        MenuInflater inflater = getMenuInflater();
        //set menu
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.clear:
                //clear
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle(R.string.message_caption);
                message.setMessage(R.string.message_content);
                message.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText) findViewById(R.id.editTextTextPersonName);
                        et.setText("");//clear edittextcontent
                    }
                }).show();
                break;
            case R.id.setting:
                // setting
                Intent intent = new Intent(this, optionActivity.class);
                final int result = 1;
                // Init activity that have return result
                someActivityResultLauncher.launch(intent);
                break;
            case R.id.exit:
                //exit
                new AlertDialog.Builder(this)
                        .setTitle(R.string.exit_caption)
                        .setMessage(R.string.exit_content)
                        .setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Exit app
                                finish();
                            }
                        })
                        .setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO Auto-generated method stub
                                return;
                            }
                        })
                        .show();
                break;
        }//end switch
        return true;
    }//end onOptionsItemSelected

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Here, no request code
                        Intent data = result.getData();
// get Bundle data
                        Bundle bundle = data.getExtras();
                        int index1 = bundle.getInt("ForeColor");
                        Log.i("index1", String.valueOf(index1));
                        int index2 = bundle.getInt("BackColor");
                        Log.i("index2", String.valueOf(index2));
                        // get color array
                        String colorArray[] = getResources().getStringArray(R.array.color_array);
                        Log.i("colorArray", String.valueOf(colorArray.length));
                        // editText mapping
                        EditText et = (EditText) findViewById(R.id.editTextTextPersonName);
                        // config color

                        et.setTextColor(Color.parseColor(colorArray[index1]));
                        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
                    }
                }
            });
}
