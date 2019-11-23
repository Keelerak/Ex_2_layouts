package com.example.ex_2_layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragSearchOnActions extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_search_on_actions, container, false);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ItemSearchFragmentModel itemSearchFragmentModel
                = new ItemSearchFragmentModel();
        RecyclerView recyclerView = view.findViewById(R.id.fragment_search_view_pager_event_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        ListSearchAdapter adapter = new ListSearchAdapter(itemSearchFragmentModel.ListName());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        TextView text = view.findViewById(R.id.fragment_search_view_pager_event_fragment_text_view);
        text.setText("Ключевые слова: мастер-класс, помощь\n" +
                "Результаты поиска: 109  мероприятий");
    }
}


