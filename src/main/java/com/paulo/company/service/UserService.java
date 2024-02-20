package com.paulo.company.service;

import com.paulo.company.builder.UserMapper;
import com.paulo.company.dto.UserDTO;
import com.paulo.company.model.User;
import com.paulo.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    //salva um usuario
    public UserDTO saveUser(UserDTO userDTO) {
        User userModel = userMapper.toEntity(userDTO);
        userModel = userRepository.save(userModel);

        return userMapper.toDTO(userModel);
    }

    //salva varios usuarios
    public List<User> severalUser(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    //busca por id
    public Optional<UserDTO> searchById(Long id) {
        return Optional.ofNullable(userMapper.toDTO(userRepository.findById(id).get()));
    }

    //atualiza o usuario
    public User updateUser(User user) {
        Optional<User> userController = userRepository.findById(user.getId());
        return userRepository.save(userController.get());
    }

    //apaga usuario
    public void deleteUser(User user) {
        userRepository.delete(user);

    }


}
