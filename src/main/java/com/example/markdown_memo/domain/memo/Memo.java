package com.example.markdown_memo.domain.memo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Memo {

    private int id;
    private String title;
    private String content;
}
