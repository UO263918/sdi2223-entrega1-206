package com.uniovi.sdi2223206spring.controllers;

import com.uniovi.sdi2223206spring.entities.Mark;
import com.uniovi.sdi2223206spring.entities.User;
import com.uniovi.sdi2223206spring.services.MarksService;
import com.uniovi.sdi2223206spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;

    @Autowired private
    UsersService usersService;

    @RequestMapping("/mark/list")
    public String getList(Model model, Pageable pageable, Principal principal,
                          @RequestParam(value="", required = false) String searchText){
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        Page<Mark> marks = new PageImpl<Mark>(new LinkedList<Mark>());
        if(searchText != null && !searchText.isEmpty()){
            marks = marksService.searchMarksByDescriptionAndNameForUser(pageable, searchText, user);
        } else {
            marks = marksService.getMarksForUser(pageable, user);
        }
        model.addAttribute("markList", marks.getContent());
        model.addAttribute("page", marks);
        return "mark/list";
    }

    @RequestMapping(value="/mark/add")
    public String getMark(Model model){
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/add";
    }


    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id){
        Mark originalMark = marksService.getMark(id);
        // modificar solo score y description
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/"+id;
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        Page<Mark> marks = marksService.getMarksForUser(pageable, user);
        model.addAttribute("markList", marks.getContent());
        return "mark/list :: tableMarks";
    }

    @RequestMapping(value = "/mark/{id}/resend", method = RequestMethod.GET)
    public String setResendTrue(@PathVariable Long id) {
        marksService.setMarkResend(true, id);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/{id}/noresend", method = RequestMethod.GET)
    public String setResendFalse(@PathVariable Long id) {
        marksService.setMarkResend(false, id);
        return "redirect:/mark/list";
    }
}
