package com.example.markdown_memo.domain.auth;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("select * from users where email = #{email}")
    Optional<User> findByEmail(String email);

    @Insert("insert into users (user_name, email, password) values (#{user.username}, #{user.email}, #{user.password})")
    @Options(useGeneratedKeys = true, keyProperty = "user.userId", keyColumn = "id")
    void insert(@Param("user") User user);
}
