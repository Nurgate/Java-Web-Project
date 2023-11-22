package softuni.bg.mywebproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.bg.mywebproject.model.User;
import softuni.bg.mywebproject.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return this.userService.getUsers();
    }
}
