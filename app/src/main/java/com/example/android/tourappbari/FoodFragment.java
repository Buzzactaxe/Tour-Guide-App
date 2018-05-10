package com.example.android.tourappbari;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }
    public FoodFragment() {
        //Needs empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        //Root View
        View rootView = inflater.inflate(R.layout.descript_list, container, false);

        //Context
        Context context = getActivity();

        //Create an ArrayList of Items
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(context.getString(R.string.patate_riso_cozze), context.getString(R.string.patate_cozze_description),R.drawable.riso_patate_cozze));
        items.add(new Item(context.getString(R.string.fave_cicorie), context.getString(R.string.fave_cicoria_description), R.drawable.fave_cicorie));
        items.add(new Item(context.getString(R.string.panzerotti), context.getString(R.string.panzerotti_description), R.drawable.panzerotti));
        items.add(new Item(context.getString(R.string.focaccia), context.getString(R.string.focaccia_description), R.drawable.focaccia));

        ItemAdapter adapter = new ItemAdapter(context, items, R.color.colorFood);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position);

                //Description
                View description = view.findViewById(R.id.description);

                ExpandAnimation expAmation = new ExpandAnimation(description, 450);

                //Start Animation on description
                description.startAnimation(expAmation);
            }
        });

        return rootView;
    }
}
