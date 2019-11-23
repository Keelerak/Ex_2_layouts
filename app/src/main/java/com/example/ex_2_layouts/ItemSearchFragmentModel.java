package com.example.ex_2_layouts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemSearchFragmentModel {
    private String name;
    private List<ItemSearchFragmentModel> names;

    public String getName() {
        return name;
    }

    public ItemSearchFragmentModel(String name) {
        this.name = name;
    }

    public ItemSearchFragmentModel() {
    }

    public List<ItemSearchFragmentModel> ListName() {
        names = new ArrayList<>();
        names.add(new ItemSearchFragmentModel("\"Старость в радость\""));
        names.add(new ItemSearchFragmentModel("\"Старость в радость\""));
        names.add(new ItemSearchFragmentModel("\"Фонд помощи тяжелобольным детям\""));
        names.add(new ItemSearchFragmentModel("\"Фонд помощи тяжелобольным детям\""));
        names.add(new ItemSearchFragmentModel("\"Фонд помощи тяжелобольным детям\""));
        names.add(new ItemSearchFragmentModel("\"Фонд помощи тяжелобольным детям\""));
        names.add(new ItemSearchFragmentModel("\"Фонд продовольствия\""));
        names.add(new ItemSearchFragmentModel("\"Фонд продовольствия\""));
        names.add(new ItemSearchFragmentModel("\"Фонд накорми страну\""));
        names.add(new ItemSearchFragmentModel("\"Фонд накорми страну\""));
        names.add(new ItemSearchFragmentModel("\"Центр вселеннной\""));
        names.add(new ItemSearchFragmentModel("\"Центр вселеннной\""));
        names.add(new ItemSearchFragmentModel("\"Центр вселеннной\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));
        names.add(new ItemSearchFragmentModel("\"Фонд поддержки науки и образования\""));

        Collections.shuffle(names);
        return names;
    }


}
