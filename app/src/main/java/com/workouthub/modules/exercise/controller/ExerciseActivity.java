package com.workouthub.modules.exercise.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.workouthub.R;
import com.workouthub.entity.exercise.ExerciseList;
import com.workouthub.modules.auth.controller.LoginActivity;
import com.workouthub.modules.discover.controller.FoodDiscoverActivity;
import com.workouthub.modules.exercise.providers.ExerciseService;
import com.workouthub.modules.home.controller.HomeMenu;
import com.workouthub.modules.profile.controller.ProfileActivity;
import com.workouthub.modules.report.controller.ReportActivity;

import java.util.ArrayList;

// TODO
public class ExerciseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<ExerciseList> exercises = new ArrayList<>();
    private RecyclerView rc_Exercise;
    private ExerciseService service;
    private Toolbar toolbar;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;

    private void bindingView() {
        toolbar =
                (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        nav =
                (NavigationView) findViewById(R.id.nav_view1);
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
        rc_Exercise = findViewById(R.id.rc_exercise);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        service = new ExerciseService(this);
        exercises = service.getExerciseLists();
        bindingView();
        onBindingAction();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ExerciseAdapter adapter = new ExerciseAdapter(this, exercises);
        rc_Exercise.setLayoutManager(new LinearLayoutManager(this));
        rc_Exercise.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, HomeMenu.class);
        startActivity(i);
    }

    private void onBindingAction() {
        nav.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_workout_list) {
        }
        if (id == R.id.nav_profile_creation) {
            Intent intent1 = new Intent(ExerciseActivity.this, ProfileActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_discover_food_menu) {
            Intent intent1 = new Intent(ExerciseActivity.this, FoodDiscoverActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_calo_calculated) {
            Intent intent1 = new Intent(ExerciseActivity.this, ReportActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_login) {
            Intent intent1 = new Intent(ExerciseActivity.this, LoginActivity.class);
            startActivity(intent1);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}