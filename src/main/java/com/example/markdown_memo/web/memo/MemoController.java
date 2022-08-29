package com.example.markdown_memo.web.memo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.markdown_memo.domain.memo.MemoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping
    public String showMemoList(Model model) {
        model.addAttribute("memoList", memoService.findAll());
        return "memos/memoList";
    }

    @GetMapping("/{memoId}")
    public String showMemoPage(@PathVariable("memoId") int memoId, Model model) {
        model.addAttribute("memoList", memoService.findAll());
        model.addAttribute("memos", memoService.findById(memoId));
        return "memos/memo";
    }
}
