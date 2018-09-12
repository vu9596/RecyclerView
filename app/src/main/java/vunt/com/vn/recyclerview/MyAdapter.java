package vunt.com.vn.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Hero> mHeroes;
    private ItemSelectedListener mListener;

    public MyAdapter(ItemSelectedListener listener, ArrayList<Hero> heroes) {
        mHeroes = heroes;
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hero, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mListener, mHeroes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mHeroes != null ? mHeroes.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageview;
        public TextView mTextview;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.image_hero);
            mTextview = itemView.findViewById(R.id.text_hero_name);
        }

        public void bindData(final ItemSelectedListener listener, Hero hero, final int position) {
            if (hero != null) {
                mTextview.setText(hero.getName());
                mImageview.setImageResource(hero.getResourceImage());
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemSelectd(position);
                }
            });
        }
    }

    public interface ItemSelectedListener {
        void onItemSelectd(int position);
    }
}

