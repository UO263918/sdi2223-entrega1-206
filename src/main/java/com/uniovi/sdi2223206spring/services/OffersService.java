package com.uniovi.sdi2223206spring.services;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import com.uniovi.sdi2223206spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.uniovi.sdi2223206spring.repositories.OffersRepository;

import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class OffersService {
    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private UsersRepository usersRepository;

    public Page<Offer> getOffers(Pageable pageable, String email) {
        Page<Offer> offers = offersRepository.findAll(pageable, email);
        return offers;
    }

    public Offer getOffer(Long id){
        return offersRepository.findById(id).get();
    }

    public void addOffer(Offer offer, User activeUser) {
        offer.setUser(activeUser);
        offer.setCreationDate(new Date(new java.util.Date().getTime()));
        activeUser.getOffers().add(offer);
        offersRepository.save(offer);
        usersRepository.save(activeUser);
    }

    public void deleteOffer(Long id) {
        offersRepository.deleteById(id);
    }

    public void buyOffer(User user, Offer offer) {
        if (user.getWallet() >= offer.getPrice() && user.getEmail() != offer.getUser().getEmail()) {
            offer.setSold(true);
            user.setWallet(user.getWallet() - offer.getPrice());
            user.getBuyedOffers().add(offer);
            offer.setUserBuyer(user);
            offersRepository.save(offer);
            usersRepository.save(user);
        }
    }

    public List<Offer> getOffersForUser(User user) {
        List<Offer> offers;
        offers = offersRepository.findAllByUser(user);
        return offers;
    }

    public List<Offer> getBoughtOffersForUser(User user) {
        List<Offer> offers;
        offers = offersRepository.findBoughtOffersByUser(user);
        return offers;
    }

    public Page<Offer> searchOffersByTitle(Pageable pageable, String searchText, User user) {
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        searchText = "%"+searchText+"%";
        if (user.getRole().equals("ROLE_CLIENT")) {
            offers = offersRepository.searchByTitle(pageable, searchText, user.getEmail());
        }
        return offers;
    }
}
