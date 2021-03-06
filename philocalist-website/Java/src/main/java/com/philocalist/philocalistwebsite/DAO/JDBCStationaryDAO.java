package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Stationary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStationaryDAO implements StationaryDAO {

    private JdbcTemplate jdbc;

    public JdbcStationaryDAO(DataSource datasource) {
        this.jdbc = new JdbcTemplate(datasource);
    }

    @Override
    public void addStationary(Stationary stationary) {
        jdbc.update("Insert INTO Stationaries (title, category, price, theme_id, color, printType, imgURL, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                stationary.getTitle(), stationary.getCategory(), stationary.getPrice(), stationary.getTheme_id(), stationary.getColor(), stationary.getPrintType(),
                stationary.getImgURL(), stationary.isActive());
    }

    //First, deletes photos dependent on stationary, then deletes stationary
    @Override
    public void deleteStationary(int id) {
        jdbc.update("DELETE FROM Photos WHERE stationary_id = ?", id);
        jdbc.update("DELETE FROM Stationaries WHERE id = ?", id);
    }

    @Override
    public void updateStationary(Stationary stationary, int id) {
        String sql = "UPDATE Stationaries SET title = ?, category = ?, price = ?, theme_id = ?," +
                " color = ?, printType = ?, imgURL = ?, isActive = ? WHERE id = ?";
        jdbc.update(sql, stationary.getTitle(), stationary.getCategory(), stationary.getPrice(),
                stationary.getTheme_id(), stationary.getColor(), stationary.getPrintType(),
                stationary.getImgURL(), stationary.isActive(), id);
    }

    @Override
    public List<Stationary> getAllStationary() {
        String sql = "SELECT * FROM Stationaries";

        List<Stationary> stationaries = new ArrayList<>();
        SqlRowSet result = jdbc.queryForRowSet(sql);
        while (result.next()){
            Stationary stationary = mapRowToStationary(result);
            stationaries.add(stationary);
        }
        return stationaries;
    }



    @Override
    public List<Stationary> getStationaryByCategory(String category) {
        String sql = "SELECT * FROM Stationaries WHERE category = ?";

        List<Stationary> stationaries = new ArrayList<>();
        SqlRowSet result = jdbc.queryForRowSet(sql, category);
        while (result.next()){
            stationaries.add(mapRowToStationary(result));
        }
        return stationaries;
    }

    @Override
    public List<Stationary> getStationaryByTheme(int theme) {
        String sql = "SELECT * FROM Stationaries WHERE theme_id = ?";

        List<Stationary> stationaries = new ArrayList<>();
        SqlRowSet result = jdbc.queryForRowSet(sql, theme);
        while (result.next()){
            stationaries.add(mapRowToStationary(result));
        }
        return stationaries;
    }

    @Override
    public Stationary getStationaryByThemeAndCategory(int theme, String category) {
        String sql = "SELECT * FROM Stationaries WHERE theme_id = ? AND category = ?";

        Stationary stationary = new Stationary();
        SqlRowSet result = jdbc.queryForRowSet(sql, theme, category);
        while (result.next()){
            stationary = mapRowToStationary(result);
        }
        return stationary;
    }

    @Override
    public List<Stationary> getStationaryByPrintType(String printType) {
        String sql = "SELECT * FROM Stationaries WHERE printType = ?";

        List<Stationary> stationaries = new ArrayList<>();
        SqlRowSet result = jdbc.queryForRowSet(sql, printType);
        while (result.next()){
            stationaries.add(mapRowToStationary(result));
        }
        return stationaries;
    }

    @Override
    public Stationary getStationaryById(int id) {
        String sql = "SELECT * FROM Stationaries WHERE id = ?";

        Stationary stationary = new Stationary();
        SqlRowSet result = jdbc.queryForRowSet(sql, id);
        while (result.next()){
            stationary = mapRowToStationary(result);
        }
        return stationary;
    }

    //methods for parsing data from DB

    private Stationary mapRowToStationary(SqlRowSet row) {
        Stationary stationary = new Stationary();
        stationary.setId(row.getInt("id"));
        stationary.setTitle(row.getString("title"));
        stationary.setCategory(row.getString("category"));
        stationary.setColor(row.getString("color"));
        stationary.setPrice(row.getBigDecimal("price"));
        stationary.setTheme_id(row.getInt("theme_id"));
        stationary.setPrintType(row.getString("printType"));
        stationary.setImgURL(row.getString("imgURL"));
        stationary.setActive(row.getBoolean("isActive"));
        stationary.setDescription(row.getString("description"));
        stationary.setHeight(row.getDouble("height"));
        stationary.setWidth(row.getDouble("width"));
        return stationary;
    }


}
