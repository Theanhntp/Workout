package com.workouthub.dao.entity;

import com.workouthub.dao.DatabaseHelper;
import com.workouthub.entity.exercise.Exercise;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class RepoExercise {
    Dao<Exercise, Integer> exerciseDao;

    public RepoExercise(DatabaseHelper db) {
        try {
            exerciseDao = db.getExerciseDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(Exercise exercise) {
        try {
            return exerciseDao.create(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Exercise exercise) {
        try {
            return exerciseDao.update(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Exercise exercise) {
        try {
            return exerciseDao.delete(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public Exercise getByID(int id) {
        try {
            QueryBuilder<Exercise, Integer> qb = exerciseDao.queryBuilder();
            qb.where().eq("id", id);
            PreparedQuery<Exercise> pq = qb.prepare();
            return exerciseDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<Exercise> getAll() {
        try {
            return exerciseDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}
