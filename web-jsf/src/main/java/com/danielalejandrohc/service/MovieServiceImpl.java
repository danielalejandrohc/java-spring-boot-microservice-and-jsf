package com.danielalejandrohc.service;

import com.danielalejandrohc.data.model.Movie;
import com.danielalejandrohc.feign.MovieFeignClient;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Service
@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    private Environment env;
    @Value("${client.feign.url}")
    private String urlMicroservice;
    private MovieFeignClient target;

    private String username;
    private String credentials;

    @Override
    public List<Movie> findAll() {
        target = Feign.builder().decoder(new GsonDecoder()).target(MovieFeignClient.class, urlMicroservice);
        return target.findAll();
    }

    public String getUrlMicroservice() {
        return urlMicroservice;
    }

    
    public void setUrlMicroservice(String urlMicroservice) {
        this.urlMicroservice = urlMicroservice;
    }

    @Override
    public Movie find(String id) {
        target = Feign.builder().decoder(new GsonDecoder()).target(MovieFeignClient.class, urlMicroservice);
        return target.get(id);
    }

    @Override
    public void delete(String id) {
        username = SecurityContextHolder.getContext().getAuthentication().getName();
        credentials = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        target = Feign.builder().requestInterceptor(new BasicAuthRequestInterceptor(username, credentials)).decoder(new GsonDecoder()).target(MovieFeignClient.class, urlMicroservice);
        target.delete(id);
    }

    @Override
    public Movie update(Movie movie) {
        username = SecurityContextHolder.getContext().getAuthentication().getName();
        credentials = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        target = Feign.builder().requestInterceptor(new BasicAuthRequestInterceptor(username, credentials)).decoder(new GsonDecoder()).encoder(new GsonEncoder()).target(MovieFeignClient.class, urlMicroservice);
        return target.update(movie);
    }

}
