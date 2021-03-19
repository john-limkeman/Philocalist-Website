package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Photo;

import java.util.List;

public interface PhotoDAO {

    //add a photo
    public void addPhoto(Photo photo);

    //update a photo
    public void updatePhoto(Photo photo, int id);

    //delete a photo
    public void deletePhoto(int id);

    public void deletePhotosByStationary(int id);

    //get all photos
    public List<Photo> getAllPhotos();

    //get photos by stationary id
    public List<Photo> getPhotoByStationaryId(int id);

    //get photo by id
    public Photo getPhotoById(int id);

}
