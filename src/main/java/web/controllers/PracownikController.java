package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.repositories.PracownikRepository;
import web.entities.Pracownik;

@Controller
public class PracownikController {

    @Autowired
    PracownikRepository pracownikRepository;

    @GetMapping("/pracownik_insert")
    public String insertPracownik(Model model) {
        model.addAttribute(new Pracownik()); 
        return "views/pracownikInsert";
    }
    @PostMapping("/pracownik_insert")
    public String insertPracownik(Model model, @Valid @ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikRepository.save(pracownik);
        return "index";
    }

}
