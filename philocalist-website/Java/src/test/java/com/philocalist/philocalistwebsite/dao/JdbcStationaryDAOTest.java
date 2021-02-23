package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Stationary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class JdbcStationaryDAOTest {

    private JdbcTemplate jdbc;
    private JdbcStationaryDAO dao;

    //this part isn't working, perhaps I should declare the datasource in the test?

    @Autowired
    public JdbcStationaryDAOTest(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
        dao = new JdbcStationaryDAO(dataSource);
    }

    @Test
    public void addStationaryShouldReturn17TestItems() {
        //given
        Stationary stationary = new Stationary();
        stationary.setTitle("Sample Title");
        stationary.setCategory("weddingInvite");
        stationary.setPrice(new BigDecimal(10));
        stationary.setTheme("Sample Theme");
        stationary.setColor("Gray");
        stationary.setPrintType("digital");
        stationary.setActive(true);

        //when
        dao.addStationary(stationary);
        List<Stationary> returned = dao.getAllStationary();

        //then
        assertEquals(17, returned.size());
    }

    @Test
    void deleteStationary() {
    }

    @Test
    void updateStationary() {
    }

    @Test
    void getAllStationary() {
    }

    @Test
    void getStationaryByCategory() {
    }

    @Test
    void getStationaryByTheme() {
    }

    @Test
    void getStationaryByPrintType() {
    }

    @Test
    void getStationaryById() {
    }
}