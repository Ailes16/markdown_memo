package com.example.markdown_memo.domain.auth;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("select * from users where email = #{email}")
    Optional<User> findByEmail(String email);
}
