package com.uniovi.sdi2223206spring.controllers;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import com.uniovi.sdi2223206spring.services.OffersService;
import com.uniovi.sdi2223206spring.services.UsersService;
import com.uniovi.sdi2223206spring.validators.AddOfferFormValidator;
import com.uniovi.sdi2223206spring.validators.SignUpFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
public class OffersController {

    @Autowired
    private AddOfferFormValidator addOfferFormValidator;

    @Autowired //Inyectar el servicio
    private OffersService offersService;

    @Autowired private
    UsersService usersService;

    @RequestMapping("/offer/list")
    public String getList(Model model, Principal principal){
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        List<Offer> offers;
        offers = offersService.getOffersForUser(user);
        model.addAttribute("offerList", offers);
        return "offer/list";
    }

    @RequestMapping("/offer/listBoughtOffers")
    public String getBuyedList(Model model, Principal principal){
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        List<Offer> offers;
        offers = offersService.getBoughtOffersForUser(user);
        model.addAttribute("offerBoughtList", offers);
        return "offer/listBoughtOffers";
    }

    @RequestMapping("/offer/listAll")
    public String getList(Model model, Pageable pageable, Principal principal,
                          @RequestParam(value="", required = false) String searchText){
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        if(searchText != null && !searchText.isEmpty()){
            offers = offersService.searchOffersByTitle(pageable, searchText, user);
        } else {
            offers = offersService.getOffers(pageable, email);
        }
        model.addAttribute("offerListPageable", offers.getContent());
        model.addAttribute("page", offers);
        return "offer/listAll";
    }

    @RequestMapping(value="/offer/add")
    public String getOffer(Model model){
        model.addAttribute("offer", new Offer());
        return "offer/add";
    }
    @RequestMapping(value = "/offer/add", method = RequestMethod.POST)
    public String setOffer(@ModelAttribute Offer offer, BindingResult result) {
        addOfferFormValidator.validate(offer,result);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User activeUser = usersService.getUserByEmail(auth.getName());
        if(result.hasErrors()){
            return "offer/add";
        }
        offersService.addOffer(offer, activeUser);
        return "redirect:/offer/list";
    }

    @RequestMapping("/offer/delete/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offersService.deleteOffer(id);
        return "redirect:/offer/list";
    }

    @RequestMapping(value = "/offer/buy/{id}")
    public String buyOffer(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User activeUser = usersService.getUserByEmail(auth.getName());
        Offer offer = offersService.getOffer(id);
        offersService.buyOffer(activeUser, offer);
        return "redirect:/offer/listAll";
    }

}
