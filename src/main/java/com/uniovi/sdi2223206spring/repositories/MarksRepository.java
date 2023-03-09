package com.uniovi.sdi2223206spring.repositories;

import com.uniovi.sdi2223206spring.entities.Mark;
import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface MarksRepository extends CrudRepository<Mark, Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2 ORDER BY r.id ASC")
    void updateResend(Boolean resend, Long id);

    List<Mark> findAllByUser(User user);
}
