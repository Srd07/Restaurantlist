package com.example.restaurantlist.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.os.Bundle;
import com.example.restaurantlist.R;
import com.example.restaurantlist.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)
                findViewById(R.id.list);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar); progressBar.setVisibility(View.VISIBLE);

        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.getRestaurantList().observe(this, restaurantList -> {

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    restaurantList);

            listView.setAdapter(adapter);

            progressBar.setVisibility(View.GONE);
        });

    }
}