package crudoperation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }
    @GetMapping("/login")
    public String login(){
        return "this is home page";
    }
    @GetMapping("/register")
    public String register(){
        return "this is home page";
    }
}
