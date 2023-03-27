package com.uniovi.sdi2223206spring.repositories;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OffersRepository extends CrudRepository<Offer, Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Offer SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);

    Page<Offer> findAll(Pageable pageable);

    @Query("SELECT r FROM Offer r WHERE r.user = ?1 ORDER BY r.id ASC")
    Page<Offer> findAllByUser(Pageable pageable, User user);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.description) LIKE LOWER (?1) OR LOWER(r.user.name) LIKE LOWER (?1))")
    Page<Offer> searchByDescriptionAndName(Pageable pageable, String searchText);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.description) LIKE LOWER (?1) OR LOWER(r.user.name) LIKE LOWER (?1)) AND r.user = ?2")
    Page<Offer> searchByDescriptionNameAndUser(Pageable pageable, String searchText, User user);
}
