package com.example.web.controler;


import com.example.web.models.Client;
import com.example.web.models.Credit;
import com.example.web.repo.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CreditControler {
    @Autowired
private CreditRepo creditRepo;

    @GetMapping("/credit")
    public String credit( Model model) {
    Iterable<Credit> credits = creditRepo.findAll();
    model.addAttribute("credits", credits);
    return "credit.html";
    }

    @GetMapping("/credit/add")
    public String creditAdd( Model model) {
        return "credit-add.html";
    }

    @PostMapping("/credit/add")
    public String creditPostAdd(@RequestParam String name_credit,  @RequestParam int lim, @RequestParam int procent, Model model){
        Credit credit = new Credit(name_credit, lim, procent);
        creditRepo.save(credit);
        return "redirect:/";
    }

    @GetMapping("/credit/{id}")
    public String creditDetal(@PathVariable(value = "id") long id, Model model) {
        if (!creditRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Credit> credit = creditRepo.findById(id);
        ArrayList<Credit> res = new ArrayList<>();
        credit.ifPresent(res::add);
        model.addAttribute("credit",res);
        return "credit-detais.html";
    }

    @GetMapping("/credit/{id}/edit")
    public String creditExit(@PathVariable(value = "id") long id, Model model) {
        if (!creditRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Credit> credit = creditRepo.findById(id);
        ArrayList<Credit> res = new ArrayList<>();
        credit.ifPresent(res::add);
        model.addAttribute("credit",res);
        return "credit-edit.html";
    }

    @PostMapping("/credit/{id}/edit")
    public String creditUpA(@PathVariable(value = "id") long id, @RequestParam String name_credit,  @RequestParam int lim, @RequestParam int procent,  Model model){
        Credit credit = creditRepo.findById(id).orElse(new Credit());
        credit.setName_credit(name_credit);
        credit.setLim(lim);
        credit.setProcent(procent);
        creditRepo.save(credit);
        return "redirect:/";
    }

    @PostMapping("/credit/{id}/remove")
    public String creditRemov(@PathVariable(value = "id") long id, Model model){
        Credit credit = creditRepo.findById(id).orElse(new Credit());
    creditRepo.delete(credit);
        return "redirect:/";
    }
}
