package com.example.markdown_memo.domain.group;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupRepository {

    @Select("select g.id, g.group_name from groups as g inner join membership as m on g.id = m.group_id where m.user_id = #{userId}")
    List<Group> findAll(int userId);

    @Select("select * from groups where id = #{groupId}")
    Group findById(int groupId);

    @Insert("insert into groups (group_name) values ('My Memos')")
    @Options(useGeneratedKeys = true, keyProperty = "group.groupId", keyColumn = "id")
    void insertMain(@Param("group") Group group);
}
