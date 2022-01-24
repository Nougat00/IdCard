package com.example.IdCard.controllers;

import com.example.IdCard.Exporters.CSV;
import com.example.IdCard.messeges.MessageSender;
import com.example.IdCard.model.EmailValues;
import com.example.IdCard.model.OneCard;
import com.example.IdCard.services.IdCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IdCardController {

    @Autowired
    private IdCardServiceImpl idCardServiceImpl;

    MessageSender messageSender = new MessageSender();

    @GetMapping("/")
    public String getCardList(Model model) {
        model.addAttribute("listOneCard", idCardServiceImpl.getCards());
        return "index";
    }

    @GetMapping("/add")
    public String showIdCardForm(Model model) {
        OneCard oneCard = new OneCard();
        model.addAttribute("oneCard", oneCard);
        return "addNewCard";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("saveCard") OneCard oneCard) {
        idCardServiceImpl.saveCard(oneCard);
        return "redirect:/";
    }


    @GetMapping("/deleteCard")
    public String deleteCard(@RequestParam long id) {
        idCardServiceImpl.deleteCard(id);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
        OneCard oneCard = idCardServiceImpl.getOneCardById(id);
        model.addAttribute("idCard", oneCard);
        return "update";
    }

    @GetMapping("/showFormSending/{id}")
    public String showEmailForm(@PathVariable(value = "id") long id, Model model) {
        OneCard oneCard = idCardServiceImpl.getOneCardById(id);
        model.addAttribute("idCard", oneCard);
        EmailValues emailValues = new EmailValues();
        model.addAttribute("email", emailValues);
        return "emailSender";
    }

    @PostMapping("/emailSend")
    public String emailSend(@ModelAttribute("emailValues") EmailValues emailValues) {
        messageSender.send(emailValues);
        return "redirect:/";
    }

    @GetMapping("/csv")
    public String csvGenerator(HttpServletResponse response) throws IOException {
        CSV csv = new CSV();
        csv.getFile(response, idCardServiceImpl.getCards());
        return "redirect:/";
    }

}
