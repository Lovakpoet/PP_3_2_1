package org.example.pp312last.controller;

import org.example.pp312last.model.User;
import org.example.pp312last.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.logging.Logger;
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private static final Logger log = Logger.getLogger(UsersController.class.getName());

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        log.info("get users");
        return "users";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        log.info("new user");
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        log.info("save user");
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(ModelMap model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.show(id));
        log.info("edit user");
        return "edit";
    }

    @GetMapping("/show")
    public String showUser(ModelMap model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.show(id));
        log.info("show user");
        return "show";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        log.info("update user");
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delete(id);
        log.info("delete user");
        return "redirect:/users";
    }
}

