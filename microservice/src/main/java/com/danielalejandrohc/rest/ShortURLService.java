package com.danielalejandrohc.rest;

import com.danielalejandrohc.db.model.URLShorter;
import com.danielalejandrohc.db.repository.ShortURLRepository;
import com.danielalejandrohc.services.url.ShortURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortURLService  {

    @Autowired
    private ShortURLRepository repository;
    @Autowired
    private ShortURL shortUrl;

    @GetMapping(path = "/shortUrl")
    public List<URLShorter> findAll() {
        return repository.findAll();
    }


    @PostMapping(path = "/shortUrl")
    public URLShorter update(@RequestBody URLShorter object) {
        URLShorter currentObject = repository.save(object);
        String code = shortUrl.idToShortURL(currentObject.getId());
        currentObject.setCode(shortUrl.idToShortURL(currentObject.getId()));
        return repository.save(currentObject);
    }

    @GetMapping(path = "/shortUrl/{code}")
    public String findByCode(@PathVariable String code) {
        return repository.findByCode(code).getUrl();
    }
}
