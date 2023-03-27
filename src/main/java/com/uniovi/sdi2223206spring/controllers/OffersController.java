package com.uniovi.sdi2223206spring.controllers;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import com.uniovi.sdi2223206spring.services.OffersService;
import com.uniovi.sdi2223206spring.services.UsersService;
import com.uniovi.sdi2223206spring.validators.AddOfferFormValidator;
import com.uniovi.sdi2223206spring.validators.SignUpFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.LinkedList;

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
    public String getList(Model model, Pageable pageable, Principal principal,
                          @RequestParam(value="", required = false) String searchText){
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        if(searchText != null && !searchText.isEmpty()){
            offers = offersService.searchoffersByDescriptionAndNameForUser(pageable, searchText, user);
        } else {
            offers = offersService.getoffersForUser(pageable, user);
        }
        model.addAttribute("offerList", offers.getContent());
        model.addAttribute("page", offers);
        return "offer/list";
    }

    @RequestMapping(value="/offer/add")
    public String getoffer(Model model){
        model.addAttribute("offer", new Offer());
        return "offer/add";
    }
    @RequestMapping(value = "/offer/add", method = RequestMethod.POST)
    public String setoffer(@ModelAttribute Offer offer, BindingResult result) {
        addOfferFormValidator.validate(offer,result);
        if(result.hasErrors()){
            return "offer/add";
        }
        offersService.addoffer(offer);
        return "redirect:/offer/list";
    }

    @RequestMapping("/offer/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("offer", offersService.getoffer(id));
        return "offer/details";
    }

    @RequestMapping("/offer/delete/{id}")
    public String deleteoffer(@PathVariable Long id) {
        offersService.deleteoffer(id);
        return "redirect:/offer/list";
    }

    @RequestMapping(value = "/offer/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("offer", offersService.getoffer(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "offer/edit";
    }

    /*@RequestMapping(value="/offer/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Offer offer, @PathVariable Long id){
        Offer originalOffer = offersService.getoffer(id);
        // modificar solo score y description
        originalOffer.setScore(offer.getScore());
        originalOffer.setDescription(offer.getDescription());
        offersService.addoffer(originalOffer);
        return "redirect:/offer/details/"+id;
    }*/

    @RequestMapping("/offer/list/update")
    public String updateList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        Page<Offer> offers = offersService.getoffersForUser(pageable, user);
        model.addAttribute("offerList", offers.getContent());
        return "offer/list :: tableoffers";
    }

    @RequestMapping(value = "/offer/{id}/resend", method = RequestMethod.GET)
    public String setResendTrue(@PathVariable Long id) {
        offersService.setofferResend(true, id);
        return "redirect:/offer/list";
    }

    @RequestMapping(value = "/offer/{id}/noresend", method = RequestMethod.GET)
    public String setResendFalse(@PathVariable Long id) {
        offersService.setofferResend(false, id);
        return "redirect:/offer/list";
    }
}
