package com.paulo.company;

import com.paulo.company.model.User;
import com.paulo.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class QuizPauloApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void chamaSequencia() {

        User user1 = recordUserData();

        User userUpdateData = updateUserData(user1);

        deleteUser(userUpdateData);
    }


    private User recordUserData() {
        User user = new User();

        user.setAge(29);
        user.setEmail("mendespaulo35@gmail.com");
        user.setName("Paulo");
        user.setPassword("485276");
        user.setFullName("Paulo Henrique Mendes Paiva");
        user.setNickName("Blavod");

        System.out.println("A-- Antes de gravar" + user);

        User user1 = userRepository.save(user);

        System.out.println("B-- Depois de gravar" + user1);
        return user1;
    }


    private User updateUserData(User user1) {
        return userRepository.save(user1);
    }

    private void deleteUser(User userDelete) {
        userRepository.delete(userDelete);

    }

}
