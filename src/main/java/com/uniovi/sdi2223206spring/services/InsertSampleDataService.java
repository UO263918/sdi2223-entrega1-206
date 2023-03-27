package com.uniovi.sdi2223206spring.services;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi2223206spring.entities.User;

@Service
public class InsertSampleDataService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesService rolesService;

    @PostConstruct
    public void init() {
        User user16 = new User("admin@email.com", "Admin1", "Admin1");
        user16.setPassword("admin");
        user16.setRole(rolesService.getRoles()[1]);
        User user01 = new User("user01@email.com", "user01", "user01");
        user01.setPassword("user01");
        user01.setRole(rolesService.getRoles()[0]);
        User user02 = new User("user02@email.com", "user02", "user02");
        user02.setPassword("user02");
        user02.setRole(rolesService.getRoles()[0]);
        User user03 = new User("user03@email.com", "user03", "user03");
        user03.setPassword("user03");
        user03.setRole(rolesService.getRoles()[0]);
        User user04 = new User("user04@email.com", "user04", "user04");
        user04.setPassword("user04");
        user04.setRole(rolesService.getRoles()[0]);
        User user05 = new User("user05@email.com", "user05", "user05");
        user05.setPassword("user05");
        user05.setRole(rolesService.getRoles()[0]);
        User user06 = new User("user06@email.com", "user06", "user06");
        user06.setPassword("user06");
        user06.setRole(rolesService.getRoles()[0]);
        User user07 = new User("user07@email.com", "user07", "user07");
        user07.setPassword("user07");
        user07.setRole(rolesService.getRoles()[0]);
        User user08 = new User("user08@email.com", "user08", "user08");
        user08.setPassword("user08");
        user08.setRole(rolesService.getRoles()[0]);
        User user09 = new User("user09@email.com", "user09", "user09");
        user09.setPassword("user09");
        user09.setRole(rolesService.getRoles()[0]);
        User user10 = new User("user10@email.com", "user10", "user10");
        user10.setPassword("user10");
        user10.setRole(rolesService.getRoles()[0]);
        User user11 = new User("user11@email.com", "user11", "user11");
        user11.setPassword("user11");
        user11.setRole(rolesService.getRoles()[0]);
        User user12 = new User("user12@email.com", "user12", "user12");
        user12.setPassword("user12");
        user12.setRole(rolesService.getRoles()[0]);
        User user13 = new User("user13@email.com", "user13", "user13");
        user13.setPassword("user13");
        user13.setRole(rolesService.getRoles()[0]);
        User user14 = new User("user14@email.com", "user14", "user14");
        user14.setPassword("user14");
        user14.setRole(rolesService.getRoles()[0]);
        User user15 = new User("user15@email.com", "user15", "user15");
        user15.setPassword("user15");
        user15.setRole(rolesService.getRoles()[0]);

        /*Set user1offers = new HashSet<offer>() {
            {
                add(new offer("Nota A1", 10.0, user1));
                add(new offer("Nota A2", 9.0, user1));
                add(new offer("Nota A3", 7.0, user1));
                add(new offer("Nota A4", 6.5, user1));
            }
        };
        user1.setoffers(user1offers);

        Set user2offers = new HashSet<offer>() {
            {
                add(new offer("Nota B1", 5.0, user2));
                add(new offer("Nota B2", 4.3, user2));
                add(new offer("Nota B3", 8.0, user2));
                add(new offer("Nota B4", 3.5, user2));
            }
        };
        user2.setoffers(user2offers);

        Set user3offers = new HashSet<offer>() {
            {
                add(new offer("Nota C1", 5.5, user3));
                add(new offer("Nota C2", 6.6, user3));
                add(new offer("Nota C3", 7.0, user3));
            }
        };
        user3.setoffers(user3offers);

        Set user4offers = new HashSet<offer>() {
            {
                add(new offer("Nota D1", 10.0, user4));
                add(new offer("Nota D2", 8.0, user4));
                add(new offer("Nota D3", 9.0, user4));
            }
        };
        user4.setoffers(user4offers);*/

        usersService.addUser(user01);
        usersService.addUser(user02);
        usersService.addUser(user03);
        usersService.addUser(user04);
        usersService.addUser(user05);
        usersService.addUser(user06);
        usersService.addUser(user07);
        usersService.addUser(user08);
        usersService.addUser(user09);
        usersService.addUser(user10);
        usersService.addUser(user11);
        usersService.addUser(user12);
        usersService.addUser(user13);
        usersService.addUser(user14);
        usersService.addUser(user15);
        usersService.addUser(user16);
    }
}
