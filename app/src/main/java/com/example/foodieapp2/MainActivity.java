package com.example.foodieapp2;

import android.content.Intent;
import android.content.res.TypedArray;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<FoodItem> foodItems;
    private TypedArray foodImageResources;
    private FoodAdapter adapter;
public static final String TAG = "MainActivity";
    ActivityResultLauncher<Intent> startForResults = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d(TAG,"inside of onActivityResult");
//            super.onActivityResult(requestCode, resultCode, data);
            if (result != null && result.getResultCode() == RESULT_OK) {
                Log.d(TAG,"inside of RESULT_OK");

//              if(result.getData() != null && result.getResultCode().get)
                String foodTitle = result.getData().getExtras().getString("foodName");
                String foodDescription = result.getData().getExtras().getString("foodDescription");
                String ingredients = result.getData().getExtras().getString("ingredients");
                int calories = result.getData().getExtras().getInt("calories");
                String link = result.getData().getExtras().getString("Link");

                int def_Image = 11;
                int imageID = foodImageResources.getResourceId(def_Image, 0);
                FoodItem customItem = new FoodItem(foodTitle, foodDescription, imageID, ingredients, calories, link);

                foodItems.add(customItem);

                adapter.notifyDataSetChanged();
                Log.d(TAG,"END of RESULT_OK");

            }
            Log.d(TAG,"End of onActivityResult");

        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        foodItems = new ArrayList<>();
        adapter = new FoodAdapter(this, foodItems);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG,"Inside of onClick");
                Intent intent = new Intent(getApplicationContext(),AddItemToArrayList.class);
                startForResults.launch(intent);
                Log.d(TAG,"End of onClick");

            }

        });


        initializeList();


    }




    private void initializeList() {
        String[] foodList = getResources().getStringArray(R.array.food_titles);
        String[] foodDescription = getResources().getStringArray(R.array.food_Description);


        foodImageResources = getResources().obtainTypedArray(R.array.food_images);


       foodItems.clear();

        for (int i = 0; i <foodList.length; i++) {
           foodItems.add(new FoodItem(foodList[i], foodDescription[i], foodImageResources.getResourceId(i, 0)));
        }

        adapter.notifyDataSetChanged();

    }



//    public void onClick(View view) {
//        Intent intent = new Intent(MainActivity.this,AddItemToArrayList.class);
//
//        startForResults.launch(intent);
//
//    }


}

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==1 && resultCode == RESULT_OK){
//            //Intent intent = getIntent();
//            String foodTitle = result.getdata().getExtras().getString("foodName");
//            String foodDesc = data.getExtras().getString("foodDesc");
//            String ingredients = data.getExtras().getString("ingredients");
//            int calories = data.getExtras().getInt("calories");
//            String recipe = data.getExtras().getString("recipeUrl");
//
//            int def_Image = 7;
//            int imageID = mealImageResources.getResourceId(def_Image, 0);
//            FoodItem customItem = new FoodItem(foodTitle, foodDesc, imageID, ingredients, calories, recipe);
//
//            mealItems.add(customItem);
//
//            adapter.notifyDataSetChanged();
//
//        }
//    }
//}