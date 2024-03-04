package com.breezydr.mybucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);
        setupList();

    }

    private void setupList() {
        BucketListEntry[] thingsToDo = {
                new BucketListEntry("Climb Mt Kilimanjaro", "Do it the difficult way", R.drawable.kilimanjaro, 5),
                new BucketListEntry("Northern Lights", "Somewhere in Norway", R.drawable.northern_lights, 4),
                new BucketListEntry("Road trip", "Hire a car on west coast, drive to east coast", R.drawable.road_trip, 4.5f),
                new BucketListEntry("Scuba dive", "In Thailand", R.drawable.scubadive, 3),
                new BucketListEntry("Skydive", "Maybe in Grand Canyon", R.drawable.skydive, 3.5f)
        };
        RecyclerView recyclerView = findViewById(R.id.recycler_view_things_to_do);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(thingsToDo);
        recyclerView.setAdapter(adapter);
    }
}