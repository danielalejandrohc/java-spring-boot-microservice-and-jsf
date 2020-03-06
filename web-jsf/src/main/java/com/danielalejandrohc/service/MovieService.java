package com.danielalejandrohc.service;

import com.danielalejandrohc.data.model.Movie;

import java.util.List;

public interface MovieService 
{
  List<Movie> findAll();
  Movie find(String id);
  void delete(String id);
  Movie update(Movie movie);
}
