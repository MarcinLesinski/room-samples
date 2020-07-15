package com.example.room_samples.one_to_one;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public abstract class  OtoUserDao
{
    @Transaction
    @Query("select * from OtoUserEntity")
    public abstract List<OtoUser> getUsers();

    //way 1
    @Transaction
    public long insertUser(OtoUser user)
    {
        long userId = insertUserEntity(user.user);
        user.otoAddress.user_id = userId;
        insertAddress(user.otoAddress);
        return userId;
    }

    @Insert
    protected abstract long insertUserEntity(OtoUserEntity user);

    @Insert
    protected abstract long insertAddress(OtoAddress adres);

}
