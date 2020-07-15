package com.example.room_samples.embedded;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface EmbeddedUserDao {
    @Insert
    void insertUser(EmbeddedUser user);

    @Query("select * from EmbeddedUser")
    Single<List<EmbeddedUser>> getAll();
}
