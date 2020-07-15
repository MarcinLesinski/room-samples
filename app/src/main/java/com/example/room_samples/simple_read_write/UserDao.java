package com.example.room_samples.simple_read_write;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {
    @Query("select * from user")
    Single<List<User>> getAll();

    @Query("select * from user where uid in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("select * from user where first_name like :first AND " +
    "last_name like :last limit 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
    //
}
