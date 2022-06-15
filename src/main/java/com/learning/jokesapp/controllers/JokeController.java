package com.learning.jokesapp.controllers;

import com.learning.jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
//    public String showJoke(HttpSession session) {
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
//        System.out.println(jokeService.getJoke());
//        session.setAttribute("joke", jokeService.getJoke());
        return "index";
    }
}
