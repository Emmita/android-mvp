package com.example.mvpexample.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvpexample.model.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface UserDAO {

    @Insert
    Completable addUser(User user);

    @Update
    Completable updateUser(User user);

    @Delete
    Completable deleteUser(User user);

    @Query("select * from users")
    Observable<List<User>> getAllUsers();

   // @Query("select * from users where id ==: userId")
   // User getUser(long userId);

}
