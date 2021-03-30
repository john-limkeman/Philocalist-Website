package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Theme;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcThemeDAO implements ThemeDAO{

    private JdbcTemplate jdbc;

    public JdbcThemeDAO(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
    }


    @Override
    public Theme getThemeById(int id) {
        Theme theme = new Theme();

        String sql = "SELECT * FROM Themes WHERE id = ?";
        SqlRowSet results = jdbc.queryForRowSet(sql, id);
        while(results.next()){
            theme = mapRowToTheme(results);
        }
        return theme;
    }

    @Override
    public List<Theme> getAllThemes() {
        List<Theme> themes = new ArrayList<>();

        String sql = "SELECT * FROM Themes";
        SqlRowSet results = jdbc.queryForRowSet(sql);
        while(results.next()){
            themes.add(mapRowToTheme(results));
        }
        return themes;
    }

    @Override
    public void addTheme(Theme theme) {
        String sql = "INSERT INTO Themes (hero_image, name, description) VALUES (?, ?, ?)";
        jdbc.update(sql, theme.getHero_image(), theme.getName(), theme.getDescription());
    }

    @Override
    public void editTheme(Theme theme, int id) {
        String sql = "UPDATE Themes SET hero_image = ?, name = ?, description = ? WHERE id = ?";
        jdbc.update(sql, theme.getHero_image(), theme.getName(), theme.getDescription(), id);
    }

    @Override
    public void deleteTheme(int id) {

        /* generate list of stationaries using the to-delete theme */
        List<Integer> ids = new ArrayList<>();
        SqlRowSet results = jdbc.queryForRowSet("SELECT * FROM Stationaries WHERE theme_id = ?", id);
        while(results.next()){
            Integer stationaryId = results.getInt("id");
            ids.add(stationaryId);
        }

        /* Iterate through stationaries to delete their photos and then the stationary itself */
        for (int i = 0; i < ids.size(); i++){
            jdbc.update("DELETE FROM Photos WHERE stationary_id = ?", ids.get(i));
            jdbc.update("DELETE FROM Stationaries WHERE id = ?", ids.get(i));
        }
        /* Delete the theme after all dependants have been deleted */
        jdbc.update("DELETE FROM Themes WHERE id = ?", id);
    }

    private Theme mapRowToTheme(SqlRowSet row){
        Theme theme = new Theme();
        theme.setId(row.getInt("id"));
        theme.setDescription(row.getString("description"));
        theme.setName(row.getString("name"));
        theme.setHero_image(row.getString("hero_image"));
        return theme;
    }

}
