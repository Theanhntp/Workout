package com.workouthub.modules.profile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.workouthub.R;
import com.workouthub.entity.user.User;
import com.workouthub.modules.auth.controller.LoginActivity;
import com.workouthub.modules.discover.controller.FoodDiscoverActivity;
import com.workouthub.modules.exercise.controller.ExerciseActivity;
import com.workouthub.modules.home.controller.HomeMenu;
import com.workouthub.modules.profile.provider.ProfileProvider;
import com.workouthub.modules.report.controller.ReportActivity;

public class ProfileActivity extends AppCompatActivity {
    private User profile;
    private ProfileProvider provider;
    private Button save_creds;
    private Spinner ch_gender;
    private EditText ename, eage, eheight, ewt, eemail;
    private long maxid = 0;
    private Toolbar toolbar;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        provider = new ProfileProvider(this);
        try {
            profile = provider.getUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        OnBindingView();
        OnBindingAction();
    }

    private void OnBindingView() {
        toolbar =
                (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        nav =
                (NavigationView) findViewById(R.id.nav_view3);
        drawerLayout =
                (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle =
                new ActionBarDrawerToggle(
                        this,
                        drawerLayout,
                        toolbar,
                        R.string.Open,
                        R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        save_creds = (Button) findViewById(R.id.btn_save1);
        ch_gender = (Spinner) findViewById(R.id.edit_gender1);
        ename = (EditText) findViewById(R.id.edit_name1);
        ename.setText(profile.getName() + "");
        eage = (EditText) findViewById(R.id.edit_age1);
        eage.setText(profile.getAge() + "");
        eheight = (EditText) findViewById(R.id.edit_height1);
        eheight.setText(profile.getHeight() + "");
        ewt = (EditText) findViewById(R.id.edit_weight1);
        ewt.setText(profile.getWeight() + "");
        eemail = (EditText) findViewById(R.id.edit_email1);
        eemail.setText(profile.getEmail() + "");
    }

    private void OnBindingAction() {
        nav.setNavigationItemSelectedListener(item -> onNavigationItemSelected(item));
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
        try {
            provider.insertProfile(name, age, height, weight, gender, email);
            Toast.makeText(this, "Profile Created!", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(this, HomeMenu.class);
            startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_workout_list) {
            Intent intent1 = new Intent(this, ExerciseActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_discover_food_menu) {
            Intent intent1 = new Intent(this, FoodDiscoverActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_calo_calculated) {
            Intent intent1 = new Intent(this, ReportActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_login) {
            Intent intent1 = new Intent(this, LoginActivity.class);
            startActivity(intent1);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}