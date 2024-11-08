package com.workouthub.modules.init;

import android.content.Context;

import com.workouthub.R;
import com.workouthub.dao.Repo;
import com.workouthub.entity.exercise.Exercise;
import com.workouthub.entity.exercise.ExerciseAmount;
import com.workouthub.entity.exercise.ExerciseList;
import com.workouthub.entity.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitProvider {
    Random random = new Random();
    private List<Food> foods = new ArrayList<>();
    private List<Exercise> exercises = new ArrayList<>();
    private List<ExerciseList> exerciseLists = new ArrayList<>();
    private Repo repo;

    public InitProvider(Context context) {
        repo = new Repo(context);
        try {
            this.CreateInitDatabase(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CreateInitDatabase(Context context) throws Exception {
        CreateInitFood();
        CreateInitExercise();
        CreateInitExerciseList();
    }

    private void CreateInitFood() throws Exception {
        if (repo.getFood().getByID(1) == null) {
            foods.add(new Food(1, "Rice", "Plain Rice : 200 cal", R.drawable.rice_bowl));
            foods.add(new Food(2, "Chapati", " 2 Plain chapati : 100 cal", R.drawable.roti_canai));
            foods.add(new Food(3, "Dal", "Plain dal : 50 cal", R.drawable.dal2));
            foods.add(new Food(4, "Salad", "Mix salad : 50 cal", R.drawable.salad));
            foods.add(new Food(5, "Noodles", "Noodles : 140 cal", R.drawable.noodles));
            foods.add(new Food(6, "Burger", "Burger: 200 cal", R.drawable.hamburger));
            foods.add(new Food(7, "Pizza", " Pizza : 250 cal", R.drawable.pizza));
            foods.add(new Food(8, "cold drink", "Carbonated cold drink :140 cal", R.drawable.soft_drink));
            foods.add(new Food(9, "Apple", "Apple : 114 cal", R.drawable.apple));
            foods.add(new Food(10, "Bread", "4-bread Slice :65 cal", R.drawable.baguette));
            foods.add(new Food(11, "Cake", "1- Cake Slice : 132 cal", R.drawable.cake));
            foods.add(new Food(12, "Muffin", "muffin : 47 cal", R.drawable.cupcake));
            foods.add(new Food(13, "Carrot", " carrot: 30 cal", R.drawable.carrot));
            foods.add(new Food(14, "Chicken", " chicken : 220 cal", R.drawable.chicken_leg));
            foods.add(new Food(15, "Chocolate", "Chocolate bar : 200 cal", R.drawable.chocolate));
            foods.add(new Food(16, "Donut", "donut : 110 cal", R.drawable.donut));
            foods.add(new Food(17, "Laddu", "Laddu : 170  cal", R.drawable.fazuelos));
            foods.add(new Food(18, "French fries", "French Fries medium : 110 cal", R.drawable.french_fries));
            foods.add(new Food(19, "Orange", " Orange : 52 cal", R.drawable.fruit));
            foods.add(new Food(20, "Hot dog", "Hot Dog: 95  cal", R.drawable.hot_dog));
            foods.add(new Food(21, "Rolls", " Roll : 68 cal", R.drawable.kebab));
            foods.add(new Food(22, "Potato Chips", "Potato chips : 155 cal", R.drawable.potato_chips));
            foods.add(new Food(23, "Sundae", "Sundae : 110 cal", R.drawable.sundae));
            foods.add(new Food(24, "Ice Cream", " Ice Cream : 100 cal", R.drawable.parfait));
            foods.add(new Food(25, "Strawberry", "Strawberry : 110 cal", R.drawable.strawberry));
            foods.add(new Food(26, "meat", "250 g red meat : 300 cal", R.drawable.meat));
            foods.add(new Food(27, "Khichidi", "Khichidi : 70 cal", R.drawable.vegan_food));
            for (Food f : foods
            ) {
                f.update(repo);
            }
        }
    }

    private void CreateInitExercise() throws Exception {
        if (repo.getExercise().getByID(1) == null) {
            //int id, String name, int time, int detail_gif_id
            exercises.add(new Exercise(1, "exercise_1", 1, R.drawable.exersice_1, random.nextInt(100) + 100));
            exercises.add(new Exercise(2, "exercise_2", 2, R.drawable.exersice_2, random.nextInt(100) + 100));
            exercises.add(new Exercise(3, "exercise_3", 1, R.drawable.exersice_3, random.nextInt(100) + 100));
            exercises.add(new Exercise(4, "exercise_4", 2, R.drawable.exersice_4, random.nextInt(100) + 100));
            exercises.add(new Exercise(5, "exercise_5", 1, R.drawable.exersice_5, random.nextInt(100) + 100));
            exercises.add(new Exercise(6, "exercise_6", 2, R.drawable.exersice_6, random.nextInt(100) + 100));
            exercises.add(new Exercise(7, "exercise_7", 1, R.drawable.exersice_7, random.nextInt(100) + 100));
            exercises.add(new Exercise(8, "exercise_8", 2, R.drawable.exersice_8, random.nextInt(100) + 100));
            exercises.add(new Exercise(9, "exercise_9", 1, R.drawable.exersice_9, random.nextInt(100) + 100));
            exercises.add(new Exercise(10, "exercise_10", 2, R.drawable.exersice_10, random.nextInt(100) + 100));
            exercises.add(new Exercise(11, "exercise_11", 1, R.drawable.exersice_11, random.nextInt(100) + 100));
            exercises.add(new Exercise(12, "exercise_12", 2, R.drawable.exersice_12, random.nextInt(100) + 100));
            exercises.add(new Exercise(13, "exercise_13", 1, R.drawable.exersice_13, random.nextInt(100) + 100));
            exercises.add(new Exercise(14, "exercise_14", 2, R.drawable.exersice_14, random.nextInt(100) + 100));
            exercises.add(new Exercise(15, "exercise_15", 3, R.drawable.exersice_15, random.nextInt(100) + 100));
            for (Exercise ex : exercises
            ) {
                ex.update(repo);
            }
        }
    }

    private void CreateInitExerciseList() throws Exception {
        if (repo.getExerciseList().getByID(1) == null) {
            // int id, String name, String time, String perday, int src_gif_id
            for (int i = 1; i < 10; i++) {
                exerciseLists.add(new ExerciseList(i, "random_list_" + i, "random_time_" + i, "random_per_day_" + i, R.drawable.exersice_1));
            }
            for (ExerciseList ex : exerciseLists
            ) {
                ex.update(repo);
                for (int i = 0; i < random.nextInt(10); i++) {
                    CreateInitExerciseAmount(ex);
                }
            }
        }
    }

    private void CreateInitExerciseAmount(ExerciseList ex) throws Exception {
        //Exercise exercise, ExerciseList exerciseList, int amount
        ExerciseAmount exerciseAmount = new ExerciseAmount(exercises.get(7), ex, 1);
        exerciseAmount.update(repo);
    }
}
