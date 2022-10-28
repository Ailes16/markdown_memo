package com.example.markdown_memo.web.signup;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.markdown_memo.domain.auth.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @GetMapping
    public String showSignupForm(@ModelAttribute SignupForm form) {
        return "signup/signup";
    }

    @PostMapping
    public String create(@Validated SignupForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showSignupForm(form);
        }
        userService.create(form.getUsername(), form.getEmail(), form.getPassword());
        return "redirect:/login";
    }
}
