package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.repositories.RejonRepository;
import web.entities.Rejon;

@Controller
public class RejonController {

    @Autowired
    RejonRepository rejonRepository;

    @GetMapping("/rejon_insert")
    public String insertRejon(Model model) {
        model.addAttribute(new Rejon()); 
        return "views/rejonInsert";
    }
    @PostMapping("/rejon_insert")
    public String insertRejon(Model model, @Valid @ModelAttribute("rejon") Rejon rejon) {
        rejonRepository.save(rejon);
        return "redirect:/";
    }

}
