package com.qoolqas.moviesql.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.qoolqas.moviesql.Adapter.ViewPagerAdapter;
import com.qoolqas.moviesql.Fragment.FavoriteMovie;
import com.qoolqas.moviesql.Fragment.FavoriteTv;
import com.qoolqas.moviesql.Fragment.FragmentMovie;
import com.qoolqas.moviesql.Fragment.TvFragment;
import com.qoolqas.moviesql.R;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FavoriteMovie(), "Favorite Movie");
        adapter.AddFragment(new FavoriteTv(), "Favorite TV");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setElevation(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_change_settings) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        if (id == R.id.favorite){
            return true;
        }
        if (id == R.id.mainmenu){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

