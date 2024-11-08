package com.workouthub.modules.exercise.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.workouthub.R;
import com.workouthub.entity.exercise.ExerciseAmount;

import java.util.ArrayList;

// TODO
public class ExersiceDetail extends Fragment {
    private RecyclerView rc_ExerciseDetail;
    private ArrayList<ExerciseAmount> exercises;

    public ExersiceDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exersice_detail, container, false);
        rc_ExerciseDetail.setLayoutManager(new LinearLayoutManager(getContext()));
        rc_ExerciseDetail.setAdapter(new ExerciseDetailAdapter(getContext(), exercises));
        return view;
    }
}