package com.example.mvpexample.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvpexample.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase database;

    public abstract UserDAO getUserDAO();

    public static UserDatabase getDatabase(Context context){

        if (database == null){

            database = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-db").build();

        }

        return database;

    }

}
