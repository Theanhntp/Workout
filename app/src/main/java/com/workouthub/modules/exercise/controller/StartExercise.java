package com.workouthub.modules.exercise.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.workouthub.R;

// TODO
public class StartExercise extends AppCompatActivity {
    private Button txt_start; //button for dem nguoc
    private TextView txt_time; // noi hien thii tgian con lai
    private long millimsln = 0; // luu tru timeleft

    private void bindingView() {
        txt_start = findViewById(R.id.txt_start);
        txt_time = findViewById(R.id.text_time);
    }

    private void bindingAction() {
        txt_start.setOnClickListener(this::clickBtnTimeStart);
    }

    private void clickBtnTimeStart(View view) {
        String mun = txt_time.getText().toString().substring(0, 3).trim();
        String num2 = txt_time.getText().toString().substring(4, 7).trim();
        int time_values = Integer.parseInt(mun) * 60 + Integer.parseInt(num2);
        millimsln = time_values * 1000;
        CountDownTimer count = new CountDownTimer(millimsln, 1000) {

            @Override
            public void onTick(long l) {
                millimsln = l;
                updateTime();
            }

            @Override
            public void onFinish() {
                Toast.makeText(StartExercise.this, "Finished, next to new", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), ExerciseActivity.class);
                startActivity(i);
            }
        }.start();
        txt_start.setEnabled(false);
    }

    private void updateTime() {
        int mun = (int) millimsln / 60000;
        int sec = (int) millimsln % 60000 / 1000;
        String txtMun, txtsec;
        if (mun < 10) {
            txtMun = "0" + mun;
        } else {
            txtMun = mun + "";
        }
        if (sec < 10) {
            txtsec = "0" + sec;
        } else {
            txtsec = sec + "";
        }
        txt_time.setText(txtMun + " : " + txtsec);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exercise);
        bindingView();
        bindingAction();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Your must finish this action", Toast.LENGTH_SHORT).show();
    }
}
