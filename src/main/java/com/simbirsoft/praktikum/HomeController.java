package com.simbirsoft.praktikum;

import com.simbirsoft.praktikum.services.ParseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @PostMapping
    public String getData(@RequestParam String url, Model model) {
        ParseService ps = new ParseService(url);
        Document document = ps.getDoc();
        System.out.println(ps.getWords());
        model.addAttribute("words", ps.getWords());
        model.addAttribute("result", document.body());

        return "index";
    }
}
