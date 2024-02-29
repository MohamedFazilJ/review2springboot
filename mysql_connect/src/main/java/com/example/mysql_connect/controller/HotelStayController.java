package com.example.mysql_connect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql_connect.model.HotelStay;
import com.example.mysql_connect.service.HotelStayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HotelStayController {
    @Autowired
    private HotelStayService hotelStayService;
    


    @PostMapping("/hotelstay/posting")
    public HotelStay postMethod(@RequestBody HotelStay hotelStay) {
        return hotelStayService.hsy(hotelStay);
    }
    

    @GetMapping("/api/gethotelstay")
    public List<HotelStay> getMetho() {
        return hotelStayService.gethotel();
    }
    
@GetMapping("/api/hotelhsid/{hsid}")
    public Optional<HotelStay> gettinghsid(@PathVariable int hsid) {
        return hotelStayService.gethsid(hsid);
    }


        @GetMapping("/api/hotelinggg/{offset}/{pagesize}")
    public ResponseEntity<List<HotelStay>> hotellstay(@PathVariable int offset,@PathVariable int pagesize)
    {
        List<HotelStay> listhotelStay = hotelStayService. getoffpaage(offset,pagesize);
        if(!listhotelStay.isEmpty())
        {
            return new ResponseEntity<List<HotelStay>>(listhotelStay,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/api/hotelbkstaying/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<HotelStay>> hotelstayoffsizefield(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<HotelStay> listthotellstayy = hotelStayService.listingstayfield(offset, pagesize, field);
        if(!listthotellstayy.isEmpty())
        {
            return new ResponseEntity<List<HotelStay>>(listthotellstayy,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
