package com.workouthub.modules.auth.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.workouthub.modules.feature.UpdateOnFeature;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent1 = new Intent(this, UpdateOnFeature.class);
        startActivity(intent1);
    }
}
