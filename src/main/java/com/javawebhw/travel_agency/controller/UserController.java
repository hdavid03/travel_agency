package com.javawebhw.travel_agency.controller;

import com.javawebhw.travel_agency.model.User;
import com.javawebhw.travel_agency.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/find/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/new")
    public String addUser(@Validated User user) {
        User newUser = userService.addUser(user);
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmail(email);
        if (user.getPassword().equals(password)) {
            System.out.println("Felhasználó meg van");
        } else {
            System.out.println("Nincs ilyen felhasználó ezzel a jelszóval");
        }
        return "redirect:/";
    }

    @PostMapping("/add/update")
    public String updateUser(@Validated User user) {
        User updatedUser = userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
