package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Stationary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
class JdbcStationaryDAOTest {

    private Stationary testStationary = new Stationary();

    private JdbcStationaryDAO dao;
//    private static SingleConnectionDataSource dataSource;
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcStationaryDAOTest(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
        dao = new JdbcStationaryDAO(dataSource);
    }

//    @BeforeClass
//    public void setupDataSource(){
        //connects the test database
//        dataSource = new SingleConnectionDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/philocalist-test");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");
//        dataSource.setAutoCommit(false);

//        dao = new JdbcStationaryDAO(jdbc);
//    }
//    @AfterClass
//    public static void closeDataSource() throws SQLException {
//        dataSource.destroy();
//    }

//    @Before
//    public void setup() {
//        //populates the testStationary
//
//    }
//    @After
//    public void rollback() throws SQLException {
//        dataSource.getConnection().rollback();
//    }




    @Test
    public void addStationaryShouldReturn17TestItems() {
        testStationary.setTitle("Sample Title");
        testStationary.setCategory("weddingInvite");
        testStationary.setPrice(new BigDecimal(10));
        testStationary.setTheme("Sample Theme");
        testStationary.setColor("Gray");
        testStationary.setPrintType("digital");
        testStationary.setActive(true);

        //when
        dao.addStationary(testStationary);
        List<Stationary> returned = dao.getAllStationary();

        //then
        //check to see if list is larger
        assertEquals(17, returned.size());

        //check to see if last item in list matches sample data added
        assertEquals("Sample Title", returned.get(16).getTitle());
    }

//    @Test
//    void deleteStationary() {
//    }
//
//    @Test
//    void updateStationary() {
//    }
//
//    @Test
//    void getAllStationary() {
//    }
//
//    @Test
//    void getStationaryByCategory() {
//    }
//
//    @Test
//    void getStationaryByTheme() {
//    }
//
//    @Test
//    void getStationaryByPrintType() {
//    }
//
//    @Test
//    void getStationaryById() {
//    }
}