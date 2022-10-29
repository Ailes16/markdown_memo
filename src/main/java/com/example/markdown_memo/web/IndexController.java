package com.example.markdown_memo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "redirect:/groups/"; // TopPage作成後 "index" に変更
    }
}
