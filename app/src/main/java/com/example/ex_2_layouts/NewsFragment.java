package com.example.ex_2_layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {

    public NewsFragment(){
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState){
        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.profile_toolbar);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) appCompatActivity.setSupportActionBar(toolbar);


    }
}