package softuni.bg.mywebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.mywebproject.model.dto.binding.UserLoginBindingModel;
import softuni.bg.mywebproject.model.dto.binding.UserRegisterBindingModel;
import softuni.bg.mywebproject.service.AuthenticationService;
import softuni.bg.mywebproject.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult";
    public static final String DOT = ".";

    public UsersController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBindingModel userLoginBindingModel) {
        this.authenticationService.login(userLoginBindingModel);
        return new ModelAndView("redirect:/");
    }

//    @GetMapping("/register")
//    public ModelAndView register(Model model) {
//
//        if (!model.containsAttribute("userRegisterBindingModel")) {
//            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
//        }
//            return new ModelAndView("register");
//        }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }



    @PostMapping("/register")
        public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel) {
            this.authenticationService.register(userRegisterBindingModel);
            System.out.println();
            return new ModelAndView("redirect:/login");
        }


//    @PostMapping("/register")
//    public ModelAndView register(@Valid UserRegisterBindingModel userRegisterBindingModel,
//                                 BindingResult bindingResult,
//                                 RedirectAttributes redirectAttributes) {
//
//        final ModelAndView modelAndView = new ModelAndView();
//
//        if (bindingResult.hasErrors()) {
//            final String attributeName = "userRegisterBindingModel";
//            redirectAttributes
//                    .addFlashAttribute(attributeName, userRegisterBindingModel)
//                    .addFlashAttribute(BINDING_RESULT_PATH + DOT + attributeName, bindingResult);
//            modelAndView.setViewName("redirect:register");
//
//        } else {
//
//            this.authenticationService.register(userRegisterBindingModel);
//            modelAndView.setViewName("redirect:login");
//
//        }
//
//        return modelAndView;
//    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        this.authenticationService.logout();

        return new ModelAndView("redirect:/");
    }

}
