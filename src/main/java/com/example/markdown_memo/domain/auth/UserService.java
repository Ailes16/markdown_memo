package com.example.markdown_memo.domain.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String username, String email, String password) {
        var encodedPassword = passwordEncoder.encode(password);
        userRepository.insert(username, email, encodedPassword);
    }
}
