package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
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
        try {
            model.addAttribute("faktura", new Faktura());
            model.addAttribute("klienci", klientRepository.findAll());
            model.addAttribute("pracownicy", pracownikRepository.findAll());
            return "views/fakturaInsert";
        } catch (Exception e) {
            return "views/errorPage";
        }
    }

    @PostMapping("/faktura_insert")
    public String insertFaktura(Model model, @Valid @ModelAttribute("faktura") Faktura faktura) {
        try {
            fakturaRepository.save(faktura);
            return "redirect:/faktury_print";
        } catch (Exception e) {
            return "views/errorPage";
        }
    }

    @GetMapping("/faktury_print")
    public String printFaktura(Model model) {
        try {
            model.addAttribute("faktury", fakturaRepository.findAll());
            return "views/fakturaPrint";
        } catch (Exception e) {
            return "views/errorPage";
        }
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
        try {
            fakturaRepository.save(faktura);
            return "redirect:/faktury_print";
        } catch (Exception e) {
            return "views/errorPage";
        }
    }

    @GetMapping("/faktura_details")
    public String detailsFaktura(Model model, int id) {
        try {
            model.addAttribute("faktura", fakturaRepository.getOne(id));
            return "views/fakturaDetails";
        } catch (Exception e) {
            return "views/errorPage";
        }
    }

}
