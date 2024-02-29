package com.example.mysql_connect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.mysql_connect.model.HotelDetail;
import com.example.mysql_connect.service.HotelDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class HotelDetailController {
    
    @Autowired
    private HotelDetailService hotelDetailService;

    
    @PostMapping("/postingg")
    public HotelDetail postMethodName(@RequestBody HotelDetail hotelDetail) {
        
        return hotelDetailService.hd(hotelDetail);
    }
    
    @GetMapping("/gettingg")
    public List<HotelDetail> getMethodName() {
        return hotelDetailService.get();
    }
    
    @GetMapping("/api/hoteldetaill/{htid}")
    public Optional<HotelDetail> gettinghtid(@PathVariable int htid) {
        return hotelDetailService.gethtid(htid);
    }


    //{
//     "htid": 1,
//     "htname": "Sada",
//     "hotelStay": [
//         {
//             "hsid": 100,
//             "name": "Pavii",
//             "total": 12,
//             "roomno": 14
//         },
//         {
//             "hsid": 117,
//             "name": "Logesh",
//             "total": 12,
//             "roomno": 15
//         }
//     ]
// }


    @GetMapping("/api/listfield/sortBy/{field}")
    public ResponseEntity<List<HotelDetail>> listing (@PathVariable String field)
    {
        List<HotelDetail> listingfield = hotelDetailService.listfield(field);
        if(listingfield.size()>0)
        {
            return new ResponseEntity<List<HotelDetail>>(listingfield,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//
    @GetMapping("/api/hotellingg/{offset}/{pagesize}")
    public ResponseEntity<List<HotelDetail>> hotellDetaill(@PathVariable int offset,@PathVariable int pagesize)
    {
        List<HotelDetail> listhoteldetail = hotelDetailService.getoffpage(offset,pagesize);
        if(!listhoteldetail.isEmpty())
        {
            return new ResponseEntity<List<HotelDetail>>(listhoteldetail,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        //0/2
    }
    @GetMapping("/api/hotelbking/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<HotelDetail>> hoteldetailoffsizefield(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<HotelDetail> listthotelldetaill = hotelDetailService.listingdetailfield(offset, pagesize, field);
        if(!listthotelldetaill.isEmpty())
        {
            return new ResponseEntity<List<HotelDetail>>(listthotelldetaill,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
