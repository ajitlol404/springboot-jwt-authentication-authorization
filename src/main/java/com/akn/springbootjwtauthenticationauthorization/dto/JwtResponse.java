package com.akn.springbootjwtauthenticationauthorization.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
}

