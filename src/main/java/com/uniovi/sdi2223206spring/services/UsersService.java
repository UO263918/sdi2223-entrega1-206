package com.uniovi.sdi2223206spring.services;

import java.util.*;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi2223206spring.entities.*;
import com.uniovi.sdi2223206spring.repositories.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {

    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public List<User> getUsersAdmin(String email) {
        List<User> users = new ArrayList<User>();
        usersRepository.findAllAdmin(email).forEach(users::add);
        return users;
    }

    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getEmail() != "admin@email.com") {
            user.setRole("ROLE_STUDENT");
            user.setWallet(100.0);
        }
        usersRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public void deleteUserByEmail(String em) {
        User u = usersRepository.findByEmail(em);
        usersRepository.deleteById(u.getId());
    }
}
