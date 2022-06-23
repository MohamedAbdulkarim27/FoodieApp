package com.example.foodieapp2;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
//import android.widget.
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private ArrayList<FoodItem> foodItems;
    private Context context;

    public FoodAdapter(Context context, ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
        this.context = context;

    }


    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_food_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final FoodAdapter.ViewHolder holder, int position) {
         FoodItem currentFoodItem = foodItems.get(position);
        Glide.with(context).load(currentFoodItem.getFoodImage()).into(holder.foodImage);
        holder.bindTo(currentFoodItem);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expandFood = new Intent(context, FoodInformation.class);
                expandFood.putExtra("FoodImage", currentFoodItem.getFoodImage());
                expandFood.putExtra("FoodTitle", currentFoodItem.getFoodTitle());
                expandFood.putExtra("FoodDescription", currentFoodItem.getFoodDescription());
                expandFood.putExtra("FoodIndex", position);


                expandFood.putExtra("FoodIngIngredient", currentFoodItem.getFoodIngredient());
                expandFood.putExtra("FoodCalories",currentFoodItem.getFoodCalories());
                expandFood.putExtra("FoodLink",currentFoodItem.getFoodLink());

                context.startActivity(expandFood);

            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.alertDialog_title);
                builder.setMessage(R.string.alertDialog_message);
                builder.setNegativeButton(R.string.alertDialog_neg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton(R.string.alertDialog_pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        foodItems.remove(holder.getAdapterPosition());
                        FoodAdapter.this.notifyItemRemoved(holder.getAdapterPosition());
                    }
                });
                AlertDialog error = builder.create();
                error.show();
                return false;
            }
        });



    }



    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView foodTitleText;
        private TextView foodDescriptionText;
        private ImageView foodImage;
        private CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);

            foodTitleText = (TextView) itemView.findViewById(R.id.food_title);
            foodDescriptionText = (TextView) itemView.findViewById(R.id.food_description);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }



        void bindTo(FoodItem currentFood) {
            foodTitleText.setText(currentFood.getFoodTitle());
            foodDescriptionText.setText(currentFood.getFoodDescription());
        }

    }

}