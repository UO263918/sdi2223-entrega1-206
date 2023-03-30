package com.uniovi.sdi2223206spring.repositories;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OffersRepository extends CrudRepository<Offer, Long>{

    @Query("SELECT r FROM Offer r WHERE (r.user.email NOT LIKE (?2))")
    Page<Offer> findAll(Pageable pageable,String email);

    @Query("SELECT r FROM Offer r WHERE r.user = ?1 ORDER BY r.id ASC")
    List<Offer> findAllByUser(User user);

    @Query("SELECT r FROM Offer r WHERE r.userBuyer = ?1 ORDER BY r.id ASC")
    List<Offer> findBoughtOffersByUser(User user);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.title) LIKE LOWER (?1)) AND r.user.email NOT LIKE (?2)")
    Page<Offer> searchByTitle(Pageable pageable, String searchText, String email);
}
