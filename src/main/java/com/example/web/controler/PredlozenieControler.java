package com.example.web.controler;

import com.example.web.models.Client;
import com.example.web.models.Credit;
import com.example.web.models.Predlozenie;
import com.example.web.repo.PredlozenieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class PredlozenieControler {
    @Autowired
    private PredlozenieRepo predlozenieRepo;

    @GetMapping("/credit_pas")
    public String credit( Model model) {
        Iterable<Predlozenie> predlozenies = predlozenieRepo.findAll();
        model.addAttribute("predlozenies",predlozenies);
        return "credit_pas.html";
    }

    @GetMapping("/credit_pas/add")
    public String creditAdd( Model model) {
        return "credit_pas-add.html";
    }

    @PostMapping("/credit_pas/add")
    public String creditPostAdd(@RequestParam String fio, @RequestParam String name, @RequestParam int sumCred,  @RequestParam int procent, @RequestParam String date, @RequestParam int sumPla, @RequestParam int sumTelo, @RequestParam int sumPros, Model model){
        Predlozenie predlozenie = new Predlozenie(fio, name, sumCred,procent, date ,sumTelo, sumPla,sumPros);
        int x;
        x = sumCred*procent/100;
        sumCred+=x;
        predlozenie.setSumPla(sumPla = sumCred/12);
        predlozenie.setSumPros(sumPros = sumPla*procent/100);
        predlozenie.setSumTelo(sumTelo = sumPla - sumPros);
        predlozenieRepo.save(predlozenie);
        return "redirect:/";
    }

    @GetMapping("/bank")
    public String bank( Model model) {
        Iterable<Predlozenie> predloz = predlozenieRepo.findAll();
        model.addAttribute("predloz",predloz);
        return "bank.html";
    }

    @GetMapping("/credit_pas/{id}")
    public String creditDetal(@PathVariable(value = "id") long id, Model model) {
        if (!predlozenieRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Predlozenie> predlozenie = predlozenieRepo.findById(id);
        ArrayList<Predlozenie> res = new ArrayList<>();
        predlozenie.ifPresent(res::add);
        model.addAttribute("predlozenie",res);
        return "credit_pas-detais.html";
    }

    @GetMapping("/credit_pas/{id}/edit")
    public String creditEdit(@PathVariable(value = "id") long id, Model model) {
        if (!predlozenieRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Predlozenie> predl = predlozenieRepo.findById(id);
        ArrayList<Predlozenie> res = new ArrayList<>();
        predl.ifPresent(res::add);
        model.addAttribute("predl",res);
        return "credit_pas-edit.html";
    }

    @PostMapping("/credit_pas/{id}/edit")
    public String creditPostUpA(@PathVariable(value = "id") long id, @RequestParam String fio, @RequestParam String name, @RequestParam int sumCred, @RequestParam String date, @RequestParam int sumPla, @RequestParam int sumTelo, @RequestParam int sumPros,  Model model){
        Predlozenie predlozenie = predlozenieRepo.findById(id).orElse(new Predlozenie());
        predlozenie.setFio(fio);
        predlozenie.setName(name);
        predlozenie.setSumCred(sumCred);
        predlozenie.setDate(date);
        predlozenie.setSumPla(sumPla);
        predlozenie.setSumTelo(sumTelo);
        predlozenie.setSumPros(sumPros);
        predlozenieRepo.save(predlozenie);
        return "redirect:/";
    }

    @PostMapping("/credit_pas/{id}/remove")
    public String creditPostRemov(@PathVariable(value = "id") long id,  Model model){
        Predlozenie predlozenie = predlozenieRepo.findById(id).orElse(new Predlozenie());
        predlozenieRepo.delete(predlozenie);
        return "redirect:/";
    }

}

