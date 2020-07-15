package com.example.room_samples.one_to_one;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OtoAddress
{
    @PrimaryKey(autoGenerate = true)
    public long adr_id;

    public String adr;
    public long user_id;
}
