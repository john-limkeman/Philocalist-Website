package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.WebsiteInformation;

public interface WebsiteInformationDAO {

    //UPDATE THE CUSTOM DATA ON THE WEBPAGE (WELCOME TEXT, ABOUT TEXT, CONTACT INFO, ETC)
    void updateInformation(WebsiteInformation info);
}
