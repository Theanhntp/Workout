package com.workouthub.modules.discover.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.workouthub.R;
import com.workouthub.entity.food.Food;
import com.workouthub.modules.auth.controller.LoginActivity;
import com.workouthub.modules.discover.provider.FoodProvider;
import com.workouthub.modules.exercise.controller.ExerciseActivity;
import com.workouthub.modules.profile.controller.ProfileActivity;
import com.workouthub.modules.report.controller.ReportActivity;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class FoodDiscoverActivity extends AppCompatActivity {
    private HashMap _$_findCachedViewById;
    private ListView listview;
    private TextView calorieText;
    private FoodProvider provider;
    private Button reset;
    private TextView value;
    private Toolbar toolbar;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider = new FoodProvider(this);
        this.setContentView(R.layout.activity_food_calories);
        OnBindingView();
        OnBindingAction();
    }

    private void OnBindingView() {
        toolbar =
                (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        nav =
                (NavigationView) findViewById(R.id.nav_view2);
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
        nav.setNavigationItemSelectedListener(item -> onNavigationItemSelected(item));
        listview = this.findViewById(R.id.listView);
        calorieText = this.findViewById(R.id.calorieText);
        reset = this.findViewById(R.id.reset);
        value = this.findViewById(R.id.valueCal);
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

    private void OnBindingAction() {
        boolean var4 = false;
        List<Food> list = provider.getFoods();
        listview.setAdapter(new FoodAdapter(this, R.layout.listview_row, list));
        ((ListView) this.findViewById(R.id.listView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(@NotNull AdapterView parent, @NotNull View view, int position, long id) {
                TextView var10000;
                TextView var10001;
                String var6;
                boolean var7;
                if (position == 0) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 200));
                }
                if (position == 1) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 100));
                }
                if (position == 2) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 50));
                }
                if (position == 3) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 50));
                }
                if (position == 4) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 140));
                }
                if (position == 5) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 200));
                }
                if (position == 6) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 250));
                }
                if (position == 7) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 140));
                }
                if (position == 8) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 110));
                }
                if (position == 9) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 200));
                }
                if (position == 10) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 114));
                }
                if (position == 11) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 65));
                }
                if (position == 12) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 132));
                }
                if (position == 13) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 47));
                }
                if (position == 14) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 30));
                }
                if (position == 15) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 220));
                }
                if (position == 16) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 200));
                }
                if (position == 17) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 110));
                }
                if (position == 18) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 170));
                }
                if (position == 19) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 110));
                }
                if (position == 20) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 52));
                }
                if (position == 21) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 95));
                }
                if (position == 22) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 68));
                }
                if (position == 23) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 115));
                }
                if (position == 24) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 110));
                }
                if (position == 25) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 100));
                }
                if (position == 26) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 110));
                }
                if (position == 27) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 300));
                }
                if (position == 28) {
                    var10000 = value;
                    var10001 = value;
                    var6 = var10001.getText().toString();
                    var7 = false;
                    var10000.setText(String.valueOf(Integer.parseInt(var6) + 70));
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                value.setText("0");
            }
        });
    }
}
