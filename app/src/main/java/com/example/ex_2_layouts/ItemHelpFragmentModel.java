package com.example.ex_2_layouts;

import java.util.ArrayList;
import java.util.List;

public class ItemHelpFragmentModel {

    private String title;
    private int value;
    private List<ItemHelpFragmentModel> listItemHelp;

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }


    public ItemHelpFragmentModel(String title, int value) {
        this.title = title;
        this.value = value;
    }

    public List<ItemHelpFragmentModel> listItemHelpData() {
        listItemHelp = new ArrayList<>();
        listItemHelp.add(new ItemHelpFragmentModel("Дети", R.drawable.child_image));
        listItemHelp.add(new ItemHelpFragmentModel("Взрослые", R.drawable.man_image));
        listItemHelp.add(new ItemHelpFragmentModel("Пожилые", R.drawable.old_image));
        listItemHelp.add(new ItemHelpFragmentModel("Животные", R.drawable.cat_image));
        listItemHelp.add(new ItemHelpFragmentModel("Мероприятия", R.drawable.event_image));

        return listItemHelp;
    }

    public ItemHelpFragmentModel() {

    }


}
