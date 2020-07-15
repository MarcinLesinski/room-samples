package com.example.room_samples.simple_read_write;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName = "";

    @ColumnInfo(name = "last_name")
    public String lastName = "";

    @Ignore
    String ignoredField;
}
