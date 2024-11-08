package com.workouthub.modules.setup.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.workouthub.R;
import com.workouthub.entity.user.User;
import com.workouthub.modules.home.controller.HomeMenu;
import com.workouthub.modules.setup.provider.SetUpProvider;

public class SetUpActivity extends AppCompatActivity {
    private User profile;
    private SetUpProvider provider;
    private Button save_creds;
    private Spinner ch_gender;
    private EditText ename, eage, eheight, ewt, eemail, epassword;
    private long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        provider = new SetUpProvider(this);
        save_creds = (Button) findViewById(R.id.btn_save);
        ch_gender = (Spinner) findViewById(R.id.edit_gender);
        ename = (EditText) findViewById(R.id.edit_name);
        eage = (EditText) findViewById(R.id.edit_age);
        eheight = (EditText) findViewById(R.id.edit_height);
        ewt = (EditText) findViewById(R.id.edit_weight);
        eemail = (EditText) findViewById(R.id.edit_email);
        epassword = (EditText) findViewById(R.id.edit_password);

        profile = new User();
        save_creds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertProfile();
            }
        });
    }

    private void insertProfile() {
        String name = ename.getText().toString();
        int age = Integer.parseInt(eage.getText().toString().trim());
        float height = Float.parseFloat(eheight.getText().toString().trim());
        float weight = Float.parseFloat(ewt.getText().toString().trim());
        String gender = ch_gender.getSelectedItem().toString();
        String email = eemail.getText().toString();
        String password = epassword.getText().toString();
        try {
            provider.insertProfile(name, age, height, weight, gender, email, password);
            Toast.makeText(this, "Profile Created!", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(this, HomeMenu.class);
            startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}