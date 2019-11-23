package com.example.ex_2_layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_in_main, new HelpFragment());
        transaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigtion_help);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Fragment selectedFragment = null;
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    switch (item.getItemId()) {
                        case R.id.bottom_navigtion_news:
                            //   selectedFragment = new NewsFragment();
                            transaction.replace(R.id.fragment_container_in_main, new NewsFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_search:

                            transaction.replace(R.id.fragment_container_in_main, new SearchFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_help:

                            transaction.replace(R.id.fragment_container_in_main, new HelpFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_history:

                            transaction.replace(R.id.fragment_container_in_main, new HistoryFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_profile:

                            transaction.replace(R.id.fragment_container_in_main, new ProfileFragment());
                            transaction.commit();
                            break;
                    }


                    return true;

                }
            };


}
