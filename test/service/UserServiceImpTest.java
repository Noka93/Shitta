package service;

import shitta.data.model.User;
import shitta.dto.requests.RegisterUserRequest;
import shitta.dto.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shitta.service.UserService;
import shitta.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImpTest {

    private UserService userService;

    @BeforeEach

    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test

    public void registerUserTest(){
//        given
        RegisterUserRequest request = new RegisterUserRequest();
        request.setPhoneNumber("phonenumber");
        request.setLastName("lastname");
        request.setFirstName("firstname");
        request.setAddress("address");
        request.setEmail("email");

//        when
        RegisterUserResponse user = userService.registerNewUser(request);
        assertEquals(1, user.getId());
        User foundUser = userService.findUser(1);
        assertEquals(user, foundUser);
    }

}