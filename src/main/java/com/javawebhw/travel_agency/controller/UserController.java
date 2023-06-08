package com.javawebhw.travel_agency.controller;

import com.javawebhw.travel_agency.model.User;
import com.javawebhw.travel_agency.enums.UserRole;
import com.javawebhw.travel_agency.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/welcome")
    public String atLoginSuccess(@AuthenticationPrincipal User user) {
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER")))
            return "welcome";
        else if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")))
            return "admin";
        else if (user.getAuthorities().contains(new SimpleGrantedAuthority("INTERNAL")))
            return "welcome";
        else return "index";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(@Validated User user) {
        BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
        user.setPassword(bEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/add/user")
    public String loadNewEmployeeUserPage() {
        return "adduser";
    }

    @PostMapping("/add/user")
    public String addEmployeeUser(@Validated User user) {
        BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
        user.setPassword(bEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "adduser";
    }

    @GetMapping("/user/list")
    public String getAllUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "userinfo";
    }

    @PostMapping("/user/update")
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
