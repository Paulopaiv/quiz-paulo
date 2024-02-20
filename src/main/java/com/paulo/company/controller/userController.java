package com.paulo.company.controller;

import com.paulo.company.dto.UserDTO;
import com.paulo.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;


    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }



    @GetMapping("find_by_id/{id}")
    public UserDTO save(@PathVariable Long id) {
        return userService.searchById(id).get();
    }


}

