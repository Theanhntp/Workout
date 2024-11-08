package com.workouthub.modules.home.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.workouthub.R;
import com.workouthub.modules.auth.controller.LoginActivity;
import com.workouthub.modules.discover.controller.FoodDiscoverActivity;
import com.workouthub.modules.exercise.controller.ExerciseActivity;
import com.workouthub.modules.init.InitProvider;
import com.workouthub.modules.profile.controller.ProfileActivity;
import com.workouthub.modules.report.controller.ReportActivity;

public class HomeMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitProvider inti = new InitProvider(this);
        setContentView(R.layout.activity_home_menu);
        onBindingView();
        onBindingAction();
    }

    private void onBindingView() {
        toolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav =
                (NavigationView) findViewById(R.id.nav_view);
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
    }

    private void onBindingAction() {
        nav.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_workout_list) {
            Intent intent1 = new Intent(HomeMenu.this, ExerciseActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_profile_creation) {
            Intent intent1 = new Intent(HomeMenu.this, ProfileActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_discover_food_menu) {
            Intent intent1 = new Intent(HomeMenu.this, FoodDiscoverActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_calo_calculated) {
            Intent intent1 = new Intent(HomeMenu.this, ReportActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_login) {
            Intent intent1 = new Intent(HomeMenu.this, LoginActivity.class);
            startActivity(intent1);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent start = new Intent(Intent.ACTION_MAIN);
        start.addCategory(Intent.CATEGORY_HOME);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(start);
    }
}