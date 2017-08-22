package com.example.lipengyuan.jlcl.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lipengyuan.jlcl.R;

/**
 * Created by lipengyuan on 2017/8/22.
 */

public class RightFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fragment,container,false);
        TextView textView = view.findViewById(R.id.textView1);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String item = bundle.getString("item");
            textView.setText(item);
        }
        return view;
    }
}
