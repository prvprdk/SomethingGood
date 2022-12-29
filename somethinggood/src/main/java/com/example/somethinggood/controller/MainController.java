package com.example.somethinggood.controller;

import com.example.somethinggood.domain.GoodMessage;
import com.example.somethinggood.domain.User;
import com.example.somethinggood.repository.GoodMessageRepository;
import com.example.somethinggood.service.MessageService;
import com.example.somethinggood.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private GoodMessageRepository goodMessageRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        model.put("static", "lll.png");
        return "greeting";
    }
    @GetMapping("/setgood")
    public String setGood(Map<String, Object> model) {
        return "setgood";
    }
    @PostMapping("/setgood")
    public String add(
                      @AuthenticationPrincipal User user,
                      @Valid GoodMessage message,
                      BindingResult bindingResult,
                      Model model) throws IOException {

        message.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);

        } else {
            model.addAttribute("message", null);
            goodMessageRepository.save(message);
        }
        return "setgood";
    }
    @GetMapping("/main/{user}")
    public String getList(
            @AuthenticationPrincipal User curentUser,
            @PathVariable User user,
            Model model) {
      Set<GoodMessage> messageSet= user.getMessages();
      model.addAttribute("messages", messageSet);
        return "main";
    }
    @GetMapping("/getgood")
    public String getGood(
            @AuthenticationPrincipal User user,
            Model model) {
        try {
            if (goodMessageRepository.count() > 1) {
                List<GoodMessage> str = messageService.sortGoodMessageUser(user);
                GoodMessage a = messageService.randomMessage(str);
                model.addAttribute("goodMessage", a.getText());
                model.addAttribute("username", a.getAuthorName());
                model.addAttribute("userId", a.getAuthor().getId());
            }else {
                model.addAttribute("goodMessage", "not message;(");
            }

        } catch (Exception ep){
            model.addAttribute("goodMessage","no good for you;( ");
        }
        return "getgood";
    }
}

