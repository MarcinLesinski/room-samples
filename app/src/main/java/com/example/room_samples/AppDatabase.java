package com.example.room_samples;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room_samples.embedded.EmbeddedUser;
import com.example.room_samples.embedded.EmbeddedUserDao;
import com.example.room_samples.one_to_one.OtoAddress;
import com.example.room_samples.one_to_one.OtoUser;
import com.example.room_samples.one_to_one.OtoUserDao;
import com.example.room_samples.one_to_one.OtoUserEntity;
import com.example.room_samples.simple_read_write.User;
import com.example.room_samples.simple_read_write.UserDao;

@Database(entities = {
        User.class,
        EmbeddedUser.class,
        OtoUserEntity.class,
        OtoAddress.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EmbeddedUserDao embeddedUserDao();
    public abstract OtoUserDao otoUserDao();
}
