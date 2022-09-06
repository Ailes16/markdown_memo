package com.example.markdown_memo.web.memo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemoForm {

    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    @Size(max = 2000)
    private String content;
}
