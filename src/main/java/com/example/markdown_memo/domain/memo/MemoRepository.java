package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemoRepository {

    @Select("select * from memos where group_id = #{groupId}")
    List<Memo> findAll(int groupId);

    @Select("select * from memos where id = #{memoId}")
    Memo findById(int memoId);

    @Insert("insert into memos (memo_name, content, group_id) values (#{memoName}, #{content}, #{groupId})")
    void insert(@Param("memoName") String memoName, @Param("content") String content, @Param("groupId") int groupId);

    @Update("update memos set memo_name = #{memoName}, content = #{content} where id = #{memoId}")
    void update(@Param("memoId") int memoId, @Param("memoName") String memoName, @Param("content") String content);

    @Delete("delete from memos where id = #{memoId}")
    void delete(@Param("memoId") int memoId);
}
