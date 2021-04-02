package com.danielalejandrohc.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URLShorter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String url;

    public URLShorter() {

    }

    public URLShorter(Integer id, String code, String url) {
        this.id = id;
        this.code = code;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URLShorter{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
