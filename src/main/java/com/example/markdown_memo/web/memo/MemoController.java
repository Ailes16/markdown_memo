package com.example.markdown_memo.web.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memos")
public class MemoController {

    @GetMapping
    public String showMemoList() {
        return "memos/memoList";
    }
}
