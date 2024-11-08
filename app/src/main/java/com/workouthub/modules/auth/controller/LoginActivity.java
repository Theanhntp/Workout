package com.workouthub.modules.auth.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.workouthub.R;
import com.workouthub.modules.feature.UpdateOnFeature;
import com.workouthub.modules.setup.controller.SetUpActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent1 = new Intent(this, LoginActivity.class);
        startActivity(intent1);
    }
}