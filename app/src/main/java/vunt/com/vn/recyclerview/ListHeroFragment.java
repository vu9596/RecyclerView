package vunt.com.vn.recyclerview;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListHeroFragment extends Fragment {
    public static final String TAG = "ListHeroFragment";
    private ArrayList<Hero> mHeroes;

    private MyAdapter.ItemSelectedListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (MyAdapter.ItemSelectedListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_hero, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView recycler = view.findViewById(R.id.recycler_list_hero);
        recycler.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(mListener, mHeroes);
        recycler.setAdapter(adapter);
    }

    private void initData() {
        mHeroes = new ArrayList<>();
        mHeroes.add(new Hero(getString(R.string.spider_name), R.drawable.spider));
        mHeroes.add(new Hero(getString(R.string.iron_man), R.drawable.ironman));
        mHeroes.add(new Hero(getString(R.string.venom), R.drawable.venom));
        mHeroes.add(new Hero(getString(R.string.thor), R.drawable.thor));
        mHeroes.add(new Hero(getString(R.string.bat_man), R.drawable.batman));
        mHeroes.add(new Hero(getString(R.string.dead_pool), R.drawable.deadpool));
    }
}

