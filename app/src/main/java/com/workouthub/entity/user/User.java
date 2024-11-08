package com.workouthub.entity.user;

import com.workouthub.dao.Repo;
import com.j256.ormlite.field.DatabaseField;

public class User {
    @DatabaseField(id = true)
    int id;
    @DatabaseField()
    String username;
    @DatabaseField
    String password;
    @DatabaseField
    String email;
    @DatabaseField
    String name;
    @DatabaseField
    int age;
    @DatabaseField
    float height;
    @DatabaseField
    float weight;
    @DatabaseField
    String gender;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int update(Repo repo) throws Exception {
        if (repo.getUsers().getById(id) == null) {
            return repo.getUsers().create(this);
        } else {
            return repo.getUsers().update(this);
        }
    }

    public int delete(Repo repo) {
        return repo.getUsers().delete(this);
    }
}
