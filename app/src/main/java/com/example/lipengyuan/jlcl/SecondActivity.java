package com.example.lipengyuan.jlcl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.fruitAdapter;
import model.Fruit;

public class SecondActivity extends AppCompatActivity {

    private String[] fruitData = {"apple","banana","orange","pear","cherry","mango","grape","melon","apple","banana","orange","pear","cherry","mango","grape","melon"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //获取上个页面传递过来的data参数
        final Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        Log.d("LOG-str",str);

        //点击btn2返回按钮回传参数
//        Button btn2 = (Button)findViewById(R.id.btn2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//               Intent intent = new Intent();
//               intent.putExtra("first", "welcome 23 back ");
//               setResult(MainActivity.RESULT_OK, intent);
//               finish();
//
//           }
//        });

        initFruits();//初始化数据


        fruitAdapter adapter = new fruitAdapter(SecondActivity.this,R.layout.fruit_item,fruitList);

        ListView listV = (ListView)findViewById(R.id.listV);
        listV.setAdapter(adapter);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("position", "position = " +position);

                Log.d("l","i= "+l);

                Fruit fruit = fruitList.get(position);
//                Toast.makeText(SecondActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SecondActivity.this,RecyclerActivity.class);
                startActivity(intent);

            }
        });


    }

    //点击返回按钮回传参数
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("firstone", "welcome back 23 ");
        setResult(MainActivity.RESULT_OK, intent);
        finish();
    }

    private void initFruits(){

    for (int i = 0 ;i<2;i++){

        Fruit apple = new Fruit("apple",R.mipmap.apple);
        fruitList.add(apple);

        Fruit banana = new Fruit("banana",R.mipmap.banana);
        fruitList.add(banana);

        Fruit orange = new Fruit("orange",R.mipmap.orange);
        fruitList.add(orange);

        Fruit pear = new Fruit("pear",R.mipmap.pear);
        fruitList.add(pear);

        Fruit cherry = new Fruit("cherry",R.mipmap.cherry);
        fruitList.add(cherry);

        Fruit mango = new Fruit("mango",R.mipmap.mango);
        fruitList.add(mango);

        Fruit grape = new Fruit("grape",R.mipmap.grape);
        fruitList.add(grape);

        Fruit melon = new Fruit("melon",R.mipmap.melon);
        fruitList.add(melon);


    }

    }
}
