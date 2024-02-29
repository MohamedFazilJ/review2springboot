package com.example.mysql_connect.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mysql_connect.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel , Integer >{

    
}