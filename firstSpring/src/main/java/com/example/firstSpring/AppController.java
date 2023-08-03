package com.example.firstSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    private SubscriberDAO dao;
 
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Subscriber> listSubscriber = dao.list();
        model.addAttribute("listSubscriber", listSubscriber);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Subscriber subscriber = new Subscriber();
        model.addAttribute("subscriber", subscriber);

        return "new_form";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String subscriber(@ModelAttribute("subscriber") Subscriber subscriber) {
        dao.save(subscriber);
        return "redirect:/";
    }

}