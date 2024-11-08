package com.workouthub.modules.exercise.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.workouthub.R;
import com.workouthub.entity.exercise.ExerciseList;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

// TODO
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    Context context;
    ArrayList<ExerciseList> exercises;
    LayoutInflater inflater;
    ExersiceDetail fragDetail;
    FragmentManager fragManager;
    FragmentTransaction transaction;

    public ExerciseAdapter(Context context, ArrayList<ExerciseList> exercises) {
        this.context = context;
        this.exercises = exercises;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.exercise_layout, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        ExerciseList exercise = exercises.get(position);
        holder.txtName.setText(exercise.getName());
        holder.textTime.setText(exercise.getTime());
        holder.txt_perday.setText(exercise.getPerday());
        holder.gifImageView.setImageDrawable(context.getResources().getDrawable(exercise.getSrc_gif_id()));
        holder.btn_start_exercise.setOnClickListener(v -> onStartExerciseActivity(exercise.getId()));
    }

    private void onStartExerciseActivity(int index) {
        Intent intent = new Intent(context, StartActivity.class);
        intent.putExtra("list_id", index + "");
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, textTime, txt_perday, btn_start_exercise;
        private GifImageView gifImageView;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            bindingView(itemView);
        }

        private void bindingView(View exerciseView) {
            txtName = exerciseView.findViewById(R.id.text_name_exercise);
            textTime = exerciseView.findViewById(R.id.text_time_exercise);
            txt_perday = exerciseView.findViewById(R.id.text_preday_exercise);
            btn_start_exercise = exerciseView.findViewById(R.id.btn_start_exercise);
            gifImageView = exerciseView.findViewById(R.id.gif_exercise);
        }
    }
}
