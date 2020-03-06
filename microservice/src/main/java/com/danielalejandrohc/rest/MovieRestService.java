package com.danielalejandrohc.rest;

import com.danielalejandrohc.db.model.Movie;
import com.danielalejandrohc.db.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRestService implements BasicOperations<Movie, String> {

    @Autowired
    private MovieRepository service;

    @GetMapping(path = "/movies")
    @Override
    public List<Movie> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/movies/{id}")
    @Override
    public Movie find(@PathVariable String id) {
        return service.getOne(id);
    }

    @DeleteMapping(path = "/movies/{id}")
    @Override
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping(path = "/movies")
    @Override
    public Movie update(@RequestBody  Movie movie) {
        return service.save(movie);
    }
}
