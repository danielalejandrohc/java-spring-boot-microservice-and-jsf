package com.danielalejandrohc.db.repository;

import com.danielalejandrohc.db.model.URLShorter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLRepository extends JpaRepository<URLShorter, Integer>  {

    public URLShorter findByCode(String code);

}
