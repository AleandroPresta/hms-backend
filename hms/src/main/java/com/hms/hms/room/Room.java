package com.hms.hms.room;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Validated
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Pattern(regexp = "^(single|double|suite|queen|king)$")
    @Column(name = "type")
    private RoomType type;
    
    @Min(1)
    @Column(name = "price")
    private Double price;

    @Min(1)
    @Max(5)
    @Column(name = "rating")
    private Double rating;

    @Column(name = "is_available")
    private boolean isAvailable;
    
}