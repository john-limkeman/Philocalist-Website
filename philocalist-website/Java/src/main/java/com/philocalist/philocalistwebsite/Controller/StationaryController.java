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

    @RequestMapping(path = "/stationary/{id}", method = RequestMethod.GET)
    public Stationary getStationaryById(@PathVariable int id){
        return dao.getStationaryById(id);
    }

    @RequestMapping(path = "/stationary/themes/{theme}", method = RequestMethod.GET)
    public List<Stationary> getStationaryByTheme(@PathVariable String theme){
        return dao.getStationaryByTheme(theme);
    }

    @RequestMapping(path = "/stationary/print/{type}", method = RequestMethod.GET)
    public List<Stationary> getStationaryByPrintType(@PathVariable String type){
        return dao.getStationaryByPrintType(type);
    }

    @RequestMapping(path = "/stationary/{id}", method = RequestMethod.PUT)
    public void updateStationary(@PathVariable int id, @RequestBody Stationary stationary){
        dao.updateStationary(stationary, id);
    }

    @RequestMapping(path = "/stationary", method = RequestMethod.POST)
    public void addStationary(@RequestBody Stationary stationary){
        dao.addStationary(stationary);
    }
    @RequestMapping(path = "/stationary/{id}", method = RequestMethod.DELETE)
    public void deleteStationary(@PathVariable int id){
        dao.deleteStationary(id);
    }



}