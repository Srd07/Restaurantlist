package com.example.restaurantlist.ViewModel;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<String>> restaurantList;

    public LiveData<List<String>> getRestaurantList() {
        if (restaurantList == null) {
            restaurantList = new MutableLiveData<>();
            loadRestaurantList();
        }
        return restaurantList;
    }

    private void loadRestaurantList() {

        Handler myHandler = new Handler();

        myHandler.postDelayed(this::run, 5000);
    }

    private void run() {
        List<String> restaurantListSample = new ArrayList<>();
        restaurantListSample.add("Name : Indian Accent, Rating: 4 ,Address: Ernakulam Kerala ,  Speciality:Fishcurry ");
        restaurantListSample.add("Name :Punjab House,  Rating: 5  ,Address:shivajinagar,pune ,  Speciality:punjabi special thali");
        restaurantListSample.add("Name: BBQ Nation,  Rating :4.5  ,Address:Bandra,Mumbai ,   Speciality:Grilled corn");
        restaurantListSample.add("Name: Paragon ,   Rating :3 ,   Address:kozhikode,Kerala  ,  Speciality:Biryani");


        long seed = System.nanoTime();
        Collections.shuffle(restaurantListSample, new Random(seed));

        restaurantList.setValue(restaurantListSample);
    }
}
