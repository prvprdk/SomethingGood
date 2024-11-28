package com.example.somethinggood.controller;

import com.example.somethinggood.domain.User;
import com.example.somethinggood.service.UserService;
import com.example.somethinggood.utils.ErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainRegistration {

@Autowired
    private UserService userService;

    @GetMapping ("/registration")
    public String registration (){
        return "registration";
    }

    @GetMapping ("/login")
    public String login(){
        return "login";
    }
@PostMapping("/registration")
    public String addUser (
        @RequestParam ("password2") String passwordConfirm,
        @Valid User user,
        BindingResult bindingResult,
        Model model){

        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);

        if (isConfirmEmpty) {
            model.addAttribute("passwordConfirm", "Password confirmation cannot is empty");
        }
        if (user.getPassword()!=null && !user.getPassword().equals(passwordConfirm)){
            model.addAttribute("passwordError", "Passwords are different!");
            return "registration";
        }

        if (isConfirmEmpty|| bindingResult.hasErrors()){
            Map<String,String> errors = ErrorUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (!userService.addUser(user)){
            model.addAttribute("message", "User exists");
            return "registration";
        }
        return "redirect:/login";
}

}
