package shitta.service;

import shitta.data.model.User;
import shitta.dto.requests.RegisterUserRequest;
import shitta.dto.responses.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse registerNewUser(RegisterUserRequest request);

    User findUser(int id);
}
