package com.danielalejandrohc.feign;


import com.danielalejandrohc.data.model.Movie;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "movieFeignClient")
public interface MovieFeignClient {
    @RequestLine("GET /movies")
    public List<Movie> findAll();

    @RequestLine("PUT /movies")
    public void create(Movie movie);
    
    @RequestLine("POST /movies")
    @Headers("Content-Type: application/json")
    public Movie update( Movie movie);

    @RequestLine("DELETE /movies/{id}")
    public void delete(@Param("id") String id);

    @RequestLine("GET /movies/{id}")
    public Movie get(@Param("id") String id);
}
