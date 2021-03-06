package de.htwberlin.webtech.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController {

    @GetMapping("/home")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="stitching fan") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/add-entry")
    public String addEntry(@RequestParam(name="name", required=false, defaultValue="stitching fan") String name, Model model) {
        model.addAttribute("name", name);
        return "addentry";
    }

    @GetMapping("/add-success")
    public String addSuccess(@RequestParam(name="name", required=false, defaultValue="stitching fan") String name, Model model) {
        model.addAttribute("name", name);
        return "addsuccess";
    }

    @GetMapping("/error")
    public String error(@RequestParam(name="name", required=false, defaultValue="stitching fan") String name, Model model) {
        model.addAttribute("name", name);
        return "error";
    }

}