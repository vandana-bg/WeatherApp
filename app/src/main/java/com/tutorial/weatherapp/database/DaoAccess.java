package com.tutorial.weatherapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask(Favourite note);


    @Query("SELECT * FROM Favourite ORDER BY created_at desc")
    List<Favourite> retrieveAllTasks();


    @Query("SELECT * FROM Favourite WHERE id =:taskId")
    LiveData<Favourite> getTask(int taskId);


    @Update
    void updateTask(Favourite note);


    @Delete
    void deleteTask(Favourite note);


    @Query("DELETE FROM Favourite WHERE id = :id")
    public void deleteById(String id);
}