package com.philocalist.philocalistwebsite.controller;


import com.philocalist.philocalistwebsite.dao.PhotoDAO;
import com.philocalist.philocalistwebsite.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PhotoController {

    @Autowired
    PhotoDAO dao;

    /* GET ALL  */
    @RequestMapping(path = "/photos", method= RequestMethod.GET)
    public List<Photo> getAllPhotos(){
        return dao.getAllPhotos();
    }

    /* GET ALL BY STATIONARY ID */
    @RequestMapping(path = "/photos/stationary/{id}", method = RequestMethod.GET)
    public List<Photo> getPhotosByStationary(@PathVariable int id){
        return dao.getPhotoByStationaryId(id);
    }

    /* GET PHOTO BY PHOTO ID */
    @RequestMapping(path = "/photos/{id}", method = RequestMethod.GET)
    public Photo getPhotoById(@PathVariable int id){
        return dao.getPhotoById(id);
    }

    /* ADD PHOTO */
    @RequestMapping(path = "/photos", method = RequestMethod.POST)
    public void addPhoto(@RequestBody Photo photo){
        dao.addPhoto(photo);
    }

    /* UPDATE PHOTO */
    @RequestMapping(path = "/photos/{id}", method = RequestMethod.PUT)
    public void updatePhoto(@RequestBody Photo photo, @PathVariable int id){
        dao.updatePhoto(photo, id);
    }

    /* DELETE PHOTO */
    @RequestMapping(path = "/photos/{id}", method = RequestMethod.DELETE)
    public void deletePhoto(@PathVariable int id){
        dao.deletePhoto(id);
    }
}
