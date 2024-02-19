package com.paulo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {


    private Long id;
    private String name;
    private String fullName;
    private Integer age;
    private String email;
    private String password;
    private String nickName;


}
