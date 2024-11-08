package com.workouthub.modules.report.controller;

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
import com.workouthub.modules.profile.controller.ProfileActivity;
import com.workouthub.modules.report.provider.ReportService;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ReportActivity extends AppCompatActivity {
    private GraphView graphView;
    private ReportService service;
    private Toolbar toolbar;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;

    private void OnBindingView() {
        toolbar =
                (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        nav =
                (NavigationView) findViewById(R.id.nav_view4);
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
        graphView = findViewById(R.id.idGraphView);
        DataPoint[] statsArray = service.getReportGraphData();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(statsArray);
        graphView.setTitle("Your training graph view");
        graphView.setTitleColor(R.color.white);
        graphView.setTitleTextSize(18);
        graphView.addSeries(series);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(1.0);
        graphView.getViewport().setMaxX(statsArray.length);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_workout_list) {
            Intent intent1 = new Intent(this, ExerciseActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_profile_creation) {
            Intent intent1 = new Intent(this, ProfileActivity.class);
            startActivity(intent1);
        }
        if (id == R.id.nav_discover_food_menu) {
            Intent intent1 = new Intent(this, FoodDiscoverActivity.class);
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

    private void onBindingAction() {
        nav.setNavigationItemSelectedListener(item -> onNavigationItemSelected(item));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        service = new ReportService(this);
        OnBindingView();
        onBindingAction();
    }
}
