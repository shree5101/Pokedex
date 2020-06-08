package com.example.android.pokdex;

class ItemList {

    public String mItemImageUrl;
    public String mItemName;



    public ItemList(String itemName, String itemImageUrl) {
        mItemName = itemName;
        mItemImageUrl = itemImageUrl;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getItemImageUrl() {
        return mItemImageUrl;
    }
}
