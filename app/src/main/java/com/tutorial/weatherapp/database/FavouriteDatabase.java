package com.tutorial.weatherapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Favourite.class}, version = 1, exportSchema = false)
public abstract class FavouriteDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}