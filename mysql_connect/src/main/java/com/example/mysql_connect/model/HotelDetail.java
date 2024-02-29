package com.example.mysql_connect.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@NoArgsConstructor
public class HotelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int htid;
    private String htname;
   @JsonManagedReference
   @OneToMany(mappedBy = "hotelDetail", cascade = CascadeType.ALL)
   public List<HotelStay> hotelStay;
}
