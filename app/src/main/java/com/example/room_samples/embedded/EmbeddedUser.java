package com.example.room_samples.embedded;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EmbeddedUser")
public class EmbeddedUser {
    @PrimaryKey public int id;
    public String firstName;
    @Embedded
    public EmbeddedAddress embeddedAddress;
    @Embedded(prefix = "adr2_")
    public EmbeddedAddress2 embeddedAddress2;
}
