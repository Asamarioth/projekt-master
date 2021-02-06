package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.entities.Uzytkownik;

import java.security.Principal;
import java.sql.SQLOutput;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import web.repositories.*;

@Controller
public class IndexController {

    @Autowired
    UzytkownikRepository memberRepository;
    @Autowired
    KlientRepository klientRepository;
    @Autowired
    FakturaRepository  fakturaRepository;
    @Autowired
    PracownikRepository pracownikRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Uzytkownik member){
        if(principal == null){
            return "views/loginForm";
        }

        model.addAttribute("klientCount",klientRepository.count());
        model.addAttribute("pracownikCount",pracownikRepository.count());
        model.addAttribute("fakturaCount",fakturaRepository.count());
        model.addAttribute("fakturaAvg",fakturaRepository.naleznoscAVg());
        model.addAttribute("paliwoSum",fakturaRepository.paliwoSum());
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
    
    @GetMapping("/errorPage")
    public String errorPage(Model model) {
        return "views/errorPage";
    }
}
