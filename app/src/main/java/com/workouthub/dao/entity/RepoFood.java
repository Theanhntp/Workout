package com.workouthub.dao.entity;

import com.workouthub.dao.DatabaseHelper;
import com.workouthub.entity.food.Food;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class RepoFood {
    Dao<Food, Integer> foodsDao;

    public RepoFood(DatabaseHelper db) {
        try {
            foodsDao = db.getFoodDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(Food exercise) {
        try {
            return foodsDao.create(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Food exercise) {
        try {
            return foodsDao.update(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Food exercise) {
        try {
            return foodsDao.delete(exercise);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public Food getByID(int id) {
        try {
            QueryBuilder<Food, Integer> qb = foodsDao.queryBuilder();
            qb.where().eq("id", id);
            PreparedQuery<Food> pq = qb.prepare();
            return foodsDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<Food> getAll() {
        try {
            return foodsDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}
