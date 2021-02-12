package com.philocalist.philocalistwebsite.Controller;

import com.philocalist.philocalistwebsite.DAO.StationaryDAO;
import com.philocalist.philocalistwebsite.Model.Stationary;
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
