package com.uniovi.sdi2223206spring.services;

import org.springframework.stereotype.Service;

@Service
public class RolesService {
    String[] roles = {"ROLE_CLIENT", "ROLE_ADMIN"};

    public String[] getRoles() {
        return roles;
    }
}
