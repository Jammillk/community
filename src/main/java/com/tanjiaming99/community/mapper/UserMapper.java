package com.tanjiaming99.community.mapper;

import com.tanjiaming99.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/11 13:20
 **/
@Mapper
public interface UserMapper {
    /**
     * 插入一个用户
     *
     * @param user
     */
    @Insert("insert into user(name, account_id, token, gmt_create, gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
