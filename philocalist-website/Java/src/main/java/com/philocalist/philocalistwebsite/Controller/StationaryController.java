package com.philocalist.philocalistwebsite.controller;

import com.philocalist.philocalistwebsite.dao.StationaryDAO;
import com.philocalist.philocalistwebsite.model.Stationary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}