package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.Theme;

import java.util.List;

public interface ThemeDAO {

    //get theme by id
    public Theme getThemeById(int id);

    //get featured theme
    public Theme getFeaturedTheme();

    //get all themes
    public List<Theme> getAllThemes();

    //add theme
    public void addTheme(Theme theme);

    //edit theme
    public void editTheme(Theme theme, int id);

    //delete theme
    public void deleteTheme(int id);


}
