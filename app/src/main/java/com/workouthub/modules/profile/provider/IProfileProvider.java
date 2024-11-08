package com.workouthub.modules.profile.provider;

import android.content.Context;

import com.workouthub.dao.Repo;

public class IProfileProvider {
    protected Repo repo;

    public IProfileProvider(Context context) {
        this.repo = new Repo(context);
    }
}
