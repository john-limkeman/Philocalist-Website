package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Photo;

public interface PhotoDAO {

    //add a photo
    public void addPhoto(Photo photo);

    //update a photo
    public void updatePhoto(Photo photo, int id);

    //delete a photo
    public void deletePhoto(int id);

    //get all photos
    public void getAllPhotos();

    //get photos by stationary id
    public void getPhotoByStationaryId(int id);

    //get photos by id
    public void getPhotoById(int id);

}
