package com.workouthub.modules.setup.provider;

import android.content.Context;
import com.workouthub.entity.user.User;

public class SetUpProvider extends ISetUpProvider {
    public SetUpProvider(Context context) {
        super(context);
    }

    public void insertProfile(String name, int age, float height, float weight, String gender, String email, String password) throws Exception {
        User profile = new User();
        profile.setId(1);
        profile.setName(name);
        profile.setAge(age);
        profile.setHeight(height);
        profile.setWeight(weight);
        profile.setGender(gender);
        profile.setEmail(email);
        profile.setPassword(password);
        profile.update(repo);
    }
}
