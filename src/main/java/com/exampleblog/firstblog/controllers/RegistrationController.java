package com.exampleblog.firstblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exampleblog.firstblog.services.MailSender;

@Controller
public class RegistrationController {

  @Autowired
  private MailSender mailSender;
    
  @GetMapping("/registration")
  public String blogMain(Model model) {
    return "registration";
  }

  @PostMapping("/my")
  public String blogPostAdd(@RequestParam String inputEmail, @RequestParam String inputPassword, Model model) {
    model.addAttribute("email", inputEmail);
    model.addAttribute("password", inputPassword);
    mailSender.send(inputEmail, "Test message", "Hello!\n" + "Your text: " + inputPassword);
    return "my-page";
  }

}
