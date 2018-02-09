package pl.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.handbook.entity.Fuze;
import pl.handbook.repository.FuzeRepository;

import javax.validation.Valid;
import java.util.List;

@Component
@RequestMapping("/fuze")
public class FuzeController {


    private String headS = "Dodawnie zapalnika";
    private String urlS = "/fuze/save";
    private String headE = "Edycja zapalnika";
    private String urlE = "/fuze/update/save";

    @Autowired
    FuzeRepository fuzeRepository;

    @GetMapping("/all")
    public String allFuzes(Model m) {
        List<Fuze> fuzes = fuzeRepository.findAll();
        m.addAttribute("fuzes", fuzes);
        return "all_fuzes";
    }

    @GetMapping("/add")
    public String addFuze(Model m) {
        m.addAttribute("fuze", new Fuze());
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        return "fuze_add_view";
    }

    @PostMapping("/save")
    public String saveFuze(@Valid Fuze fuze, BindingResult result, Model m) {
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        if (result.hasErrors()) {
            return "fuze_add_view";
        }
        fuzeRepository.save(fuze);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateFuze(Model m, @PathVariable Long id) {
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        Fuze fuze = fuzeRepository.findOne(id);
        m.addAttribute(fuze);
        return "fuze_add_view";
    }

    @PostMapping("update/save")
    public String saveUpdateFuze(@Valid Fuze fuze, BindingResult result, Model m) {
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        if (result.hasErrors()) {
            return "fuze_add_view";
        }
        fuzeRepository.save(fuze);
        return "redirect:/fuze/all";
    }

    @GetMapping("delete/{id}")
    public String deleteFuze(@PathVariable long id) {
        fuzeRepository.delete(fuzeRepository.findOne(id));
        return "redirect:/fuze/all";
    }
}
