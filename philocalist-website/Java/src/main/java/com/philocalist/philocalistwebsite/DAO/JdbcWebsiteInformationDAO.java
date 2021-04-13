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
    public void updateInformation(WebsiteInformation info) {
        String sql = "UPDATE websiteInformation SET aboutMessage = ?, aboutImageURL = ?, email = ?, phone = ?, contactMessage = ?, homeMessage = ? WHERE id = ?";
        jdbc.update(sql, info.getAboutMessage(), info.getAboutImageURL(), info.getEmail(), info.getPhone(), info.getContactMessage(), info.getHomeMessage(), info.getId());
    }
}
