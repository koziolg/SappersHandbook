package pl.handbook.services.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/wood")
public class WoodController {


    @GetMapping("")
    public String calculator() {
        return "wood_calculator";

    }

    @PostMapping("")
    @ResponseBody
    public String postCalculator(@RequestParam(name="type") Integer type, @RequestParam(name = "wet") Double wet, @RequestParam(name= "dry") Double dry,
                                 @RequestParam(name="diametr") Integer diametr, @RequestParam(name="width") Integer width, @RequestParam(name="length") Integer length, Model m) {

       System.out.print(wet);
       System.out.println(dry);
        Double result = 0.0;
        if (type == 1) {
            if (diametr < 30) {
                if (wet > 0) {
                    result = wet * Math.pow(diametr, 2);
                } else if (dry > 0) {
                    result = dry * Math.pow(diametr, 2);
                }
            } else if (diametr >= 30) {
                if (wet > 0) {
                    result = (wet * Math.pow(diametr, 3)) / 30;
                } else if (dry > 0) {
                    result = (dry * Math.pow(diametr, 3)) / 30;
                }
            }
        } else if (type == 2) {
            if (wet > 0) {
                result = (wet * Math.pow(diametr, 2)) - ((wet * Math.pow(diametr, 2)) / 3);

            } else if (dry > 0) {
                result = (dry * Math.pow(diametr, 2)) - ((dry * Math.pow(diametr, 2)) / 3);
            }
        } else if (type == 3 || type == 4) {
            if (wet > 0) {
                result = (wet * Math.pow(diametr, 2)) / 10;
            } else if (dry > 0) {
                result = (dry * Math.pow(diametr, 2)) / 10;
            }
        } else if (type == 5) {
            if (wet > 0) {
                result = wet *(width*length);
            } else if (dry > 0){
                result = wet *(width*length);
            }
        }
        String wynik = "Potrzebna ilość materiału to " + result;
        m.addAttribute("wynik", wynik);
        return "wynik " +result;


    }
}
