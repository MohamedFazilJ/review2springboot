package com.example.mysql_connect.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Hotel {
    
    @Id
    private int HotelId;
    private int totalmembers;
    private double HotelPrice;
    private String Name;
    private String Checkin;
    private String checkout;
    private int hotelNo;


    
}