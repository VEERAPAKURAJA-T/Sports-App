package com.example.grocery_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1-adapter view
    RecyclerView recyclerView;
    //2-Data source
    List<item> itemList;
    //3-adapter
    Myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        itemList= new ArrayList<>();
        item i1=new item(R.drawable.apple,"Apple","aaa");
        item i2=new item(R.drawable.dragon_fruit,"Dragon fruit","aaa");
        item i3=new item(R.drawable.guva,"Guva","aaa");
        item i4=new item(R.drawable.mango,"Mango","aaa");
        item i5=new item(R.drawable.straw,"Strawberry","aaa");
        item i6=new item(R.drawable.watermelon,"Watermelon","aaa");

        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);
        itemList.add(i5);
        itemList.add(i6);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       adapter=new Myadapter(itemList);
       recyclerView.setAdapter(adapter);
       /*
       If we run, we can't see the items of the recycler view because we need to add
       the linear layout managers that allows us to arrange and display items in a linear.
        vertically scrolling list
        */


    }
}
