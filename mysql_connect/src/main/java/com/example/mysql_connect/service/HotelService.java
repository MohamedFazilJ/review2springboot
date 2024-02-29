package com.example.mysql_connect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mysql_connect.model.Hotel;
import com.example.mysql_connect.repositary.HotelRepo;

@Service
public class HotelService {
    
    private HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @SuppressWarnings("null")
    public boolean saveHotel(Hotel hotel){

        try{
            hotelRepo.save(hotel);
            
        }
        catch(Exception e){
                                               
            System.out.println(" \n exception \n");
            System.out.println(e.getMessage());
            System.out.println(" \n exception \n");

            return false;
        }

        return true;
    }

    public List<Hotel> getAllHotel(){
        

            return hotelRepo.findAll();
        }


    public Optional<Hotel> getHotelById(int id){
        return hotelRepo.findById(id);
    }

    public void delId(int id)
    {
        hotelRepo.deleteById(id);
    }

    @SuppressWarnings("null")
    public void updateHotel(int id,Hotel hotel)
    {
        if(hotelRepo.findById(id)!=null)
        {
            hotelRepo.save(hotel);
        }
    }
}