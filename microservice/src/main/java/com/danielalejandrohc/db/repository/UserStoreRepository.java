package com.danielalejandrohc.db.repository;

import com.danielalejandrohc.db.model.UserStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoreRepository extends JpaRepository<UserStore, String> {

    public UserStore findByUsernameAndPassword(String username, String password);
}
