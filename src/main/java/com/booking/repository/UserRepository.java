package com.booking.repository;

import com.booking.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<Users,Integer> {

    public Users findByUsername(String username);
}
