package org.login.com.threadfragmentroomnavigationbar.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> getAll();

    @Query("select * from User where email=:email and password=:password")
    User checkLogin(String email,String password);

    @Insert
    long insert(User user);

    @Insert
    void insert(List<User> users);
}
