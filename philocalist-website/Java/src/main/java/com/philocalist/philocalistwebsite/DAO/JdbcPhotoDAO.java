package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDAO implements PhotoDAO{

    private JdbcTemplate jdbc;

    public JdbcPhotoDAO(DataSource datasource) {
        this.jdbc = new JdbcTemplate(datasource);
    }

    @Override
    public void addPhoto(Photo photo) {
        jdbc.update("INSERT INTO Photos (stationary_id, url, title) VALUES (?, ?, ?);",
                photo.getStationary_id(), photo.getUrl(), photo.getTitle());
    }

    @Override
    public void updatePhoto(Photo photo, int id) {
        String sql = "UPDATE Photos SET url = ?, stationary_id = ?, title = ? WHERE id = ?";
        jdbc.update(sql, photo.getUrl(), photo.getStationary_id(), photo.getTitle(), id);
    }

    @Override
    public void deletePhoto(int id) {
        jdbc.update("DELETE FROM Photos WHERE id = ?", id);
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photos = new ArrayList<>();

        String sql = "SELECT * FROM Photos";
        SqlRowSet result = jdbc.queryForRowSet(sql);
        while(result.next()){
            Photo photo = mapRowToPhoto(result);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public List<Photo> getPhotoByStationaryId(int id) {
        List<Photo> photos = new ArrayList<>();

        String sql = "SELECT * FROM Photos WHERE stationary_id = ?";
        SqlRowSet result = jdbc.queryForRowSet(sql, id);
        while(result.next()){
            Photo photo = mapRowToPhoto(result);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public Photo getPhotoById(int id) {
        Photo photo = new Photo();
        String sql = "SELECT * FROM Photos WHERE id = ?";
        SqlRowSet result = jdbc.queryForRowSet(sql, id);
        while(result.next()){
            photo = mapRowToPhoto(result);
        }
        return photo;

    }

    //methods for parsing data from DB

    private Photo mapRowToPhoto(SqlRowSet row){
        Photo photo = new Photo();
        photo.setId(row.getInt("id"));
        photo.setStationary_id(row.getInt("stationary_id"));
        photo.setUrl(row.getString("url"));
        photo.setTitle(row.getString("title"));
        return photo;
    }
}
