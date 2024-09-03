package com.hms.hms.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long id;

    private RoomType type;
    
    private Double price;

    private Double rating;

    private boolean isAvailable;
    
}
