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
import web.repositories.GrupaTaryfowaRepository;
import web.repositories.RejonRepository;
import web.entities.Klient;
import web.transdata.KlientTransData;
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

    @GetMapping("/klient_insert")
    public String insertKlient(Model model) {
        model.addAttribute("klientT", new KlientTransData());
        model.addAttribute("taryfy", grupaTaryfowaRepository.findAll());
        model.addAttribute("rejony", rejonRepository.findAll());
        return "views/klientInsert";
    }

    @PostMapping("/klient_insert")
    public String insertKlient(Model model, @Valid @ModelAttribute("klientT") KlientTransData klientT) {
        Klient klient = klientT.extractKlient();
        try {
            try {

                GrupaTaryfowa tempGrupa = grupaTaryfowaRepository.findById(Integer.parseInt(klientT.getIdGrupyTaryfowej())).get();

                klient.setGrupaTaryfowa(tempGrupa);
            } catch (Exception e) {
                                System.out.println("Id="+klientT.getIdGrupyTaryfowej());
                System.out.println("Find Grupa");
            }
            try {
                Rejon tempRejon = rejonRepository.findById(Integer.parseInt(klientT.getIdRejonu())).get();
                klient.setRejon(tempRejon);
            } catch (Exception e) {
                System.out.println("Find rejon");
            }

            klientRepository.save(klient);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "index";
    }

}