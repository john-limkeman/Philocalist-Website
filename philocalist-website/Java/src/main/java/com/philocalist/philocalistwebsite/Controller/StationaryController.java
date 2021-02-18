package com.philocalist.philocalistwebsite.controller;

import com.philocalist.philocalistwebsite.dao.StationaryDAO;
import com.philocalist.philocalistwebsite.model.Stationary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StationaryController {

    @Autowired
    StationaryDAO dao;

    @RequestMapping(path = "/allStationary", method = RequestMethod.GET)
    public List<Stationary> getAllStationary(){
        return dao.getAllStationary();

    }

    @RequestMapping(path = "/allStationary/{category}", method = RequestMethod.GET)
    public List<Stationary> getAllByCategory(@PathVariable String category){
        return dao.getStationaryByCategory(category);
    }




}