package vunt.com.vn.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemSelectedListener {
    private ListHeroFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = new ListHeroFragment();
        getFragmentManager().beginTransaction().add(R.id.frame_container, mFragment).commit();
    }

    @Override
    public void onItemSelectd(int position) {
        Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
    }
}
