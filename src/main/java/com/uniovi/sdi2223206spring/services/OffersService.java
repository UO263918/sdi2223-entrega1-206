package com.uniovi.sdi2223206spring.services;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.uniovi.sdi2223206spring.repositories.OffersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class OffersService {
    @Autowired
    private OffersRepository offersRepository;

    public Page<Offer> getoffers(Pageable pageable) {
        Page<Offer> offers = offersRepository.findAll(pageable);
        return offers;
    }

    public Offer getoffer(Long id){
        return offersRepository.findById(id).get();
    }

    public void addoffer(Offer offer) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        offersRepository.save(offer);
    }

    public void deleteoffer(Long id) {
        offersRepository.deleteById(id);
    }

    public void setofferResend(boolean revised, Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Offer offer = offersRepository.findById(id).get();

        if(offer.getUser().getEmail().equals(email) ) {
            offersRepository.updateResend(revised, id);
        }
    }

    public Page<Offer> getoffersForUser(Pageable pageable, User user) {
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        if (user.getRole().equals("ROLE_CLIENT")) {
            offers = offersRepository.findAllByUser(pageable, user);
        }
        return offers;
    }

    public Page<Offer> searchoffersByDescriptionAndNameForUser(Pageable pageable, String searchText, User user) {
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        searchText = "%"+searchText+"%";
        if (user.getRole().equals("ROLE_CLIENT")) {
            offers = offersRepository.searchByDescriptionNameAndUser(pageable, searchText, user);
        }
        return offers;
    }
}
