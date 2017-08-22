package com.example.lipengyuan.jlcl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.FruitAdaper;
import model.Fruit;

public class RecyclerActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        initFruits();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //横向排列
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdaper adaper = new FruitAdaper(fruitList);
        recyclerView.setAdapter(adaper);

    }

    private void initFruits() {

        for (int i = 0; i < 2; i++) {

            Fruit apple = new Fruit("apple", R.mipmap.apple);
            fruitList.add(apple);

            Fruit banana = new Fruit("banana", R.mipmap.banana);
            fruitList.add(banana);

            Fruit orange = new Fruit("orange", R.mipmap.orange);
            fruitList.add(orange);

            Fruit pear = new Fruit("pear", R.mipmap.pear);
            fruitList.add(pear);

            Fruit cherry = new Fruit("cherry", R.mipmap.cherry);
            fruitList.add(cherry);

            Fruit mango = new Fruit("mango", R.mipmap.mango);
            fruitList.add(mango);

            Fruit grape = new Fruit("grape", R.mipmap.grape);
            fruitList.add(grape);

            Fruit melon = new Fruit("melon", R.mipmap.melon);
            fruitList.add(melon);


        }

    }
}
