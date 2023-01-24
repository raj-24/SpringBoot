package com.example.nani.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.nani.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


}
