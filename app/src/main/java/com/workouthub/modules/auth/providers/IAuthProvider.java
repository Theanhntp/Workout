package com.workouthub.modules.auth.providers;

import android.content.Context;

import com.workouthub.dao.Repo;

public abstract class IAuthProvider {
    protected Repo repo;

    public IAuthProvider(Context context) {
        this.repo = new Repo(context);
    }

    public boolean login(String username, String password) {
        return false;
    }
}
