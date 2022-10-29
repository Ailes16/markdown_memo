package com.example.markdown_memo.web.memo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemoForm {

    private int memoId;

    @NotBlank
    @Size(max = 30)
    private String memoName;

    @NotBlank
    @Size(max = 10000)
    private String content;
}
