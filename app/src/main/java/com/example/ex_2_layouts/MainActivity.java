package com.example.ex_2_layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.profile_toolbar);
       // setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigtion_profile);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.bottom_navigtion_news:
                            selectedFragment = new NewsFragment();
                            break;
                        case R.id.bottom_navigtion_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.bottom_navigtion_help:
                            selectedFragment = new HelpFragment();
                            break;
                        case R.id.bottom_navigtion_history:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.bottom_navigtion_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


}
