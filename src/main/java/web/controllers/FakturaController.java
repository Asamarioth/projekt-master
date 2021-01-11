package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.repositories.KlientRepository;
import web.repositories.PracownikRepository;
import web.repositories.RejonRepository;
import web.entities.Klient;
import web.entities.Faktura;
import web.entities.Rejon;
import web.entities.GrupaTaryfowa;
import web.repositories.FakturaRepository;

@Controller
public class FakturaController {

    @Autowired
    KlientRepository klientRepository;
    @Autowired
    PracownikRepository pracownikRepository;
    @Autowired
    FakturaRepository fakturaRepository;

    @GetMapping("/faktura_insert")
    public String insertFaktura(Model model) {
        model.addAttribute("faktura", new Faktura());
        model.addAttribute("klienci", klientRepository.findAll());
        model.addAttribute("pracownicy", pracownikRepository.findAll());
        return "views/fakturaInsert";
    }

    @PostMapping("/faktura_insert")
    public String insertKlient(Model model, @Valid @ModelAttribute("faktura") Faktura faktura) {
        fakturaRepository.save(faktura);
        return "redirect:/";
    }

    @GetMapping("/faktury_print")
    public String printFaktura(Model model) {
        model.addAttribute("faktury", fakturaRepository.findAll());
        return "views/fakturaPrint";
    }

    @GetMapping("faktura_modify")
    public String modifyFaktura(Model model, int id) {
        model.addAttribute("faktura", fakturaRepository.getOne(id));
        model.addAttribute("klienci", klientRepository.findAll());
        model.addAttribute("pracownicy", pracownikRepository.findAll());
        return "views/fakturaModify";
    }

    @PostMapping("faktura_modify")
    public String modifyfaktura(Model model, @Valid @ModelAttribute("faktura") Faktura faktura) {
        fakturaRepository.save(faktura);

        return "redirect:/";

    }

}
