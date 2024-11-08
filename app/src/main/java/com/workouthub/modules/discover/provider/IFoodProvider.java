package com.workouthub.modules.discover.provider;

import android.content.Context;

import com.workouthub.dao.Repo;

public class IFoodProvider {
    protected Repo repo;

    public IFoodProvider(Context context) {
        this.repo = new Repo(context);
    }
}
