package com.example.markdown_memo.domain.membership;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Membership {

    private int userId;
    private int groupId;
}
