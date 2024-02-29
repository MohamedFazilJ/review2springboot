package com.example.mysql_connect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import com.example.mysql_connect.model.HotelStay;
import com.example.mysql_connect.repositary.HotelStayRepo;

@Service
public class HotelStayService
{
    @Autowired
    private HotelStayRepo hotelStayRepo;
    @SuppressWarnings("null")
    public HotelStay hsy(HotelStay hotelStay)
    {
        return hotelStayRepo.save(hotelStay);
    }

    public List<HotelStay> gethotel()
    {
        return hotelStayRepo.findAll();
    }

    public Optional<HotelStay> gethsid(int hsid){
        return hotelStayRepo.findById(hsid);
    }

     public List<HotelStay> getoffpaage(int a,int b)
    {
        return hotelStayRepo.findAll(PageRequest.of(a, b)).getContent();
    }

        public List<HotelStay> listingstayfield(int a,int b,String c)
    {
        return hotelStayRepo.findAll(PageRequest.of(a, b,Sort.by(Sort.Direction.ASC,c))).getContent();
    }
}
