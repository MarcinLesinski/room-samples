package com.example.room_samples.embedded;

import androidx.room.ColumnInfo;

public class EmbeddedAddress {
    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code") public int postCode;
}
