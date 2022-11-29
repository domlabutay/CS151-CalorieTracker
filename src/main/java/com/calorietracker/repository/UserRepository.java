package com.calorietracker.repository;

import com.calorietracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{name:'?0'}")
    User findUserByUserName(String username);
    User findByEmail(String email);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'password' : 1}")
    List<User> findAll(String category);

    public long count();
}
