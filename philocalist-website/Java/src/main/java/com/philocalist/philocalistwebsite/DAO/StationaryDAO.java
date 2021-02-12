package com.philocalist.philocalistwebsite.DAO;

import com.philocalist.philocalistwebsite.Model.Stationary;

import java.math.BigDecimal;
import java.util.List;

public interface StationaryDAO {

    //Add a Stationary Item
    public void addStationary(Stationary stationary);

    //Delete Stationary Item
    public void deleteStationary(int id);

    //Update Stationary Item
    public void updateStationary(Stationary stationary, int id);

    //Get all
    public List<Stationary> getAllStationary();

    //Get all by category
    public List<Stationary> getStationaryByCategory(String category);

    //Get all by theme
    public List<Stationary> getStationaryByTheme(String theme);

    //Get all by printType
    public List<Stationary> getStationaryByPrintType(String printType);

    //Get Stationary by id
    public Stationary getStationaryById(int id);
}
