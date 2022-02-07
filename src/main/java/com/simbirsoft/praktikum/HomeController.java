package com.simbirsoft.praktikum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            System.out.println(doc.body());
            model.addAttribute("docbody", doc.body());
        }

        return "index";
    }
}
