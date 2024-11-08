package com.workouthub.modules.profile.provider;

import android.content.Context;

import com.workouthub.entity.user.User;

public class ProfileProvider extends IProfileProvider {
    public ProfileProvider(Context context) {
        super(context);
    }

    public User getUser() throws Exception {
        return repo.getUsers().getById(1);
    }

    public void insertProfile(String name, int age, float height, float weight, String gender, String email) throws Exception {
        User profile = new User();
        profile.setId(1);
        profile.setName(name);
        profile.setAge(age);
        profile.setHeight(height);
        profile.setWeight(weight);
        profile.setGender(gender);
        profile.setEmail(email);
        profile.update(repo);
    }
}
