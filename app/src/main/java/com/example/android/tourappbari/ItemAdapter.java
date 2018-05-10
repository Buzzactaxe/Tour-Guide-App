package com.example.android.tourappbari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<Item> {

    /**
     * Resource ID for the background color for each list of items
     */
    private int mColorResourceId;

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param items        is the list of {@link Item}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of elements
     */
    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);

        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Chechking if any views are being reused, if not inflate view
        View listItemView = convertView;
        if(listItemView == convertView) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Get the object located in the position on the list
        Item currentItem = getItem(position);

        //Find textView in the ListItem.xml with ID of textView name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        // Get the name from the currentItem object and set this text on
        // the name TextView.
        nameTextView.setText(currentItem.getmItemName());

        //Find textView in the ListItem.xml with ID of textView description
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the name from the currentItem object and set this text on
        // the name TextView.
        descriptionTextView.setText(currentItem.getItemDescription());


        //Find textView in the ListItem.xml with ID of textView description
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // check if an image has been added to the Item or not
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageResourceId());
            //assure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View listItem = listItemView.findViewById(R.id.list_item);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the list item View
        listItem.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;


    }
}
