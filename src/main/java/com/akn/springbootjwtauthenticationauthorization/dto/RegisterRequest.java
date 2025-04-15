package com.akn.springbootjwtauthenticationauthorization.dto;

import com.akn.springbootjwtauthenticationauthorization.entity.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
