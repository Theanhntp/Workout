package com.workouthub.dao.entity;

import com.workouthub.dao.DatabaseHelper;
import com.workouthub.entity.report.PracticeReport;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class RepoPracticeReport {
    Dao<PracticeReport, String> practiceReportDao;

    public RepoPracticeReport(DatabaseHelper db) {
        try {
            practiceReportDao = db.getPracticeReportDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(PracticeReport practiceReport) {
        try {
            return practiceReportDao.create(practiceReport);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(PracticeReport practiceReport) {
        try {
            return practiceReportDao.update(practiceReport);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(PracticeReport practiceReport) {
        try {
            return practiceReportDao.delete(practiceReport);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public PracticeReport getByDate(String date) {
        try {
            QueryBuilder<PracticeReport, String> qb = practiceReportDao.queryBuilder();
            qb.where().eq("date", date);
            PreparedQuery<PracticeReport> pq = qb.prepare();
            return practiceReportDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<PracticeReport> getAll() {
        try {
            return practiceReportDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}
