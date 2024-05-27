package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/crud")
public class MainController {
   @GetMapping("/index")
   public String getIndexPage(){
       return "index";
   }
   
   
   
}
