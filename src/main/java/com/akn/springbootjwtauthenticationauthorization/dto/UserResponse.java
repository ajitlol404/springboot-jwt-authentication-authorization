package com.akn.springbootjwtauthenticationauthorization.dto;

import com.akn.springbootjwtauthenticationauthorization.entity.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
