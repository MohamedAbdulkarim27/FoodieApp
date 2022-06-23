package com.example.foodieapp2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemToArrayList extends AppCompatActivity {


    private EditText foodName_view;
    private EditText foodDescription_view;
    private EditText ingredients_view;
    private EditText calories_view;
    private EditText link_view;


    private String foodName;
    private String foodDescription;
    private String ingredients;
    private int calories;
    private String link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_array_list);

        foodName_view = (EditText) findViewById(R.id.foodName_editText);
        foodDescription_view = (EditText) findViewById(R.id.foodDescription_editText);
        ingredients_view = (EditText) findViewById(R.id.ingredients_editText);
        calories_view = (EditText) findViewById(R.id.calories_editText);
        link_view = (EditText) findViewById(R.id.link_editText);


    }


    public void createNewItem(View view) {
        foodName = foodName_view.getText().toString();
        foodDescription = foodDescription_view.getText().toString();
        ingredients = ingredients_view.getText().toString();
        calories = Integer.parseInt(calories_view.getText().toString());
        link = link_view.getText().toString();

        Intent sendBack = new Intent();
        sendBack.putExtra("foodName", foodName);
        sendBack.putExtra("foodDescription", foodDescription);
        sendBack.putExtra("ingredients", ingredients);
        sendBack.putExtra("calories",calories);
        sendBack.putExtra("link", link);

        setResult(RESULT_OK,sendBack);
        finish();

    }


    public void onClick(View view) {

    }
}