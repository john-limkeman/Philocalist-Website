package com.philocalist.philocalistwebsite.controller;

import com.philocalist.philocalistwebsite.dao.StationaryDAO;
import com.philocalist.philocalistwebsite.dao.WebsiteInformationDAO;
import com.philocalist.philocalistwebsite.model.WebsiteInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class WebsiteInformationController {

    @Autowired
    WebsiteInformationDAO dao;

    @RequestMapping(path="/websiteInfo", method = RequestMethod.GET)
    public WebsiteInformation getInformation(){
        return dao.getInformation();
    }

    @RequestMapping(path="/websiteInfo", method = RequestMethod.PUT)
    public void updateInformation(@RequestBody WebsiteInformation info){
        dao.updateInformation(info);
    }

}
