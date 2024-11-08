package com.workouthub.modules.exercise.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.workouthub.R;
import com.workouthub.entity.exercise.Exercise;
import com.workouthub.entity.exercise.ExerciseAmount;
import com.workouthub.modules.exercise.providers.ExerciseService;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

// TODO
public class ExerciseDetailAdapter extends RecyclerView.Adapter<ExerciseDetailAdapter.ExerciseDetailViewHolder> {
    Context context;
    ArrayList<ExerciseAmount> exercises;
    LayoutInflater inflater;
    ExersiceDetail fragDetail;
    private ExerciseService service;

    public ExerciseDetailAdapter(Context context, List<ExerciseAmount> exercises) {
        this.context = context;
        this.exercises = (ArrayList<ExerciseAmount>) exercises;
        inflater = LayoutInflater.from(context);
        service = new ExerciseService(context);
    }

    @NonNull
    @Override
    public ExerciseDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.exercise_detail_layout, parent, false);
        return new ExerciseDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseDetailViewHolder holder, int position) {
        ExerciseAmount exercise_amount = exercises.get(position);
        Exercise exercise = exercise_amount.getExercise();
        holder.txtName.setText(exercise.getName());
        holder.txt_perday.setText(1 + "MIN");
        holder.gifImageView.setImageDrawable(context.getResources().getDrawable(exercise.getDetail_gif_id()));
        holder.btn_exercise_detail.setOnClickListener(v -> onClickShowFragment(exercise_amount));
    }

    private void onClickShowFragment(ExerciseAmount exercise_amount) {
        service.saveCaloReport(exercise_amount);
        Intent intent = new Intent(context, StartExercise.class);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ExerciseDetailViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, textTime, txt_perday;
        private GifImageView gifImageView;
        private ImageView btn_exercise_detail;

        public ExerciseDetailViewHolder(@NonNull View exereciseView) {
            super(exereciseView);
            bindingView(exereciseView);
        }

        private void bindingView(View exereciseView) {
            txtName = exereciseView.findViewById(R.id.text_name_action);
            textTime = exereciseView.findViewById(R.id.text_time_action);
            txt_perday = exereciseView.findViewById(R.id.text_times_action);
            gifImageView = exereciseView.findViewById(R.id.gif_exercise_detail);
            btn_exercise_detail = exereciseView.findViewById(R.id.btn_view_detail);
        }
    }
}
