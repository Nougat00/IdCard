package com.example.IdCard.controllers;

import com.example.IdCard.model.OneCard;
import com.example.IdCard.services.IdCardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class IdCardController {

    @Autowired
    private IdCardService idCardService;

    @GetMapping("/")
    public String getCardList(Model model){
        model.addAttribute("listOneCard", idCardService.getCards());
        return "index";
    }

    @GetMapping("/add")
    public String showIdCardForm(Model model){
        OneCard oneCard = new OneCard();
        model.addAttribute("oneCard", oneCard);
        return "addNewCard";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("card") OneCard oneCard){
        idCardService.saveCard(oneCard);
        return "redirect:/";
    }

}
