package com.danielalejandrohc.web.form.model;

import com.danielalejandrohc.data.model.Movie;
import com.danielalejandrohc.data.model.UserStore;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniel
 */
public class MoviesFormModel {

    private UserStore user;
    private Movie selectedMovie;
    private List<Movie> movies;
    
    public MoviesFormModel() {
        movies = new ArrayList<>();
        selectedMovie = new Movie();
        user = new UserStore();
    }

    public UserStore getUser() {
        return user;
    }

    public void setUser(UserStore user) {
        this.user = user;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
