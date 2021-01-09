package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.entities.Uzytkownik;

import java.security.Principal;
import java.sql.SQLOutput;
import java.util.Date;
import org.springframework.web.bind.support.SessionStatus;
import web.repositories.UzytkownikRepository;

@Controller
public class IndexController {

    @Autowired
    UzytkownikRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Uzytkownik member){
        if(principal == null){
            return "views/loginForm";
        }
        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        return "index";
    }
    
    @GetMapping("/logout")
    public String logout(Model model, Principal principal, SessionStatus status) {
        if(principal != null) {
            status.setComplete();
        }
        return "views/loginForm";
    }
}