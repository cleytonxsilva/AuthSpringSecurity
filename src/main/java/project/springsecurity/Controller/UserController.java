package project.springsecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.springsecurity.Service.UserService;

@RequestMapping("/")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    @PreAuthorize("hasRole('USER')")
    public String test(){
        return "<h1> TEST </h1>";
    }

    @GetMapping("/livre")
    public String testRotaLivre(){
        return "<h1> ROTA LIVRE </h1>";
    }

}

