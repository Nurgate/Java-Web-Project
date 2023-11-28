package softuni.bg.mywebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }

    @GetMapping("/projects")
    public String projects() {
        return "projects";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

//    @PostMapping("/logout")
//    public ModelAndView logout() {
//        return new ModelAndView("redirect:/");
//    }
}
