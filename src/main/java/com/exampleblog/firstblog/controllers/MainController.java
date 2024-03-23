package com.exampleblog.firstblog.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exampleblog.firstblog.Questionnaire.QuestionnaireData;
import com.exampleblog.firstblog.Questionnaire.QuestionnaireResult;

@Controller
public class MainController {
    final String HW = "Hello, World!";

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
		return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Страница про нас");
		return "about";
    }

    @GetMapping("/questionnaire")
    public String questionnaire(Model model) {
        model.addAttribute("questions", QuestionnaireData.Questions);
        model.addAttribute("answerOptions", QuestionnaireData.AnswerOptions);
		return "questionnaire/questionnaire";
    }

    @PostMapping("/questionnaire")
        public String blogPostAdd(@RequestParam String answer1, @RequestParam String answer2, @RequestParam String answer3, Model model) {
        QuestionnaireResult questionnaireResult = new QuestionnaireResult(answer1, answer2, answer3);
        model.addAttribute("questionnaireResult", questionnaireResult);
        model.addAttribute("date", new Date());
        return "questionnaire/questionnaireresult";
    }

}
