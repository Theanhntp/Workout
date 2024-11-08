package com.workouthub.dao.entity;

import com.workouthub.dao.DatabaseHelper;
import com.workouthub.entity.exercise.ExerciseList;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class RepoExerciseList {
    Dao<ExerciseList, Integer> exerciseListDao;

    public RepoExerciseList(DatabaseHelper db) {
        try {
            exerciseListDao = db.getExerciseListDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(ExerciseList exerciseList) {
        try {
            return exerciseListDao.create(exerciseList);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ExerciseList exerciseList) {
        try {
            return exerciseListDao.update(exerciseList);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ExerciseList exerciseList) {
        try {
            return exerciseListDao.delete(exerciseList);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public ExerciseList getByID(int id) {
        try {
            QueryBuilder<ExerciseList, Integer> qb = exerciseListDao.queryBuilder();
            qb.where().eq("id", id);
            PreparedQuery<ExerciseList> pq = qb.prepare();
            return exerciseListDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<ExerciseList> getAll() {
        try {
            return exerciseListDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}
