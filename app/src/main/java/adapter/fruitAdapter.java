package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lipengyuan.jlcl.R;

import java.util.List;

import model.Fruit;

/**
 * Created by lipengyuan on 2017/8/16.
 */

public class fruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public fruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent){

        Fruit fruit = getItem(position);
        View view;

        ViewHolder viewHolder;

        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruitImage);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruitName);
            view.setTag(viewHolder); //把viewholder存在view里
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();//重新获取viewholder
        }

//        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruitImage);
//        TextView fruitName = (TextView)view.findViewById(R.id.fruitName);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;

    }


    class ViewHolder{

        ImageView fruitImage;
        TextView fruitName;
    }

}
