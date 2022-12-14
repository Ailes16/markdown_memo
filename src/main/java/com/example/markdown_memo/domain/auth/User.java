package com.example.markdown_memo.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int userId;
    private String username;
    private String email;
    private String password;
}
