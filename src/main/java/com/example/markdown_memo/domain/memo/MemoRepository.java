package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemoRepository {

    @Select("select * from memos where group_id = #{groupId}")
    List<Memo> findAll(int groupId);

    @Select("select * from memos where id = #{memoId}")
    Memo findById(int memoId);

    @Insert("insert into memos (memo_name, content, group_id) values (#{memoName}, #{content}, #{groupId})")
    void insert(@Param("memoName") String memoName, @Param("content") String content, @Param("groupId") int groupId);
}
