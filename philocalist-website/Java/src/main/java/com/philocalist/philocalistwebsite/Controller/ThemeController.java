package com.philocalist.philocalistwebsite.controller;


import com.philocalist.philocalistwebsite.dao.ThemeDAO;
import com.philocalist.philocalistwebsite.model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ThemeController {

    @Autowired
    ThemeDAO dao;

    /* GET ALL */
    @RequestMapping(path = "/themes", method = RequestMethod.GET)
    public List<Theme> getallThemes(){
        return dao.getAllThemes();
    }

    /* GET THEME BY ID */
    @RequestMapping(path = "/themes/{id}", method = RequestMethod.GET)
    public Theme getThemeById(@PathVariable int id){
        return dao.getThemeById(id);
    }

    /* GET FEATURED THEME */
    @RequestMapping(path = "/themes/featured", method = RequestMethod.GET)
    public Theme getFeaturedTheme(){
        return dao.getFeaturedTheme();
    }

    /* ADD THEME */
    @RequestMapping(path = "/themes", method = RequestMethod.POST)
    public void addTheme(@RequestBody Theme theme){
        dao.addTheme(theme);
    }

    /* EDIT THEME */
    @RequestMapping(path = "/themes/{id}", method = RequestMethod.PUT)
    public void editTheme(@RequestBody Theme theme, @PathVariable int id){
        dao.editTheme(theme, id);
    }

    /* DELETE THEME */
    @RequestMapping(path = "/themes/{id}", method = RequestMethod.DELETE)
    public void deleteTheme(@PathVariable int id){
        dao.deleteTheme(id);
    }


}
