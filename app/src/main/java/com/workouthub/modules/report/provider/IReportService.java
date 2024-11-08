package com.workouthub.modules.report.provider;

import android.content.Context;

import com.workouthub.dao.Repo;

public class IReportService {
    protected Repo repo;

    public IReportService(Context context) {
        this.repo = new Repo(context);
    }
}
