package com.example.mysql_connect.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mysql_connect.model.HotelDetail;
import com.example.mysql_connect.repositary.HotelDetailRepo;

@Service
public class HotelDetailService {
    @Autowired
    private HotelDetailRepo hotelDetailRepo;

    @SuppressWarnings("null")
    public HotelDetail hd(HotelDetail hotelDetail)
    {
        return hotelDetailRepo.save(hotelDetail);
    }

    public List<HotelDetail>get(){
        return hotelDetailRepo.findAll();

    }

    public Optional<HotelDetail> gethtid(int htid){
        return hotelDetailRepo.findById(htid);
    }


    public List<HotelDetail> listfield(String field)
    {
        return hotelDetailRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public List<HotelDetail> getoffpage(int a,int b)
    {
        return hotelDetailRepo.findAll(PageRequest.of(a, b)).getContent();
    }


    public List<HotelDetail> listingdetailfield(int a,int b,String c)
    {
        return hotelDetailRepo.findAll(PageRequest.of(a, b,Sort.by(Sort.Direction.ASC,c))).getContent();
    }
}
