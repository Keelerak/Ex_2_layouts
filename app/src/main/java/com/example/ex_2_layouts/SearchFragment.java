package com.example.ex_2_layouts;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class SearchFragment extends Fragment {


    public SearchFragment() {
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState) {
        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.search_toolbar);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) appCompatActivity.setSupportActionBar(toolbar);


        FragmentSearchViewPagerAdapter adapter = new FragmentSearchViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.fragment_search_view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.fragment_search_view_pager_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //menu.clear();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);


        SearchView searchView = (SearchView) item.getActionView();
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setBackgroundColor(Color.WHITE);
        item.getIcon().mutate().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }


    private static class FragmentSearchViewPagerAdapter extends FragmentPagerAdapter {

        int VALUE_PAGES = 2;

        public FragmentSearchViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragSearchOnActions();
                case 1:
                    return new FragSearchOnNPO();

                default:
                    return new FragSearchOnActions();
            }

        }

        @Override
        public int getCount() {
            return VALUE_PAGES;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ПО МЕРОПРИЯТИЯМ";
                case 1:
                    return "ПО НКО";

                default:
                    return null;
            }
        }
    }


}
