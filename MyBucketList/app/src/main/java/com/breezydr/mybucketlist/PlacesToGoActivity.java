package com.breezydr.mybucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlacesToGoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_go);
        setupList();
    }

    private void setupList() {
        BucketListEntry[] placesToGo = {
                new BucketListEntry("Vietnam", "Going to the islands", R.drawable.vietnam, 5),
                new BucketListEntry("Kerala, India", "So many tea flavors", R.drawable.kerala, 4),
                new BucketListEntry("Japan", "Go to the bamboo forest", R.drawable.japan, 4.5f),
                new BucketListEntry("Iceland", "Go to the waterfalls", R.drawable.iceland, 3),
                new BucketListEntry("The Amazon, Brazil", "Survive", R.drawable.amazon, 3.5f)
        };
        RecyclerView recyclerView = findViewById(R.id.recycler_view_places_to_go);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(placesToGo);
        recyclerView.setAdapter(adapter);
    }
}