package com.example.markdown_memo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .formLogin(login -> login
                        .usernameParameter("email")
                        .loginPage("/login"))
                .authorizeHttpRequests(authz -> authz
                        .antMatchers("/css/**", "/js/**").permitAll()
                        .mvcMatchers("/login/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
