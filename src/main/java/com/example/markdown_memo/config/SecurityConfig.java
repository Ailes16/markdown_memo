package com.example.markdown_memo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.markdown_memo.domain.auth.CustomUserDetails;
import com.example.markdown_memo.domain.membership.MembershipService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final MembershipService membershipService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .formLogin(login -> login
                        .usernameParameter("email")
                        .loginPage("/login"))
                .authorizeHttpRequests(authz -> authz
                        .antMatchers("/css/**", "/js/**").permitAll()
                        .mvcMatchers("/login/**").permitAll()
                        .mvcMatchers("/signup/**").permitAll()
                        .mvcMatchers("/memos/{groupId}/**")
                        .access((authentication, object) -> new AuthorizationDecision(
                                hasGroupId(authentication.get(), object.getRequest().getServletPath()))) // TODO:未承認時のエラー対策
                        .anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    // groupに所属しているかの判定
    private boolean hasGroupId(Authentication authentication, String url) {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<Integer> groupId = membershipService.findByUserId(userDetails.getUserId());
        int size = groupId.size();

        for (int i = 0; i < size; i++) {
            if (url.contains(groupId.get(i).toString())) {
                return true;
            }
        }
        return false;
    }
}
