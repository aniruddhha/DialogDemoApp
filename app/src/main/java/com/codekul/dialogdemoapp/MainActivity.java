package com.codekul.dialogdemoapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.codekul.dialogdemoapp.asynctask.MyTask;
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

                //showDialog("progress");

                /*for(int i = 0 ; i <50 ; i++){

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                            btnProgress.setText("" + i);
                }*/

                /*new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for(int i = 0 ; i <50 ; i++){

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            btnProgress.setText("" + i);
                        }
                    }
                }).start();*/

                new MyTAsk().execute("android");

                //new MyTask(MainActivity.this).execute("");
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

    private class MyTAsk extends AsyncTask<String,Integer,Void>{

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Title");
            progressDialog.setMessage("Messsage");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();

            //progressDialog.setMax(100);

            ((Button)findViewById(R.id.btnProgress)).setText("on PreExecute");

            Log.i("@codekul","On Pre Execute");
        }

        @Override
        protected Void doInBackground(String... params) {

            Log.i("@codekul","Do In Background");

            for(int i = 0 ;i < 10 ; i++){

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            progressDialog.dismiss();

            Log.i("@codekul", "On Post Execute");

            ((Button)findViewById(R.id.btnProgress)).setText("on PostExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressDialog.setProgress(values[0]);
            ((Button)findViewById(R.id.btnProgress)).setText("" + values[0]);
        }
    }
}
