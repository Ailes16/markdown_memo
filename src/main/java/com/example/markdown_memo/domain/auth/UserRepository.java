package com.example.markdown_memo.domain.auth;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("select * from users where email = #{email}")
    Optional<User> findByEmail(String email);

    @Insert("insert into users (user_name, email, password) values (#{username}, #{email}, #{password})")
    void insert(@Param("username") String username, @Param("email") String email, @Param("password") String password);
}
