package com.example.markdown_memo.domain.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.markdown_memo.domain.group.GroupService;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final GroupService groupService;

    @Transactional
    public void create(String username, String email, String password) {
        var encodedPassword = passwordEncoder.encode(password);
        final User user = new User(0, username, email, encodedPassword);
        userRepository.insert(user);
        groupService.createMain(user.getUserId());
    }
}
