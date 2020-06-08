package com.example.android.pokdex;

class TypeList {

    public String mTypeImageUrl;
    public String mTypeName;



    public TypeList(String typeName, String typeImageUrl) {
        mTypeName = typeName;
        mTypeImageUrl = typeImageUrl;
    }

    public String getTypeName() {
        return mTypeName;
    }

    public String getTypeImageUrl() {
        return mTypeImageUrl;
    }
}
