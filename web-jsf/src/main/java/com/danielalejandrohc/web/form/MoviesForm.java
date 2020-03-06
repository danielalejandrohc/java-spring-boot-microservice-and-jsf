package com.danielalejandrohc.web.form;

import com.danielalejandrohc.data.model.Movie;
import com.danielalejandrohc.service.MovieService;
import com.danielalejandrohc.web.form.model.MoviesFormModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@SessionScope
public class MoviesForm implements Serializable {

    private MoviesFormModel model;
    
    @Autowired
    private MovieService service;
    
    @PostConstruct
    public void init() {
        model = new MoviesFormModel();
        model.setMovies(service.findAll());
    }

    public MoviesFormModel getModel() {
        return model;
    }

    public void setModel(MoviesFormModel model) {
        this.model = model;
    }
    
    public void newMovie() {        
        Movie movie = new Movie();
        movie.setTitle("");
        model.setSelectedMovie(movie);
        init();
    }
    
    public void editMovie() {
        service.update(model.getSelectedMovie());
        init();
    }
    
    public void selectMovie(Movie movie) {
        model.setSelectedMovie(movie);
    }
    
    public void deleteMovie(Movie movie) {
        service.delete(movie.getId());
        model.setMovies(service.findAll());
    }

}
