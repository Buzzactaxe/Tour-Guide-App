package com.example.android.tourappbari;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourappbari.Item;
import com.example.android.tourappbari.ItemAdapter;
import com.example.android.tourappbari.R;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }
    public RestaurantFragment() {
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
        items.add(new Item(context.getString(R.string.rino), context.getString(R.string.la_uascezze), R.drawable.uascezze));
        items.add(new Item(context.getString(R.string.travi), context.getString(R.string.le_travi), R.drawable.letravi));
        items.add(new Item(context.getString(R.string.gambero), context.getString(R.string.il_gambero), R.drawable.gambero));
        items.add(new Item(context.getString(R.string.arpie), context.getString(R.string.le_arpie), R.drawable.le_arpie));

        ItemAdapter adapter = new ItemAdapter(context, items, R.color.colorRestaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position);

                //Description
                View description = view.findViewById(R.id.description);

                ExpandAnimation expAmation = new ExpandAnimation(description, 500);

                //Start Animation on description
                description.startAnimation(expAmation);
            }
        });

        return rootView;
    }
}
