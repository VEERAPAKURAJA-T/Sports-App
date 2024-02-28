package com.example.grocery_app;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

/*
So when you create a custom RecyclerView adapter,you need to extend
the RecyclerView adapter class.This is a fundamental part of using
RecyclerView widget to display list or grids of items, and extending class
means creating a new class that inherits the properties and behaviors of the parent class.
In this case,by extending RecyclerView dot adapter,you're creating a new class that
will customize the behavior of base RecyclerView dot adapter class to suit your
specific needs.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
//pass the name of the ViewHolder inside <>
   private List<item> itemList;

    public Myadapter(List<item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       /*Responsible for creating new view holders for your items.
       you inflate the item layout XML and return an instance of your
       custom ViewHolder class.SO,For that we create a view object item view equal
       to layout inflater.from
       LayoutInflater--the layout inflater class is used to inflate or create a view
       hierarchy from an XML layout resource.its an essential part of building UI components in android,
       allowing you to convert XML layout definitions into actual view objects that
       can be displayed on screen.
       In this ,we obtain an instance of layout inflater by calling its static method
       from and passing the passing the parent context.
        */
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        //the parent parameter is the parent view group that will eventually contain the inflated view.

        return new MyViewHolder(itemView);
        /*
        MyViewHolder will hold the references to the views within the inflated item layout
         and is used to efficiently access and manipulate these views when binding data.
        fist parameter: ViewGroup parent--The purpose of this parameter is to provide layout parameters to the layout inflater
         so the inflated view can be correctly sized and positioned within its parent.
         The second parameter: view type--
The view type parameter is used when your recycler view has multiple types of items.
This can be useful when you need different layouts or behaviors for different types of items.
For example, if your adapter handles different item layouts for headers, footers and regular items,
you can use the view type parameter to distinguish between them.
       */

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Binds the data from your dataset to the views within the view holder
        /*
        The holder parameter is an instance of your custom view holder class that we created before that holds
references to the views within the item layout.This holder was created and returned by Oncreate Viewholder method.
You use this holder to access and manipulate the views within the item layout.The second parameter is of type int called position.
The position parameter indicates the position of the item in the data set that you need to bind the
views.This position corresponds to the position of the item in the list that the recycler view is currently
displaying.
         */
        //It's called when a new item is scrolled onto the screen or when the contents of an item need to be updated.
        item  item=itemList.get(position);
        holder.textView.setText(item.getItemName());
        holder.textView2.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());

    }

    @Override
    public int getItemCount() {
        //Returns the total number of items in your dataset
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
          TextView textView,textView2;
          ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
            /*
            By storing references to these views, you avoid the need to call find view by ID every time you need
to access or update them.
And this is the constructor, the super and I'm passing the item view.
This line calls the constructor of the super class recycler view dot viewholder and passes the item
view parameter to it.This initialize the Viewholder with the root view of the item layout and this line of codes.
Use the find view by ID method to find and assign image, view and text views within the item view.
By doing this, the in the constructor you're performing the view lookups only once when the view holder
is created and not every time the item is bound in the on bind Viewholder method.By creating a custom view holder
that holds references to the views within the item layout, you are optimizing the performance of your recycler view.
The view holder acts as a cache for the views allowing you to efficiently access and manipulate the views during the
binding process.This separation of concerns helps keep your code responsive, especially when dealing with large data
sets.
          */
        }
    }

}

