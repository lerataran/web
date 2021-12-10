package com.example.web.controler;

import com.example.web.models.Client;
import com.example.web.models.Predlozenie;
import com.example.web.repo.ClientRepo;
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
public class ClientControler {
    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("/client")
    public String client( Model model) {
        Iterable<Client> clients = clientRepo.findAll();
        model.addAttribute("clients", clients);
        return "client.html";
    }
    @GetMapping("/client/add")
    public String clientAdd( Model model) {
        Client client1 = new Client("Таран", "тв", 54,87);
        clientRepo.save(client1);
        return "client-add.html";
    }

    @PostMapping("/client/add")
    public String clientPostAdd(@RequestParam String fio_client, @RequestParam String mail, @RequestParam int nomer, @RequestParam int pasport, Model model){
       Client client = new Client(fio_client, mail, nomer, pasport);
       clientRepo.save(client);
       return "redirect:/";
    }

    @GetMapping("/client/{id}")
    public String clientDetal(@PathVariable(value = "id") long id, Model model) {
        if (!clientRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Client> client = clientRepo.findById(id);
        ArrayList<Client> res = new ArrayList<>();
        client.ifPresent(res::add);
        model.addAttribute("client",res);
        return "client-detais.html";
    }

    @GetMapping("/client/{id}/edit")
    public String clientEdit(@PathVariable(value = "id") long id, Model model) {
        if (!clientRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Client> client = clientRepo.findById(id);
        ArrayList<Client> res = new ArrayList<>();
        client.ifPresent(res::add);
        model.addAttribute("client",res);
        return "client-edit.html";
    }

    @PostMapping("/client/{id}/edit")
    public String clientUpA(@PathVariable(value = "id") long id, @RequestParam String fio_client, @RequestParam String mail, @RequestParam int nomer, @RequestParam int pasport,  Model model){
        Client client = clientRepo.findById(id).orElse(new Client());
        client.setFio_client(fio_client);
        client.setMail(mail);
        client.setNomer(nomer);
        client.setPasport(pasport);
        clientRepo.save(client);
        return "redirect:/";
    }

    @PostMapping("/client/{id}/remove")
    public String clientRemov(@PathVariable(value = "id") long id,   Model model){
        Client client = clientRepo.findById(id).orElse(new Client());
        clientRepo.delete(client);
        return "redirect:/";
    }
}
