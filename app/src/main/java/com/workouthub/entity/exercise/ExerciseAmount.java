package com.workouthub.entity.exercise;

import com.workouthub.dao.Repo;
import com.j256.ormlite.field.DatabaseField;

public class ExerciseAmount {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(columnName = "exercise", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    Exercise exercise;
    @DatabaseField(columnName = "list", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    ExerciseList exerciseList;
    @DatabaseField
    int amount;

    public ExerciseAmount(Exercise exercise, ExerciseList exerciseList, int amount) {
        this.exercise = exercise;
        this.exerciseList = exerciseList;
        this.amount = amount;
    }

    public ExerciseAmount() {
    }

    public ExerciseList getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(ExerciseList exerciseList) {
        this.exerciseList = exerciseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int update(Repo repo) throws Exception {
        if (repo.getExerciseAmount().getByID(id) == null) {
            return repo.getExerciseAmount().create(this);
        } else {
            return repo.getExerciseAmount().update(this);
        }
    }

    public int delete(Repo repo) {
        return repo.getExerciseAmount().delete(this);
    }
}
