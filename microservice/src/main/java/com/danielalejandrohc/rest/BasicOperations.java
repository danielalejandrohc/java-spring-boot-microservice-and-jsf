package com.danielalejandrohc.rest;

import java.util.List;

public interface BasicOperations<T, G> {
    public List<T> findAll();
    public T find(G id);
    public void delete(String id);
    public T update(T id);
}
