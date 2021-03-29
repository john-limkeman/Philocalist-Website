package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Stationary;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class JdbcStationaryDAOTest {

    private Stationary testStationary = new Stationary();


    private JdbcStationaryDAO dao;
    private static SingleConnectionDataSource dataSource;


    @BeforeAll
    public static void setupDataSource(){
        //connects the test database
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/philocalist-test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);

    }
    @AfterAll
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @BeforeEach
    public void setup() {
        //populates the testStationary
        testStationary.setTitle("Sample Title");
        testStationary.setCategory("weddingInvite");
        testStationary.setPrice(new BigDecimal(10));
        testStationary.setTheme_id(99);
        testStationary.setColor("Gray");
        testStationary.setPrintType("digital");
        testStationary.setActive(true);

        dao = new JdbcStationaryDAO(dataSource);
    }
    @AfterEach
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }




    @Test
    public void addStationaryShouldReturn17TestItems() {

        //when
        dao.addStationary(testStationary);
        List<Stationary> returned = dao.getAllStationary();

        //then
        //check to see if list is larger
        assertEquals(17, returned.size());

        //check to see if last item in list matches sample data added
        assertEquals("Sample Title", returned.get(16).getTitle());
    }

    @Test
    void deleteStationary() {

        dao.deleteStationary(1);
        List<Stationary> returned = dao.getAllStationary();

        //check to see if list is shorter
        assertEquals(15, returned.size());

    }

    @Test
    void updateStationary() {
        dao.updateStationary(testStationary, 1);
        Stationary stationary = dao.getStationaryById(1);

        //check to see if stationary ID = 1 changed to sample data
        assertEquals("Sample Title", stationary.getTitle());
    }

    @Test
    void getAllStationary() {
       List<Stationary> returned =  dao.getAllStationary();

       //check size of list
       assertEquals(16, returned.size());
       //check content of first item in list
       assertEquals(99, returned.get(0).getTheme_id());
    }

    @Test
    void getStationaryByCategory() {
        List<Stationary> returned = dao.getStationaryByCategory("saveTheDate");

        //check to see only one item returned
        assertEquals(1, returned.size());
        //check that it is a saveTheDate
        assertEquals("saveTheDate", returned.get(0).getCategory());
    }

    @Test
    void getStationaryByTheme() {
        List<Stationary> returned = dao.getStationaryByTheme(1);

        assertEquals(10, returned.size());
        assertEquals("Sand & Sun Wedding Bundle", returned.get(0).getTitle());
        assertEquals(1, returned.get(returned.size() - 1).getTheme_id());
    }

    @Test
    void getStationaryByPrintType() {
        List<Stationary> returned = dao.getStationaryByPrintType("digital");

        assertEquals(16, returned.size());

    }

    @Test
    void getStationaryById() {

        Stationary stationary = dao.getStationaryById(10);

        assertEquals("program", stationary.getCategory());
        assertEquals("Sand & Sun Programs", stationary.getTitle());
        assertEquals(10, stationary.getId());
    }
}