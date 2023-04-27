package shitta.service;

import shitta.data.model.User;
import shitta.data.repositories.UserRepository;
import shitta.data.repositories.UserRepositoryImpl;
import shitta.dto.requests.RegisterUserRequest;
import shitta.dto.responses.RegisterUserResponse;
import shitta.utils.Mapper;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) {
        User user = Mapper.map(request);
        User savedUser = userRepository.save(user);
        return Mapper.map(savedUser);
    }
    @Override
    public User findUser(int id) {
        return userRepository.findById(id);
    }

}
