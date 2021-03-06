package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entities.Faktura;
import web.repositories.PracownikRepository;
import web.entities.Pracownik;
import web.repositories.FakturaRepository;

@Controller
public class PracownikController {

    @Autowired
    PracownikRepository pracownikRepository;
    @Autowired
    FakturaRepository fakturaRepository;

    @GetMapping("/pracownik_insert")
    public String insertPracownik(Model model) {
        model.addAttribute(new Pracownik()); 
        return "views/pracownikInsert";
    }
    @PostMapping("/pracownik_insert")
    public String insertPracownik(Model model, @Valid @ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikRepository.save(pracownik);
        return "redirect:/pracownicy_print";
    }
    
    @GetMapping("pracownicy_print")
    public String printPracownik(Model model) {
        model.addAttribute("pracownicy", pracownikRepository.findAll());
        return "views/pracownikPrint";
    }
    
    @GetMapping("pracownik_modify")
    public String modifyPracownik(Model model, int id) {
        model.addAttribute("pracownik", pracownikRepository.getOne(id));
        return "views/pracownikModify";
    }

    @PostMapping("pracownik_modify")
    public String modifyPracownik(Model model, @Valid @ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikRepository.save(pracownik);

        return "redirect:/pracownicy_print";

    }
    @GetMapping("pracownik_faktury")
    public String fakturyPracownik(Model model, @RequestParam int id) {
    List<Faktura> faktury = fakturaRepository.findAllByIdPracownika(id);
    if(faktury.isEmpty()){
        model.addAttribute("errorMsg", true);
    }
    else {
        model.addAttribute("faktury", faktury);
    }
     model.addAttribute("pracownik", pracownikRepository.getOne(id));
    
    return "views/pracownikFaktury";
}

}
