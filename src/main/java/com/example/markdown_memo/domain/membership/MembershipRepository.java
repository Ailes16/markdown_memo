package com.example.markdown_memo.domain.membership;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MembershipRepository {

    @Insert("insert into membership (user_id, group_id) values (#{userId}, #{groupId})")
    void insert(@Param("userId") int userId, @Param("groupId") int groupId);

    @Select("select group_id from membership where user_id = #{userId}")
    List<Integer> findByUserId(int userId);
}
