package project.springsecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import project.springsecurity.Entity.User;
import project.springsecurity.Service.UserService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    @PreAuthorize("hasRole('USER')")
    public String test(){
        return "<h1> TEST </h1>";
    }

    @GetMapping("/livre")
    public String testRotaLivre(){
        return "<h1> ROTA LIVRE </h1>";
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User> >listAll(){
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println(user.getUsername());
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

