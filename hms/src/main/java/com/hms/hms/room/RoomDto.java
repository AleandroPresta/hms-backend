package com.hms.hms.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private long id;
    private String roomType;
    private double price;
    private double rating;
    
}
