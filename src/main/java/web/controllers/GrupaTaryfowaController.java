package web.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.repositories.GrupaTaryfowaRepository;
import web.entities.GrupaTaryfowa;

@Controller
public class GrupaTaryfowaController {

    @Autowired
    GrupaTaryfowaRepository grupaTaryfowaRepository;

    @GetMapping("/grupaTaryfowa_insert")
    public String insertGrupaTaryfowa(Model model) {
        model.addAttribute(new GrupaTaryfowa());
        return "views/grupaTaryfowaInsert";
    }

    @PostMapping("/grupaTaryfowa_insert")
    public String insertGrupaTaryfowa(Model model, @Valid @ModelAttribute("grupaTaryfowa") GrupaTaryfowa grupaTaryfowa) {
        grupaTaryfowaRepository.save(grupaTaryfowa);
        return "redirect:/";
    }

    @GetMapping("grupyTaryfowe_print")
    public String printGrupyTaryfowe(Model model) {
        model.addAttribute("taryfy", grupaTaryfowaRepository.findAll());
        return "views/grupaTaryfowaPrint";
    }

    @GetMapping("grupaTaryfowa_modify")
    public String modifyGrupaTaryfowa(Model model, int id) {
        model.addAttribute("grupaTaryfowa", grupaTaryfowaRepository.getOne(id));
        return "views/grupaTaryfowaModify";
    }

    @PostMapping("grupaTaryfowa_modify")
    public String modifyGrupaTaryfowa(Model model, @Valid @ModelAttribute("grupaTaryfowa") GrupaTaryfowa grupaTaryfowa) {
        grupaTaryfowaRepository.save(grupaTaryfowa);

        return "redirect:/";

    }

}
