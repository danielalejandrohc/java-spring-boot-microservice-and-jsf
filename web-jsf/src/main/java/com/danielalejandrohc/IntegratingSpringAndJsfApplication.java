package com.danielalejandrohc;

import com.danielalejandrohc.data.model.Movie;
import com.danielalejandrohc.feign.MovieFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class IntegratingSpringAndJsfApplication
{
  // http://localhost:5000/resolve-day-of-week.xhtml
  public static void main(String[] args) {
    SpringApplication.run(IntegratingSpringAndJsfApplication.class, args);
    //MovieFeignClient target = Feign.builder().decoder(new GsonDecoder()).target(MovieFeignClient.class, "http://localhost:8080/");
    //Collection<Movie> all = target.findAll()
    //System.out.println(target.findAll().get_embedded().getMovies().get(1).getDescription());
    //System.out.println(target.get("JOKER").getDescription());;
  }

}
