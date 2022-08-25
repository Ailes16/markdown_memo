package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemoRepository {

    @Select("select * from memos")
    List<Memo> findAll();
}
