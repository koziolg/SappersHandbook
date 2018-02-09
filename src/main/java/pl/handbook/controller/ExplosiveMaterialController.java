package pl.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.handbook.entity.ExplosiveMaterial;
import pl.handbook.repository.ExplosiveMaterialRepository;

import javax.validation.Valid;
import java.util.List;

@Component
@RequestMapping("/em")
public class ExplosiveMaterialController {

    private String headS = "Dodawnie materiału wybuchowego";
    private String urlS = "/em/save";
    private String headE = "Edycja materiału wybuchowego";
    private String urlE = "/em/update/save";

    @Autowired
    ExplosiveMaterialRepository explosiveMaterialRepository;

    @GetMapping("/all")
    public String allEmss(Model m) {
        List<ExplosiveMaterial> ems = explosiveMaterialRepository.findAll();
        m.addAttribute("ems", ems);
        return "all_ems";
    }
    @GetMapping("/add")
    public String addEm(Model m){
        m.addAttribute("em", new ExplosiveMaterial());
        m.addAttribute("head",headS);
        m.addAttribute("url", urlS);
        return "em_add_view";
    }
    @PostMapping("/save")
    public String saveEm(@Valid ExplosiveMaterial em, BindingResult result, Model m){

        m.addAttribute("head",headS);
        m.addAttribute("url", urlS);
        if(result.hasErrors()){
            return "redirect:/em/all";
        }
        explosiveMaterialRepository.save(em);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateEm(Model m, @PathVariable Long id){
        m.addAttribute("head",headE);
        m.addAttribute("url", urlE);
        ExplosiveMaterial em = explosiveMaterialRepository.findOne(id);
        m.addAttribute(em);
        return "em_add_view";
    }

    @PostMapping("update/save")
    public String saveUpdateEm(@Valid ExplosiveMaterial explosiveMaterial, BindingResult result, Model m){
        m.addAttribute("head",headE);
        m.addAttribute("url", urlE);
        if(result.hasErrors()){
            return "em_add_view";
        }
        explosiveMaterialRepository.save(explosiveMaterial);
        return "redirect:/em/all";
    }

    @GetMapping("delete/{id}")
    public String deleteEm(@PathVariable long id){
      explosiveMaterialRepository.delete(explosiveMaterialRepository.findOne(id));
        return "redirect:/em/all";
    }
}
