package com.workouthub.entity.exercise;

import com.workouthub.dao.Repo;
import com.j256.ormlite.field.DatabaseField;

public class ExerciseList {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String time;
    @DatabaseField
    private String perday;
    @DatabaseField
    private int src_gif_id;

    public ExerciseList() {
    }

    public ExerciseList(int id, String name, String time, String perday, int src_gif_id) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.perday = perday;
        this.src_gif_id = src_gif_id;
    }

    public int getSrc_gif_id() {
        return src_gif_id;
    }

    public void setSrc_gif_id(int src_gif_id) {
        this.src_gif_id = src_gif_id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPerday() {
        return perday;
    }

    public void setPerday(String perday) {
        this.perday = perday;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", perday='" + perday + '\'' +
                '}';
    }

    public int update(Repo repo) throws Exception {
        if (repo.getExerciseList().getByID(id) == null) {
            return repo.getExerciseList().create(this);
        } else {
            return repo.getExerciseList().update(this);
        }
    }

    public int delete(Repo repo) {
        return repo.getExerciseList().delete(this);
    }
}