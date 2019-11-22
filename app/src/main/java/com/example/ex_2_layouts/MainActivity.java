package com.example.ex_2_layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_in_main, new ProfileFragment());
        transaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigtion_profile);


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
                           // selectedFragment = new SearchFragment();
                            transaction.replace(R.id.fragment_container_in_main, new SearchFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_help:
                          //  selectedFragment = new HelpFragment();
                            transaction.replace(R.id.fragment_container_in_main, new HelpFragment());
                            transaction.commit();
                            break;
                        case R.id.bottom_navigtion_history:
                         //   selectedFragment = new HistoryFragment();
                           transaction.replace(R.id.fragment_container_in_main, new HistoryFragment());
                           transaction.commit();
                            break;
                        case R.id.bottom_navigtion_profile:
                         //   selectedFragment = new ProfileFragment();
                            transaction.replace(R.id.fragment_container_in_main, new ProfileFragment());
                            transaction.commit();
                            break;
                    }

                   // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_main,
                   //         selectedFragment).commit();

                    return true;
                   // return false;
                }
            };


}
