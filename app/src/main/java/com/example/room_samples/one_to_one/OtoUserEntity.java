package com.example.room_samples.one_to_one;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OtoUserEntity {
    @PrimaryKey(autoGenerate = true)
    public long user_id;

    public String name;
}
