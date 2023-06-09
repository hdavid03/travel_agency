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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "welcome";
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
        return "redirect:/?success";
    }

    @GetMapping("/add/user")
    public String loadNewEmployeeUserPage() {
        return "adduser";
    }

    @PostMapping("/add/user")
    public String addUserByAdmin(@Validated User user) {
        BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
        user.setPassword(bEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/add/user?success";
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

    @GetMapping("/user/account")
    public String loadUserInfoPage(@AuthenticationPrincipal User user) {
        return "userinfo";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@Validated User user, @PathVariable Long id) {
        BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
        User oldUser = userService.findUserById(id);
        oldUser.setAddress(user.getAddress());
        oldUser.setEmail(user.getEmail());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setBirthDate(user.getBirthDate());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setReservationList(user.getReservationList());
        oldUser.setPassword(bEncoder.encode(user.getPassword()));
        userService.updateUser(oldUser);
        return "redirect:/user/%s?success".formatted(id.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
