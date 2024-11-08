package com.workouthub.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.workouthub.entity.exercise.Exercise;
import com.workouthub.entity.exercise.ExerciseAmount;
import com.workouthub.entity.exercise.ExerciseList;
import com.workouthub.entity.food.Food;
import com.workouthub.entity.report.PracticeReport;
import com.workouthub.entity.user.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "db.sqlite";
    private static final int DATABASE_VERSION = 1;
    private Dao<User, Integer> userDao = null;
    private Dao<PracticeReport, String> practiceReportDao = null;
    private Dao<Exercise, Integer> exerciseDao = null;
    private Dao<ExerciseList, Integer> exerciseListDao = null;
    private Dao<Food, Integer> foodsDao = null;
    private Dao<ExerciseAmount, Integer> exerciseAmountDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DatabaseInitializer initializer = new DatabaseInitializer(context);
        try {
            initializer.createDatabase();
            initializer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Food.class);
            TableUtils.createTable(connectionSource, Exercise.class);
            TableUtils.createTable(connectionSource, ExerciseList.class);
            TableUtils.createTable(connectionSource, ExerciseAmount.class);
            TableUtils.createTable(connectionSource, PracticeReport.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Food.class, true);
            TableUtils.dropTable(connectionSource, Exercise.class, true);
            TableUtils.dropTable(connectionSource, ExerciseList.class, true);
            TableUtils.dropTable(connectionSource, ExerciseAmount.class, true);
            TableUtils.dropTable(connectionSource, PracticeReport.class, true);
            onCreate(db);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = DaoManager.createDao(getConnectionSource(), User.class);
        }
        return userDao;
    }

    @Override
    public void close() {
        super.close();
        userDao = null;
        practiceReportDao = null;
        exerciseDao = null;
        exerciseListDao = null;
        foodsDao = null;
        exerciseAmountDao = null;
    }

    public Dao<PracticeReport, String> getPracticeReportDao() throws SQLException {
        if (practiceReportDao == null) {
            practiceReportDao = DaoManager.createDao(getConnectionSource(), PracticeReport.class);
        }
        return practiceReportDao;
    }

    public Dao<ExerciseList, Integer> getExerciseListDao() throws SQLException {
        if (exerciseListDao == null) {
            exerciseListDao = DaoManager.createDao(getConnectionSource(), ExerciseList.class);
        }
        return exerciseListDao;
    }

    public Dao<Exercise, Integer> getExerciseDao() throws SQLException {
        if (exerciseDao == null) {
            exerciseDao = DaoManager.createDao(getConnectionSource(), Exercise.class);
        }
        return exerciseDao;
    }

    public Dao<Food, Integer> getFoodDao() throws SQLException {
        if (foodsDao == null) {
            foodsDao = DaoManager.createDao(getConnectionSource(), Food.class);
        }
        return foodsDao;
    }

    public Dao<ExerciseAmount, Integer> getExerciseAmountDao() throws SQLException {
        if (exerciseAmountDao == null) {
            exerciseAmountDao = DaoManager.createDao(getConnectionSource(), ExerciseAmount.class);
        }
        return exerciseAmountDao;
    }
}
