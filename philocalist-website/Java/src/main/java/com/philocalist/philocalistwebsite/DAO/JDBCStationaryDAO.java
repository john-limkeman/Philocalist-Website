package com.philocalist.philocalistwebsite.DAO;

import com.philocalist.philocalistwebsite.Model.Stationary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class JDBCStationaryDAO implements StationaryDAO{

    @Autowired
    private JdbcTemplate jdbc;

    public JDBCStationaryDAO (JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }


    @Override
    public void addStationary(Stationary stationary) {
        jdbc.update("Insert INTO Stationaries (category, price, theme, color, printType, imgURL) VALUES (?, ?, ?, ?, ?, ?)"),
        stationary.getCategory(), stationary.getPrice(), stationary.getTheme(), stationary.getColor(), stationary.getPrintType(),
        stationary.getImgURL());
    }

    @Override
    public void deleteStationary(Stationary stationary) {

    }

    @Override
    public void updateStationary(Stationary stationary) {

    }

    @Override
    public List<Stationary> getAllStationary() {
        return null;
    }

    @Override
    public List<Stationary> getStationaryByCategory(String category) {
        return null;
    }

    @Override
    public List<Stationary> getStationaryByTheme(String theme) {
        return null;
    }

    @Override
    public List<Stationary> getStationaryByPrintType(String printType) {
        return null;
    }

    @Override
    public Stationary getStationaryById(int id) {
        return null;
    }
}
