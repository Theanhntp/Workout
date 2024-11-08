package com.workouthub.entity.report;

import com.workouthub.dao.Repo;
import com.j256.ormlite.field.DatabaseField;

public class PracticeReport {
    @DatabaseField(id = true)
    String date;
    @DatabaseField
    int calo;

    public PracticeReport(int calo, String date) {
        this.calo = calo;
        this.date = date;
    }

    public PracticeReport() {
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int update(Repo repo) throws Exception {
        if (repo.getPracticeReport().getByDate(date) == null) {
            return repo.getPracticeReport().create(this);
        } else {
            return repo.getPracticeReport().update(this);
        }
    }


    public int delete(Repo repo) {
        return repo.getPracticeReport().delete(this);
    }
}
