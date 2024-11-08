package com.workouthub.modules.exercise.providers;

import android.content.Context;

import com.workouthub.dao.Repo;

public class IExerciseService {
    protected Repo repo;

    public IExerciseService(Context context) {
        this.repo = new Repo(context);
    }
}
