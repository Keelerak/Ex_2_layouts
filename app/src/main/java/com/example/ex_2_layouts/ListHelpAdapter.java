package com.example.ex_2_layouts;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListHelpAdapter extends RecyclerView.Adapter<ListHelpAdapter.HelpViewHolder> {

    //private List<ListCountryModel> listCountryposts;
    private List<ItemHelpFragmentModel> listItemHelp;


    public ListHelpAdapter(List<ItemHelpFragmentModel> listItemHelp) {
        this.listItemHelp = listItemHelp;
    }

    @Override
    public HelpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_recycler_view_item, parent, false);
        return new HelpViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HelpViewHolder holderHelp, int position) {
        holderHelp.helpTitleTextView.setText(listItemHelp.get(position).getTitle());
        holderHelp.helpImageView.setImageResource(listItemHelp.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return listItemHelp.size();
    }

    public class HelpViewHolder extends RecyclerView.ViewHolder {
        CardView cardHelpView;
        TextView helpTitleTextView;
        ImageView helpImageView;

        public HelpViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHelpView = itemView.findViewById(R.id.help_item_card_view);
            helpTitleTextView = itemView.findViewById(R.id.help_item_card_view_text_view);
            helpImageView = itemView.findViewById(R.id.help_item_card_view_image_view);
        }
    }

}
