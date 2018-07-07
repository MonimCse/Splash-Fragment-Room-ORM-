package org.login.com.threadfragmentroomnavigationbar.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.login.com.threadfragmentroomnavigationbar.db.dao.UserDao;
import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();

    public static AppDatabase newInstant(Context context)
    {
        return Room.databaseBuilder(context,AppDatabase.class,"my_account_db").allowMainThreadQueries().build();
    }
}
