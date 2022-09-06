package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemoRepository {

    @Select("select * from memos")
    List<Memo> findAll();

    @Select("select * from memos where id = #{memoId}")
    Memo findById(int memoId);

    @Insert("insert into memos (title, content) values (#{title}, #{content})")
    void insert(@Param("title") String title, @Param("content") String content);
}
