package com.example.markdown_memo.domain.memo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Memo {

    private int memoId;
    private String memoName;
    private String content;
    private int groupId;
}
