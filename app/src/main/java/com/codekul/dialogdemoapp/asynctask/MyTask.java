package com.codekul.dialogdemoapp.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;

import com.codekul.dialogdemoapp.MainActivity;
import com.codekul.dialogdemoapp.R;

/**
 * Created by root on 31/3/16.
 */
public class MyTask extends AsyncTask<String,Integer,Void> {

    private MainActivity activity;

    public MyTask(MainActivity activity){
        this.activity = activity;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        ((Button)activity.findViewById(R.id.btnProgress)).setText("on PreExecute");

        Log.i("@codekul", "On Pre Execute");
    }

    @Override
    protected Void doInBackground(String... params) {

        Log.i("@codekul","Do In Background");

        for(int i = 0 ;i < 50 ; i++){

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

        Log.i("@codekul", "On Post Execute");

        ((Button)activity.findViewById(R.id.btnProgress)).setText("on PostExecute");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        ((Button)activity.findViewById(R.id.btnProgress)).setText(""+values[0]);
    }
}
