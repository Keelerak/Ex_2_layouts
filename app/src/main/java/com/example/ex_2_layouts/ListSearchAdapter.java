package com.example.ex_2_layouts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListSearchAdapter extends RecyclerView.Adapter<ListSearchAdapter.SearchResultViewHolder> {
    List<ItemSearchFragmentModel> names;

    public ListSearchAdapter(List<ItemSearchFragmentModel> resultData) {
        this.names = resultData;
    }

    @NonNull

    public SearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recycle_item, parent, false);
        return new SearchResultViewHolder(view);
    }


    public void onBindViewHolder(@NonNull SearchResultViewHolder holder, int position) {
        holder.resultSearchTextView.setText(names.get(position).getName());
    }

    public int getItemCount() {
        return names.size();
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder {

        TextView resultSearchTextView;

        public SearchResultViewHolder(@NonNull View itemView) {
            super(itemView);
            resultSearchTextView = itemView.findViewById(R.id.search_recycler_item_text_view);
        }
    }
}
