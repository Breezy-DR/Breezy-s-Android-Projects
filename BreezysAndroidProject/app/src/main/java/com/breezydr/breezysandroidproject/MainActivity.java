package com.breezydr.breezysandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView list = findViewById(R.id.recycler_view_projects);

        Project[] projects = {
                new Project("Getting started app",
                        "Our very first default hello world",
                        R.drawable.getting_started),
                new Project("BMI calculator app",
                        "Calculating BMI",
                        R.drawable.calculator),
                new Project("Hungry developer app",
                        "A list of recipes of a fictional restaurant",
                        R.drawable.hungry_developer)
        };

        ProjectsAdapter adapter = new ProjectsAdapter(projects);

        list.setAdapter(adapter);
    }
}