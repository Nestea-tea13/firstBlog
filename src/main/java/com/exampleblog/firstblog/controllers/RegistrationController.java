package com.exampleblog.firstblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    
  @GetMapping("/registration")
  public String blogMain(Model model) {
    return "registration";
  }

  @PostMapping("/my")
  public String blogPostAdd(@RequestParam String inputEmail, @RequestParam String inputPassword, Model model) {
    model.addAttribute("email", inputEmail);
    model.addAttribute("password", inputPassword);
    return "my-page";
  }

}
