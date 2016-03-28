package com.codekul.dialogdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.codekul.dialogdemoapp.fragment.MyDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnAlert = (Button) findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //MyDialogFragment dialog = new MyDialogFragment();
                //dialog.show(getSupportFragmentManager(), "alert");

                showDialog("alert");
            }
        });

        final Button btnTimePicker = (Button) findViewById(R.id.btnTimePicker);
        btnTimePicker.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog("time");
            }
        });

        final Button btnDatePicker = (Button) findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {

                showDialog("date");
            }
        });

        final Button btnProgress = (Button) findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog("progress");
            }
        });

        final Button btnCustom = (Button) findViewById(R.id.btnCustom);
        btnCustom.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showDialog("custom");
            }
        });
    }

    private void showDialog(String tag){

        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), tag);
    }

    private class Click implements  View.OnClickListener {

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.btnAlert){
                showDialog("alert");
            }
        }
    }
}
