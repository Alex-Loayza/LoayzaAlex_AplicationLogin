package com.example.aplicationlgin.DB;

import android.provider.BaseColumns;

public class tableRecetas {
    private tableRecetas(){}

    //The table structure is created.
    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME ="recetas";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
    }

}
