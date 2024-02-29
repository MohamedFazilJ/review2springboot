package com.example.mysql_connect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@NoArgsConstructor
public class HotelStay {
    
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hsid;
    private String name;
    private int total;
    private int roomno;
    @JsonBackReference
    @ManyToOne
    public HotelDetail hotelDetail;
    
}
