package com.example.foodieapp2;

import androidx.appcompat.app.AppCompatActivity;

public class FoodItem  {

    private String foodTitle;
    private String foodDescription;
    private int foodImage;
    private String foodIngredient;
    private int foodCalories;
    private String foodLink;


    FoodItem (String foodTitle, String foodDescription, int foodImage, String ingredients, int calories, String link){
        this.foodTitle = foodTitle;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;

        this.foodIngredient= ingredients;
        this.foodCalories = calories;
        this.foodLink = link;

    }

    FoodItem (String foodTitle, String foodDescription, int foodImage){
        this.foodTitle = foodTitle;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;

    }

    //getters

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public int getFoodCalories() { return foodCalories; }

    public String getFoodIngredient() { return foodIngredient; }

    public String getFoodLink() { return foodLink; }
}

