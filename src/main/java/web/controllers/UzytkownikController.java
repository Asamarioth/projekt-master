package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.entities.Uzytkownik;
import web.services.UzytkownikService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import web.repositories.UzytkownikRepository;

@Controller
public class UzytkownikController {

    @Autowired
    UzytkownikService memberService;

    @Autowired
    UzytkownikRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Uzytkownik());
        return "views/registerForm";
    }
    @PostMapping("/register")
    public String registerMember(@Valid @ModelAttribute("member") Uzytkownik member, Model model){
        String userName = member.getUserName();
        if (memberRepository.findByUserName(userName) != null){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "views/loginForm";
    }
}
