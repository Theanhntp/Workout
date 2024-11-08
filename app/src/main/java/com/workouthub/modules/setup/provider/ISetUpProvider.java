package com.workouthub.modules.setup.provider;

import android.content.Context;

import com.workouthub.dao.Repo;

public class ISetUpProvider {
    protected Repo repo;

    public ISetUpProvider(Context context) {
        this.repo = new Repo(context);
    }
}
