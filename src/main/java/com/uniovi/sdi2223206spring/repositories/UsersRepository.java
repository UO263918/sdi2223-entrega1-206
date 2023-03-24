package com.uniovi.sdi2223206spring.repositories;

import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE (u.email NOT LIKE (?1))")
    List<User> findAllAdmin(String email);
}
