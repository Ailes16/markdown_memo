package com.example.markdown_memo.web.memo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.markdown_memo.domain.memo.MemoService;

import lombok.RequiredArgsConstructor;

@Controller
// @RequestMapping("/memos")
@RequestMapping("/memos/{groupId}")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    // @GetMapping("/{groupId}")
    @GetMapping
    public String showMemoPage(@PathVariable("groupId") int groupId, Model model) {
        model.addAttribute("memoList", memoService.findAll(groupId));
        return "memos/memo";
    }

    @GetMapping("/createMemo")
    public String showCreationMemo(@ModelAttribute MemoForm form) {

        return "memos/createMemo";
    }

    @PostMapping
    public String create(@Validated MemoForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return showCreationMemo(form);
        }

        memoService.create(form.getMemoName(), form.getContent());
        return "redirect:/memos"; // TODO: groupIdの追加
    }
}
