package com.example.mapsdemoridery.room;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHelper {

    private static DatabaseHelper _INSTANCE = null;
    private AppDatabase appDatabase;

    private DatabaseHelper(Context context) {
        appDatabase = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "mapsDemoRideryRoom.db"
        ).allowMainThreadQueries().build();
    }

    public static DatabaseHelper getInstance(Context context) {
        if (_INSTANCE == null) {
            _INSTANCE = new DatabaseHelper(context);
        }
        return(_INSTANCE);
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
