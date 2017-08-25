package com.example.lipengyuan.jlcl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lipengyuan.jlcl.fragment.RightFragment;
import com.example.lipengyuan.jlcl.fragment.fragmentActivity;
import com.example.lipengyuan.jlcl.fragment.leftFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager1;
    private com.example.lipengyuan.jlcl.fragment.leftFragment leftFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        startActivityForResult(intent , 1);

        Button btn = (Button)findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//
                String str = "hello new 23";
//                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                Intent intent2 = new Intent(MainActivity.this, fragmentActivity.class);

//                intent2.putExtra("data",str);
//
//                startActivityForResult(intent2 , 1);

                startActivity(intent2);
            }
        });
        fragmentManager1 = getSupportFragmentManager();

    }

    /*
     * 添加碎片
     *
     * */

    public void  addFragment(View view) {

        Fragment fragment = fragmentManager1.findFragmentByTag("fragment");
        if (fragment == null) {
            FragmentTransaction transaction = fragmentManager1.beginTransaction();
            leftFragment = new leftFragment();
            transaction.add(R.id.testFragment, leftFragment, "fragment");
            transaction.addToBackStack(null);
            transaction.commit();
        }
}

     /*
      * 删除碎片
      *
      * */
    public void removeFragment(View view){
        Fragment fragment = fragmentManager1.findFragmentByTag("fragment");
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager1.beginTransaction();
            transaction.remove(fragmentManager1.findFragmentByTag("fragment"));
            transaction.commit();
        }

    }
//替换
    public void replaceFragment(View view){
        Fragment fragment = fragmentManager1.findFragmentByTag("fragment");
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager1.beginTransaction();
            RightFragment rightFragment = new RightFragment();
            TextView textView = (TextView) leftFragment.getView().findViewById(R.id.leftTV);
            Bundle bundle = new Bundle();
            bundle.putString("item", textView.getText().toString());
            rightFragment.setArguments(bundle);

            transaction.replace(R.id.testFragment, rightFragment,"fragment");

            transaction.commit();
        }
    }
//显示
    public void showFragment(View view) {
        Fragment fragment = fragmentManager1.findFragmentByTag("fragment");
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager1.beginTransaction();
            transaction.show(fragmentManager1.findFragmentByTag("fragment"));
            transaction.commit();
        }
    }
//隐藏
    public void hideFragment(View view) {
        Fragment fragment = fragmentManager1.findFragmentByTag("fragment");
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager1.beginTransaction();
            transaction.hide(fragmentManager1.findFragmentByTag("fragment"));
            transaction.commit();
        }
    }


    public void PostNet(View view){

    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                // TODO
                if (resultCode == RESULT_OK)
                {
                    String getData = data.getStringExtra("firstone");
                    Log.d("TAG", getData);
                }
                break;

            default:
                break;
        }
    }
}
