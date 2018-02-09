package pl.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.handbook.entity.TypeOfMine;
import pl.handbook.repository.TypeOfMineRepository;

import javax.validation.Valid;
import java.util.List;

@Component
@RequestMapping("/typeofmine")
public class TypeOfMineController {

    private String headS = "Dodawnie rodzaju miny";
    private String urlS = "/typeofmine/save";
    private String headE = "Edycja rodzaju miny";
    private String urlE = "/typeofmine/update/save";

    @Autowired
    TypeOfMineRepository typeOfMineRepository;

    @GetMapping("/all")
    public String allTypes(Model m) {
        List<TypeOfMine> types = typeOfMineRepository.findAll();
        m.addAttribute("types", types );
        return "all_types_of_mine";
    }

    @GetMapping("/add")
    public String addTypes(Model m) {
        m.addAttribute("typeOfMine", new TypeOfMine());
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        return "typeOfMine_add_view";
    }

    @PostMapping("/save")
    public String saveType(@Valid TypeOfMine typeOfMine, BindingResult result, Model m) {
        m.addAttribute("head", headS);
        m.addAttribute("url", urlS);
        if (result.hasErrors()) {
            return "typeOfMine_add_view";
        }
        typeOfMineRepository.save(typeOfMine);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateType(Model m, @PathVariable Long id) {
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        m.addAttribute(typeOfMineRepository.findOne(id));
        return "fuze_add_view";
    }

    @PostMapping("update/save")
    public String saveUpdateFuze(@Valid TypeOfMine typeOfMine, BindingResult result, Model m) {
        m.addAttribute("head", headE);
        m.addAttribute("url", urlE);
        if (result.hasErrors()) {
            return "typeOfMine_add_view";
        }
        typeOfMineRepository.save(typeOfMine);
        return "redirect:/typeofmine/all";
    }

    @GetMapping("delete/{id}")
    public String deleteFuze(@PathVariable long id) {
        typeOfMineRepository.delete(typeOfMineRepository.findOne(id));
        return "redirect:/fuze/all";
    }

}
