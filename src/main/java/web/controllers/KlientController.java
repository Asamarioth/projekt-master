package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.repositories.KlientRepository;
import web.repositories.GrupaTaryfowaRepository;
import web.repositories.FakturaRepository;
import web.repositories.RejonRepository;
import web.entities.Klient;
import web.entities.Rejon;
import web.entities.GrupaTaryfowa;

@Controller
public class KlientController {

    @Autowired
    KlientRepository klientRepository;
    @Autowired
    GrupaTaryfowaRepository grupaTaryfowaRepository;
    @Autowired
    RejonRepository rejonRepository;
    @Autowired
    FakturaRepository fakturaRepository;

    @GetMapping("/klient_insert")
    public String insertKlient(Model model) {
        model.addAttribute("klient", new Klient());
        model.addAttribute("taryfy", grupaTaryfowaRepository.findAll());
        model.addAttribute("rejony", rejonRepository.findAll());
        return "views/klientInsert";
    }

    @PostMapping("/klient_insert")
    public String insertKlient(Model model, @Valid @ModelAttribute("klient") Klient klient) {
        klientRepository.save(klient);
        return "redirect:/klienci_print";
    }

    @GetMapping("/klienci_print")
    public String printKlient(Model model) {
        model.addAttribute("klienci", klientRepository.findAll());
        return "views/klientPrint";
    }
    
     @GetMapping("klient_modify")
    public String modifyKlient(Model model, @RequestParam int id) {

        model.addAttribute("klient", klientRepository.getOne(id));
        model.addAttribute("taryfy", grupaTaryfowaRepository.findAll());
        model.addAttribute("rejony", rejonRepository.findAll());
        return "views/klientModify";
    }
    @PostMapping("klient_modify")
    public String modifyKlient(Model model, @Valid @ModelAttribute("klient") Klient klient) {
        klientRepository.save(klient);
        return "redirect:/klienci_print";
                
    }
    
    @GetMapping("klient_faktury")
    public String fakturyKlient(Model model, @RequestParam int id) {
    model.addAttribute("faktury", fakturaRepository.findAllByIdKlienta(id));
     model.addAttribute("klient", klientRepository.getOne(id));
    
    return "views/klientFaktury";
}


}
