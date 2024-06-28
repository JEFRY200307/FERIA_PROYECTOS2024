package edu.uni.pe.medicprojectback.controller;

import edu.uni.pe.medicprojectback.model.Usuario;
import edu.uni.pe.medicprojectback.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Usuario createUser(@RequestBody Usuario user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public Usuario updateUser(@PathVariable Long id, @RequestBody Usuario user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
