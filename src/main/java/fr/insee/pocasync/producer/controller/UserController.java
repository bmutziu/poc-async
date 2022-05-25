package fr.insee.pocasync.producer.controller;

import java.util.stream.Collectors;
import javax.transaction.Transactional;

import fr.insee.pocasync.producer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/create")
    public String createUser(@RequestParam( required=false ) String username){
        return userService.createUser(username);
    }

    @GetMapping(path = "/all")
    public String getUsers(){
        return userService.queryUser().map(userEntity -> userEntity.getUsername()).collect(Collectors.joining(" : "));
    }
}
