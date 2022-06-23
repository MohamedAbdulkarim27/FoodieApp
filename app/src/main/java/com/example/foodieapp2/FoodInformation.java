package com.example.foodieapp2;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FoodInformation extends AppCompatActivity {


    private TextView foodTitle;
    private ImageView foodImage;
    private TextView foodDescription;
    private int index;
    private TextView foodCalories;
    private TextView foodIngredients;
    private TextView foodLinks;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_information);

        foodTitle = (TextView)findViewById(R.id.expandFood_title);
        foodImage = (ImageView)findViewById(R.id.expandFood_image);
        foodDescription = (TextView)findViewById(R.id.expandFood_description);
        foodCalories = (TextView)findViewById(R.id.expandFood_calories);
        foodIngredients = (TextView)findViewById(R.id.expandFood_ingredients);
        foodLinks = (TextView)findViewById(R.id.expandFood_link);
        button = findViewById(R.id.button);


        Intent intent = getIntent();
        String food_Title = intent.getExtras().getString("FoodTitle");
        String food_Description = intent.getExtras().getString("FoodDescription");
        //pass
        String food_Ingredient = intent.getExtras().getString("FoodIng");
        String food_calories = String.valueOf(intent.getExtras().getInt("FoodCalories")) + " calories.";
        String food_link = intent.getExtras().getString("FoodLink");

        int food_Image = intent.getExtras().getInt("FoodImage");
        index = intent.getExtras().getInt("FoodIndex");

        if(food_Ingredient==null){addExtra(index);}

        else{
            foodCalories.setText(food_calories);
            foodLinks.setText(food_link);
            foodIngredients.setText(food_Ingredient);}

        foodTitle.setText(food_Title);
        Glide.with(this).load(food_Image).into( foodImage);
        foodDescription.setText(food_Description);

    }

    public void addExtra(int index){
        String[]  foodCaloriesList = getResources().getStringArray(R.array.food_calories);
        String[] foodRecList = getResources().getStringArray(R.array.food_links);
        String[] foodIngredientList = getResources().getStringArray(R.array.food_ingredients);


        foodCalories.setText( foodCaloriesList[index]);
        foodLinks.setText( foodRecList[index]);
         foodIngredients.setText( foodIngredientList[index]);


    }

    public void openLink(View view) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse( foodLinks.getText().toString()));
        startActivity(webIntent);

    }
    public void onClick(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}