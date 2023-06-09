package com.uniovi.sdi2223206spring.validators;

import com.uniovi.sdi2223206spring.entities.Offer;
import com.uniovi.sdi2223206spring.entities.User;
import com.uniovi.sdi2223206spring.services.OffersService;
import com.uniovi.sdi2223206spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddOfferFormValidator implements Validator{

    @Autowired
    private OffersService offersService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Offer.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Offer offer = (Offer) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Error.empty");

        if (offer.getTitle().length() < 5 || offer.getTitle().length() > 24) {
            errors.rejectValue("title", "Error.addOffer.title.length");
        }

        if (offer.getDescription().length() < 5 || offer.getDescription().length() > 24) {
            errors.rejectValue("description", "Error.addOffer.description.length");
        }
    }
}
