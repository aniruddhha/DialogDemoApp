package com.codekul.dialogdemoapp.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.codekul.dialogdemoapp.R;

/**
 * Created by root on 28/3/16.
 */
public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals("alert")){

            DialogButtonClick click = new DialogButtonClick();

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Title");
            builder.setMessage("Message");
            //builder.setIcon(R.drawable.my);
            builder.setPositiveButton("+ve", click);
            builder.setNegativeButton("-ve", click);
            builder.setNeutralButton("=", click);

            dialog = builder.create();
        }
        else if (getTag().equals("time")){

            TimePickerDialog timePiccker = new TimePickerDialog(
                    getActivity(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    Log.i("@codekul","Hour : "+hourOfDay +" Minute : "+minute);
                }
            }, 8, 15, false);

            dialog = timePiccker;
        }
        else if(getTag().equals("date")){

            DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    Log.i("@codekul",""+dayOfMonth+" - "+ (monthOfYear +1)+" - "+year);
                }
            }, 2016, 4, 23);
            dialog = datePicker;
        }
        else if(getTag().equals("progress")){

            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Title");
            progressDialog.setMessage("Message");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);

            for(int i = 0 ; i< 10 ;i++ ){

                progressDialog.setProgress(10 * i);
            }


            dialog = progressDialog;
        }
        else {
            dialog = new Dialog(getActivity());
            dialog.setTitle("Title");
            dialog.setContentView(R.layout.dialog_custom);

            final EditText edtColor = (EditText) dialog.findViewById(R.id.edtColor);

            Button btnOkay = (Button) dialog.findViewById(R.id.btnOkay);
            btnOkay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("@codekul", ""+edtColor.getText().toString());
                }
            });
        }

        return dialog;
    }

    private class DialogButtonClick implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {

            if(which == DialogInterface.BUTTON_POSITIVE) {

                Log.i("@codekul","Positive Button");
            }
            else if(which == DialogInterface.BUTTON_NEGATIVE ){

                Log.i("@codekul","Negative Button");
            }
            else {

                Log.i("@codekul","Neutral Button");
            }
        }
    }
}
