package com.workouthub.modules.exercise.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.workouthub.R;
import com.workouthub.entity.exercise.ExerciseAmount;
import com.workouthub.modules.exercise.providers.ExerciseService;

import java.util.ArrayList;
import java.util.List;

// TODO
public class StartActivity extends AppCompatActivity {
    private List<ExerciseAmount> exercises = new ArrayList<>();
    private RecyclerView rc_Exercise;
    private ExerciseService service;

    private void bindingView() {
        rc_Exercise = findViewById(R.id.rc_exercise_detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        service = new ExerciseService(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("list_id");
        exercises = service.getExerciseAmount(str);
        bindingView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ExerciseDetailAdapter adapter = new ExerciseDetailAdapter(this, this.exercises);
        rc_Exercise.setLayoutManager(new LinearLayoutManager(this));
        rc_Exercise.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, ExerciseActivity.class);
        startActivity(i);
    }
}