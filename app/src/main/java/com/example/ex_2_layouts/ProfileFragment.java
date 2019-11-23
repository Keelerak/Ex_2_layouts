package com.example.ex_2_layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ProfileFragment extends Fragment {

    ProfileDialogChangePhotoFragment dialogChange;

    public ProfileFragment() {
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState) {
        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.profile_toolbar);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) appCompatActivity.setSupportActionBar(toolbar);

        ImageView photoUser = view.findViewById(R.id.image_man_image_view);
        photoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    FragmentManager fragmentManager =
                            getActivity().getSupportFragmentManager();
                    dialogChange = new ProfileDialogChangePhotoFragment();
                    dialogChange.show(fragmentManager, "dialogFragment");
                }
            }
        });
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }


}
