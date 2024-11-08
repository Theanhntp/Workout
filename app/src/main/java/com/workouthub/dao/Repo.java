package com.workouthub.dao;

import android.content.Context;

import com.workouthub.dao.entity.RepoExercise;
import com.workouthub.dao.entity.RepoExerciseAmount;
import com.workouthub.dao.entity.RepoExerciseList;
import com.workouthub.dao.entity.RepoFood;
import com.workouthub.dao.entity.RepoPracticeReport;
import com.workouthub.dao.entity.RepoUsers;

public class Repo {
    private RepoUsers Users;
    private RepoPracticeReport practiceReport;
    private RepoExercise exercise;
    private RepoExerciseList exerciseList;
    private RepoFood Food;
    private RepoExerciseAmount exerciseAmount;
    private DatabaseHelper db;

    public Repo(Context context) {
        DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
        db = manager.getHelper(context);
    }

    public RepoExerciseAmount getExerciseAmount() {
        return exerciseAmount = new RepoExerciseAmount(db);
    }

    public RepoUsers getUsers() {
        return Users = new RepoUsers(db);
    }

    public RepoPracticeReport getPracticeReport() {
        return practiceReport = new RepoPracticeReport(db);
    }

    public RepoExercise getExercise() {
        return exercise = new RepoExercise(db);
    }

    public RepoExerciseList getExerciseList() {
        return exerciseList = new RepoExerciseList(db);
    }

    public RepoFood getFood() {
        return Food = new RepoFood(db);
    }
}
