package com.workouthub.modules.exercise.providers;

import android.content.Context;

import com.workouthub.entity.exercise.Exercise;
import com.workouthub.entity.exercise.ExerciseAmount;
import com.workouthub.entity.exercise.ExerciseList;
import com.workouthub.entity.report.PracticeReport;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExerciseService extends IExerciseService {
    public ExerciseService(Context context) {
        super(context);
    }

    public List<ExerciseAmount> getExerciseAmount(String list_id) {
        ExerciseList list = repo.getExerciseList().getByID(Integer.parseInt(list_id));
        return repo.getExerciseAmount().getAllByList(list);
    }

    public ArrayList<ExerciseList> getExerciseLists() {
        return (ArrayList<ExerciseList>) repo.getExerciseList().getAll();
    }

    public void saveCaloReport(ExerciseAmount exerciseAmounts) {
        Exercise exercise = repo.getExercise().getByID(exerciseAmounts.getExercise().getId());
        int calo = exercise.getCalo() * exerciseAmounts.getAmount();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        PracticeReport practiceReport = repo.getPracticeReport().getByDate(dateFormat.format(date));
        if (practiceReport == null) {
            practiceReport = new PracticeReport(calo, dateFormat.format(date));
            try {
                practiceReport.update(repo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            practiceReport.setCalo(practiceReport.getCalo() + calo);
            try {
                practiceReport.update(repo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
