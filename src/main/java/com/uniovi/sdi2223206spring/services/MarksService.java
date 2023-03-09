package com.uniovi.sdi2223206spring.services;

import com.uniovi.sdi2223206spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import com.uniovi.sdi2223206spring.entities.Mark;
import com.uniovi.sdi2223206spring.repositories.MarksRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

@Service
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;

    public List<Mark> getMarks() {
        List<Mark> marks = new ArrayList<Mark>();
        marksRepository.findAll().forEach(marks::add);
        return marks;
    }

    public Mark getMark(Long id){
        return marksRepository.findById(id).get();
    }

    public void addMark(Mark mark) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        marksRepository.save(mark);
    }

    public void deleteMark(Long id) {
        marksRepository.deleteById(id);
    }

    public void setMarkResend(boolean revised, Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String dni = auth.getName();

        Mark mark = marksRepository.findById(id).get();

        if(mark.getUser().getDni().equals(dni) ) {
            marksRepository.updateResend(revised, id);
        }
    }

    public List<Mark> getMarksForUser(User user) {
        List<Mark> marks = new ArrayList<>();
        if (user.getRole().equals("ROLE_STUDENT")) {
            marks = marksRepository.findAllByUser(user);
        }
        if (user.getRole().equals("ROLE_PROFESSOR")) {
            marks = getMarks();
        }
        return marks;
    }

    public List<Mark> searchMarksByDescriptionAndNameForUser(String searchText, User user) {
        List<Mark> marks = new ArrayList<>();
        searchText = "%"+searchText+"%";
        if (user.getRole().equals("ROLE_STUDENT")) {
            marks = marksRepository.searchByDescriptionNameAndUser(searchText, user);
        }
        if (user.getRole().equals("ROLE_PROFESSOR")) {
            marks = marksRepository.searchByDescriptionAndName(searchText);
        }
        return marks;
    }
}
