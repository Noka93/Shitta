package data.repositories;

import shitta.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shitta.data.repositories.UserRepository;
import shitta.data.repositories.UserRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Create new Package Test")
    public void saveOneUser_countIsOneTest(){
        User user = new User();
        assertEquals(0, userRepository.count());
        userRepository.save(user);

        assertEquals(1, userRepository.count());

    }

    @Test
    @DisplayName("Generate ID test")
    public void saveOneUser_IdIsOneTest(){
        User user = new User();

        assertEquals(0, user.getId());
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());

    }

    @Test
    @DisplayName("Find by id test")
    public void saveOneEvent_findEventById_returnSavedEventTest(){
        User user = new User();
        user.setId(1);
        userRepository.save(user);
        User foundUser = userRepository.findById(1);
        assertEquals(1, foundUser.getId());
        assertEquals(user, foundUser);

    }

}