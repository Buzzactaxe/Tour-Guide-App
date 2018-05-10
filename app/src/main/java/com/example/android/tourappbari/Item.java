package com.example.android.tourappbari;


/**
 * Item represents a specific Item in the tour guide category.
 * it contains a Name, description and image(if needed).
 */
public class Item {

    //Item name
    private String mItemName;

    //Item description
    private String mItemDescription;

    //Constant Value that represents no image was given to this Item.
    private static final int NO_IMAGE_PROVIDED = 0 -1;

    //Image resource provided for the Item;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new Item object.
     *
     * @param itemName        is the name of the element
     * @param itemDescription is the description of the element
     */
    public Item (String itemName, String itemDescription) {

        mItemName = itemName;
        mItemDescription = itemDescription;
    }

    /**
     * Create a new Item object.
     *
     * @param itemName        is the name of the element
     * @param itemDescription is the description of the element
     */
    public Item (String itemName, String itemDescription, int imageResourceId) {

        mItemName = itemName;
        mItemDescription = itemDescription;
        mImageResourceId = imageResourceId;
    }

    //Get Name of Item
    public String getmItemName(){ return mItemName;}

    //Get Item Description
    public String getItemDescription() {return mItemDescription;}

    //Return item ImageResourceId
    public int getImageResourceId() { return mImageResourceId;}

    //Return if Item has Image or not
    public boolean hasImage() {return mImageResourceId != NO_IMAGE_PROVIDED;}


}
