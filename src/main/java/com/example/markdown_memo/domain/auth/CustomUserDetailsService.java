package com.example.markdown_memo.domain.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(
                        user -> new CustomUserDetails(
                                user.getUsername(),
                                user.getEmail(),
                                user.getPassword()))
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "Given email is not found. (email = '" + email + "')"));
    }

}
