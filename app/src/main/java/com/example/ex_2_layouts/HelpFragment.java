package com.example.ex_2_layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HelpFragment extends Fragment {

    RecyclerView recyclerView;

    public HelpFragment(){
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState){
        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.profile_toolbar);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) appCompatActivity.setSupportActionBar(toolbar);

        ItemHelpFragmentModel itemHelpFragmentModel = new ItemHelpFragmentModel();
        recyclerView = view.findViewById(R.id.fragment_help_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        ListHelpAdapter helpAdapter = new  ListHelpAdapter(itemHelpFragmentModel.listItemHelpData());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(helpAdapter);
    }
}
