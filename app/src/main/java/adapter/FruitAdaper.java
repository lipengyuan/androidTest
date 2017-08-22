package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lipengyuan.jlcl.R;

import java.util.List;

import model.Fruit;

/**
 * Created by lipengyuan on 2017/8/18.
 */

public class FruitAdaper extends RecyclerView.Adapter<FruitAdaper.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        View fruitView;

        public ViewHolder(View view){

            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruitImage);
            fruitName = (TextView) view.findViewById(R.id.fruitName);
        }

    }

    public FruitAdaper(List<Fruit> fruitList){

        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);

        final ViewHolder holder = new ViewHolder(view);

        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Log.d("F name ", fruit.getName());

            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Log.d("F image ", fruit.getName());
            }
        });

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
//        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
