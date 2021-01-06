package hm.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //Returns view
public class HomeController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/api")
    public String read(){
        return "testAJAX";
    } //TODO: Show read() to display Json in HTML

}
