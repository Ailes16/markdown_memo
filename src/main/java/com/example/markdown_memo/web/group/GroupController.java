package com.example.markdown_memo.web.group;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.markdown_memo.domain.auth.CustomUserDetails;
import com.example.markdown_memo.domain.group.GroupService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public String showGroupList(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("groupList", groupService.findAll(userDetails.getUserId()));
        return "groups/groupList";
    }
}
