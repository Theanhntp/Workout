package com.workouthub.entity.exercise;

import com.workouthub.dao.Repo;
import com.j256.ormlite.field.DatabaseField;

public class Exercise {
    @DatabaseField(id = true)
    int id;
    @DatabaseField
    private String name;
    @DatabaseField
    // second
    private int time;
    @DatabaseField
    private int detail_gif_id;
    @DatabaseField
    private int calo;

    public Exercise() {
    }

    public Exercise(int id, String name, int time, int detail_gif_id, int calo) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.detail_gif_id = detail_gif_id;
        this.calo = calo;
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public int getDetail_gif_id() {
        return detail_gif_id;
    }

    public void setDetail_gif_id(int detail_gif_id) {
        this.detail_gif_id = detail_gif_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ExerciseDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public int update(Repo repo) throws Exception {
        if (repo.getExercise().getByID(id) == null) {
            return repo.getExercise().create(this);
        } else {
            return repo.getExercise().update(this);
        }
    }

    public int delete(Repo repo) {
        return repo.getExercise().delete(this);
    }
}