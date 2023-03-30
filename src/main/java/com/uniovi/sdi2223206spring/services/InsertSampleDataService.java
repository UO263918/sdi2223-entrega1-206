package com.uniovi.sdi2223206spring.services;

import javax.annotation.PostConstruct;

import com.uniovi.sdi2223206spring.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi2223206spring.entities.User;

import java.util.HashSet;
import java.util.Set;

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

        Set user1offers = new HashSet<Offer>() {
            {
                add(new Offer("U1TITULO1", "U1DESCRIPCION01", 10.0, user01));
                add(new Offer("U1TITULO2", "U1DESCRIPCION02", 10.0, user01));
                add(new Offer("U1TITULO3", "U1DESCRIPCION03", 10.0, user01));
                add(new Offer("U1TITULO4", "U1DESCRIPCION04", 10.0, user01));
                add(new Offer("U1TITULO5", "U1DESCRIPCION05", 10.0, user01));
                add(new Offer("U1TITULO6", "U1DESCRIPCION06", 10.0, user01));
                add(new Offer("U1TITULO7", "U1DESCRIPCION07", 10.0, user01));
                add(new Offer("U1TITULO8", "U1DESCRIPCION08", 10.0, user01));
                add(new Offer("U1TITULO9", "U1DESCRIPCION09", 10.0, user01));
                add(new Offer("U1TITULO10", "U1DESCRIPCION10", 10.0, user01));
            }
        };
        user01.setOffers(user1offers);

        Set user2offers = new HashSet<Offer>() {
            {
                add(new Offer("U2TITULO1", "U2DESCRIPCION01", 10.0, user02));
                add(new Offer("U2TITULO2", "U2DESCRIPCION02", 10.0, user02));
                add(new Offer("U2TITULO3", "U2DESCRIPCION03", 10.0, user02));
                add(new Offer("U2TITULO4", "U2DESCRIPCION04", 10.0, user02));
                add(new Offer("U2TITULO5", "U2DESCRIPCION05", 10.0, user02));
                add(new Offer("U2TITULO6", "U2DESCRIPCION06", 10.0, user02));
                add(new Offer("U2TITULO7", "U2DESCRIPCION07", 10.0, user02));
                add(new Offer("U2TITULO8", "U2DESCRIPCION08", 10.0, user02));
                add(new Offer("U2TITULO9", "U2DESCRIPCION09", 10.0, user02));
                add(new Offer("U2TITULO10", "U2DESCRIPCION10", 10.0, user02));
            }
        };
        user02.setOffers(user2offers);

        Set user3offers = new HashSet<Offer>() {
            {
                add(new Offer("U3TITULO1", "U3DESCRIPCION01", 10.0, user03));
                add(new Offer("U3TITULO2", "U3DESCRIPCION02", 10.0, user03));
                add(new Offer("U3TITULO3", "U3DESCRIPCION03", 10.0, user03));
                add(new Offer("U3TITULO4", "U3DESCRIPCION04", 10.0, user03));
                add(new Offer("U3TITULO5", "U3DESCRIPCION05", 10.0, user03));
                add(new Offer("U3TITULO6", "U3DESCRIPCION06", 10.0, user03));
                add(new Offer("U3TITULO7", "U3DESCRIPCION07", 10.0, user03));
                add(new Offer("U3TITULO8", "U3DESCRIPCION08", 10.0, user03));
                add(new Offer("U3TITULO9", "U3DESCRIPCION09", 10.0, user03));
                add(new Offer("U3TITULO10", "U3DESCRIPCION10", 10.0, user03));
            }
        };
        user03.setOffers(user3offers);

        Set user4offers = new HashSet<Offer>() {
            {
                add(new Offer("U4TITULO1", "U4DESCRIPCION01", 10.0, user04));
                add(new Offer("U4TITULO2", "U4DESCRIPCION02", 10.0, user04));
                add(new Offer("U4TITULO3", "U4DESCRIPCION03", 10.0, user04));
                add(new Offer("U4TITULO4", "U4DESCRIPCION04", 10.0, user04));
                add(new Offer("U4TITULO5", "U4DESCRIPCION05", 10.0, user04));
                add(new Offer("U4TITULO6", "U4DESCRIPCION06", 10.0, user04));
                add(new Offer("U4TITULO7", "U4DESCRIPCION07", 10.0, user04));
                add(new Offer("U4TITULO8", "U4DESCRIPCION08", 10.0, user04));
                add(new Offer("U4TITULO9", "U4DESCRIPCION09", 10.0, user04));
                add(new Offer("U4TITULO10", "U4DESCRIPCION10", 10.0, user04));
            }
        };
        user04.setOffers(user4offers);

        Set user5offers = new HashSet<Offer>() {
            {
                add(new Offer("U5TITULO1", "U5DESCRIPCION01", 10.0, user05));
                add(new Offer("U5TITULO2", "U5DESCRIPCION02", 10.0, user05));
                add(new Offer("U5TITULO3", "U5DESCRIPCION03", 10.0, user05));
                add(new Offer("U5TITULO4", "U5DESCRIPCION04", 10.0, user05));
                add(new Offer("U5TITULO5", "U5DESCRIPCION05", 10.0, user05));
                add(new Offer("U5TITULO6", "U5DESCRIPCION06", 10.0, user05));
                add(new Offer("U5TITULO7", "U5DESCRIPCION07", 10.0, user05));
                add(new Offer("U5TITULO8", "U5DESCRIPCION08", 10.0, user05));
                add(new Offer("U5TITULO9", "U5DESCRIPCION09", 10.0, user05));
                add(new Offer("U5TITULO10", "U5DESCRIPCION10", 10.0, user05));
            }
        };
        user05.setOffers(user5offers);

        Set user6offers = new HashSet<Offer>() {
            {
                add(new Offer("U6TITULO1", "U6DESCRIPCION01", 10.0, user06));
                add(new Offer("U6TITULO2", "U6DESCRIPCION02", 10.0, user06));
                add(new Offer("U6TITULO3", "U6DESCRIPCION03", 10.0, user06));
                add(new Offer("U6TITULO4", "U6DESCRIPCION04", 10.0, user06));
                add(new Offer("U6TITULO5", "U6DESCRIPCION05", 10.0, user06));
                add(new Offer("U6TITULO6", "U6DESCRIPCION06", 10.0, user06));
                add(new Offer("U6TITULO7", "U6DESCRIPCION07", 10.0, user06));
                add(new Offer("U6TITULO8", "U6DESCRIPCION08", 10.0, user06));
                add(new Offer("U6TITULO9", "U6DESCRIPCION09", 10.0, user06));
                add(new Offer("U6TITULO10", "U6DESCRIPCION10", 10.0, user06));
            }
        };
        user06.setOffers(user6offers);

        Set user7offers = new HashSet<Offer>() {
            {
                add(new Offer("U7TITULO1", "U7DESCRIPCION01", 10.0, user07));
                add(new Offer("U7TITULO2", "U7DESCRIPCION02", 10.0, user07));
                add(new Offer("U7TITULO3", "U7DESCRIPCION03", 10.0, user07));
                add(new Offer("U7TITULO4", "U7DESCRIPCION04", 10.0, user07));
                add(new Offer("U7TITULO5", "U7DESCRIPCION05", 10.0, user07));
                add(new Offer("U7TITULO6", "U7DESCRIPCION06", 10.0, user07));
                add(new Offer("U7TITULO7", "U7DESCRIPCION07", 10.0, user07));
                add(new Offer("U7TITULO8", "U7DESCRIPCION08", 10.0, user07));
                add(new Offer("U7TITULO9", "U7DESCRIPCION09", 10.0, user07));
                add(new Offer("U7TITULO10", "U7DESCRIPCION10", 10.0, user07));
            }
        };
        user07.setOffers(user7offers);

        Set user8offers = new HashSet<Offer>() {
            {
                add(new Offer("U8TITULO1", "U8DESCRIPCION01", 10.0, user08));
                add(new Offer("U8TITULO2", "U8DESCRIPCION02", 10.0, user08));
                add(new Offer("U8TITULO3", "U8DESCRIPCION03", 10.0, user08));
                add(new Offer("U8TITULO4", "U8DESCRIPCION04", 10.0, user08));
                add(new Offer("U8TITULO5", "U8DESCRIPCION05", 10.0, user08));
                add(new Offer("U8TITULO6", "U8DESCRIPCION06", 10.0, user08));
                add(new Offer("U8TITULO7", "U8DESCRIPCION07", 10.0, user08));
                add(new Offer("U8TITULO8", "U8DESCRIPCION08", 10.0, user08));
                add(new Offer("U8TITULO9", "U8DESCRIPCION09", 10.0, user08));
                add(new Offer("U8TITULO10", "U8DESCRIPCION10", 10.0, user08));
            }
        };
        user08.setOffers(user8offers);

        Set user9offers = new HashSet<Offer>() {
            {
                add(new Offer("U9TITULO1", "U9DESCRIPCION01", 10.0, user09));
                add(new Offer("U9TITULO2", "U9DESCRIPCION02", 10.0, user09));
                add(new Offer("U9TITULO3", "U9DESCRIPCION03", 10.0, user09));
                add(new Offer("U9TITULO4", "U9DESCRIPCION04", 10.0, user09));
                add(new Offer("U9TITULO5", "U9DESCRIPCION05", 10.0, user09));
                add(new Offer("U9TITULO6", "U9DESCRIPCION06", 10.0, user09));
                add(new Offer("U9TITULO7", "U9DESCRIPCION07", 10.0, user09));
                add(new Offer("U9TITULO8", "U9DESCRIPCION08", 10.0, user09));
                add(new Offer("U9TITULO9", "U9DESCRIPCION09", 10.0, user09));
                add(new Offer("U9TITULO10", "U9DESCRIPCION10", 10.0, user09));
            }
        };
        user09.setOffers(user9offers);

        Set user10offers = new HashSet<Offer>() {
            {
                add(new Offer("U10TITULO1", "U10DESCRIPCION01", 10.0, user10));
                add(new Offer("U10TITULO2", "U10DESCRIPCION02", 10.0, user10));
                add(new Offer("U10TITULO3", "U10DESCRIPCION03", 10.0, user10));
                add(new Offer("U10TITULO4", "U10DESCRIPCION04", 10.0, user10));
                add(new Offer("U10TITULO5", "U10DESCRIPCION05", 10.0, user10));
                add(new Offer("U10TITULO6", "U10DESCRIPCION06", 10.0, user10));
                add(new Offer("U10TITULO7", "U10DESCRIPCION07", 10.0, user10));
                add(new Offer("U10TITULO8", "U10DESCRIPCION08", 10.0, user10));
                add(new Offer("U10TITULO9", "U10DESCRIPCION09", 10.0, user10));
                add(new Offer("U10TITULO10", "U10DESCRIPCION10", 10.0, user10));
            }
        };
        user10.setOffers(user10offers);

        Set user11offers = new HashSet<Offer>() {
            {
                add(new Offer("U11TITULO1", "U11DESCRIPCION01", 10.0, user11));
                add(new Offer("U11TITULO2", "U11DESCRIPCION02", 10.0, user11));
                add(new Offer("U11TITULO3", "U11DESCRIPCION03", 10.0, user11));
                add(new Offer("U11TITULO4", "U11DESCRIPCION04", 10.0, user11));
                add(new Offer("U11TITULO5", "U11DESCRIPCION05", 10.0, user11));
                add(new Offer("U11TITULO6", "U11DESCRIPCION06", 10.0, user11));
                add(new Offer("U11TITULO7", "U11DESCRIPCION07", 10.0, user11));
                add(new Offer("U11TITULO8", "U11DESCRIPCION08", 10.0, user11));
                add(new Offer("U11TITULO9", "U11DESCRIPCION09", 10.0, user11));
                add(new Offer("U11TITULO10", "U11DESCRIPCION10", 10.0, user11));
            }
        };
        user11.setOffers(user11offers);

        Set user12offers = new HashSet<Offer>() {
            {
                add(new Offer("U12TITULO1", "U12DESCRIPCION01", 10.0, user12));
                add(new Offer("U12TITULO2", "U12DESCRIPCION02", 10.0, user12));
                add(new Offer("U12TITULO3", "U12DESCRIPCION03", 10.0, user12));
                add(new Offer("U12TITULO4", "U12DESCRIPCION04", 10.0, user12));
                add(new Offer("U12TITULO5", "U12DESCRIPCION05", 10.0, user12));
                add(new Offer("U12TITULO6", "U12DESCRIPCION06", 10.0, user12));
                add(new Offer("U12TITULO7", "U12DESCRIPCION07", 10.0, user12));
                add(new Offer("U12TITULO8", "U12DESCRIPCION08", 10.0, user12));
                add(new Offer("U12TITULO9", "U12DESCRIPCION09", 10.0, user12));
                add(new Offer("U12TITULO10", "U12DESCRIPCION10", 10.0, user12));
            }
        };
        user12.setOffers(user12offers);

        Set user13offers = new HashSet<Offer>() {
            {
                add(new Offer("U13TITULO1", "U13DESCRIPCION01", 10.0, user13));
                add(new Offer("U13TITULO2", "U13DESCRIPCION02", 10.0, user13));
                add(new Offer("U13TITULO3", "U13DESCRIPCION03", 10.0, user13));
                add(new Offer("U13TITULO4", "U13DESCRIPCION04", 10.0, user13));
                add(new Offer("U13TITULO5", "U13DESCRIPCION05", 10.0, user13));
                add(new Offer("U13TITULO6", "U13DESCRIPCION06", 10.0, user13));
                add(new Offer("U13TITULO7", "U13DESCRIPCION07", 10.0, user13));
                add(new Offer("U13TITULO8", "U13DESCRIPCION08", 10.0, user13));
                add(new Offer("U13TITULO9", "U13DESCRIPCION09", 10.0, user13));
                add(new Offer("U13TITULO10", "U13DESCRIPCION10", 10.0, user13));
            }
        };
        user13.setOffers(user13offers);

        Set user14offers = new HashSet<Offer>() {
            {
                add(new Offer("U14TITULO1", "U14DESCRIPCION01", 10.0, user14));
                add(new Offer("U14TITULO2", "U14DESCRIPCION02", 10.0, user14));
                add(new Offer("U14TITULO3", "U14DESCRIPCION03", 10.0, user14));
                add(new Offer("U14TITULO4", "U14DESCRIPCION04", 10.0, user14));
                add(new Offer("U14TITULO5", "U14DESCRIPCION05", 10.0, user14));
                add(new Offer("U14TITULO6", "U14DESCRIPCION06", 10.0, user14));
                add(new Offer("U14TITULO7", "U14DESCRIPCION07", 10.0, user14));
                add(new Offer("U14TITULO8", "U14DESCRIPCION08", 10.0, user14));
                add(new Offer("U14TITULO9", "U14DESCRIPCION09", 10.0, user14));
                add(new Offer("U14TITULO10", "U14DESCRIPCION10", 10.0, user14));
            }
        };
        user14.setOffers(user14offers);

        Set user15offers = new HashSet<Offer>() {
            {
                add(new Offer("U15TITULO1", "U15DESCRIPCION01", 10.0, user15));
                add(new Offer("U15TITULO2", "U15DESCRIPCION02", 10.0, user15));
                add(new Offer("U15TITULO3", "U15DESCRIPCION03", 10.0, user15));
                add(new Offer("U15TITULO4", "U15DESCRIPCION04", 10.0, user15));
                add(new Offer("U15TITULO5", "U15DESCRIPCION05", 10.0, user15));
                add(new Offer("U15TITULO6", "U15DESCRIPCION06", 10.0, user15));
                add(new Offer("U15TITULO7", "U15DESCRIPCION07", 10.0, user15));
                add(new Offer("U15TITULO8", "U15DESCRIPCION08", 10.0, user15));
                add(new Offer("U15TITULO9", "U15DESCRIPCION09", 10.0, user15));
                add(new Offer("U15TITULO10", "U15DESCRIPCION10", 10.0, user15));
            }
        };
        user15.setOffers(user15offers);

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
