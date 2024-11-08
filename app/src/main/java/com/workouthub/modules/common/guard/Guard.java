package com.workouthub.modules.common.guard;

import android.content.Context;

import com.workouthub.dao.Repo;

public class Guard {
    public static boolean exitUser(Context context) {
        Repo repo = new Repo(context);
        return repo.getUsers().getById(1) != null;
    }
}
