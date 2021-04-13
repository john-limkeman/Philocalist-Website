package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.WebsiteInformation;

public interface WebsiteInformationDAO {

    // GET CUSTOM DATA FROM DATABASE
    WebsiteInformation getInformation();

    //UPDATE THE CUSTOM DATA ON THE WEBPAGE (WELCOME TEXT, ABOUT TEXT, CONTACT INFO, ETC)
    void updateInformation(WebsiteInformation info);
}
