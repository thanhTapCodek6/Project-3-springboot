package vn.nhutthanh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.nhutthanh.entity.User;
import vn.nhutthanh.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user")
    public String user(@RequestParam(required = false) String keyword,
                       Model model) {

        if (keyword == null || keyword.isBlank()) {
            model.addAttribute("users", userService.findAll());
        } else {
            model.addAttribute("users", userService.search(keyword));
        }

        model.addAttribute("keyword", keyword);

        return "admin/user";
    }

    @PostMapping("/admin/user/add")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userService.save(user);

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/edit")
    public String editUser(@RequestParam int id, Model model) {

        User user = userService.findById(id);

        model.addAttribute("user", user);

        return "admin/user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String updateUser(@RequestParam int id,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email) {

        User user = userService.findById(id);

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userService.save(user);

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete")
    public String deleteUser(@RequestParam int id) {

        userService.deleteById(id);

        return "redirect:/admin/user";
    }
}