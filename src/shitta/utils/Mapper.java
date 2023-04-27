package shitta.utils;

import shitta.data.model.User;
import shitta.dto.requests.RegisterUserRequest;
import shitta.dto.responses.RegisterUserResponse;

public class Mapper {
    public static User map(RegisterUserRequest request){
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAddress(request.getAddress());
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setEmail(request.getEmail());
        return  newUser;
    }
    public  static RegisterUserResponse map(User savedUser){
        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(savedUser.getId());
        response.setFirstName(savedUser.getFirstName());
        return response;
    }

}
