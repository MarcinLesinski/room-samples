package com.example.room_samples.one_to_one;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

public class OtoUser {
    @Embedded
    public OtoUserEntity user;
    @Relation(
            parentColumn = "user_id",
            entityColumn = "user_id",
            entity = OtoAddress.class
    )
    public OtoAddress otoAddress;
}



