package com.example.markdown_memo.domain.group;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupRepository {

    @Select("select * from groups")
    List<Group> findAll();

    @Select("select * from groups where id = #{groupId}")
    Group findById(int groupId);
}
