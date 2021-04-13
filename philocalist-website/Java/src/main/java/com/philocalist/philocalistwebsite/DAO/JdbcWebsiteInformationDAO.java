package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.WebsiteInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWebsiteInformationDAO implements WebsiteInformationDAO{

    private JdbcTemplate jdbc;

    public JdbcWebsiteInformationDAO(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
    }


    @Override
    public WebsiteInformation getInformation() {
        WebsiteInformation info = new WebsiteInformation();

        String sql = "SELECT * FROM websiteInformation WHERE id = 1"; //ONLY ONE 'WEBSITE INFORMATION' ROW IN DB
        SqlRowSet result = jdbc.queryForRowSet(sql);
        while (result.next()){
            info = mapInfoToRow(result);
        }
        return info;
    }


    @Override
    public void updateInformation(WebsiteInformation info) {
        String sql = "UPDATE websiteInformation SET aboutMessage = ?, aboutImageURL = ?, email = ?, phone = ?, contactMessage = ?, homeMessage = ? WHERE id = 1";
        jdbc.update(sql, info.getAboutMessage(), info.getAboutImageURL(), info.getEmail(), info.getPhone(), info.getContactMessage(), info.getHomeMessage());
    }
    private WebsiteInformation mapInfoToRow(SqlRowSet result) {
        WebsiteInformation info = new WebsiteInformation();
        info.setAboutMessage(result.getString("aboutMessage"));
        info.setAboutImageURL(result.getString("aboutImageURL"));
        info.setEmail(result.getString("email"));
        info.setPhone(result.getString("phone"));
        info.setContactMessage(result.getString("contactMessage"));
        info.setHomeMessage(result.getString("homeMessage"));

        return info;
    }
}
