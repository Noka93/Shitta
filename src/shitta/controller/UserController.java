package shitta.controller;

import shitta.data.model.User;
import shitta.dto.requests.RegisterUserRequest;
import shitta.dto.responses.RegisterUserResponse;
import org.springframework.web.bind.annotation.*;
import shitta.service.UserService;
import shitta.service.UserServiceImpl;

@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();


    @PostMapping("/user")
    public RegisterUserResponse registerNewUser(@RequestBody RegisterUserRequest user){
        return userService.registerNewUser(user);
    }

    @GetMapping("/user/{id}")

    public User findUserById(@PathVariable int id){
        return userService.findUser(id);
    }
}
