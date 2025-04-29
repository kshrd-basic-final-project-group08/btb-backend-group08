package org.hrd.finalprojectmuseum.repository;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.hrd.finalprojectmuseum.model.dto.request.RegisterRequest;
import org.hrd.finalprojectmuseum.model.entity.AppUser;

import java.util.UUID;

@Mapper
public interface AppUserRepository {

    @Select("""
        SELECT role_name FROM role WHERE role_id = #{roleId}::UUID
    """)
    String getRoleName(UUID roleId);

    @Select("""
            SELECT * from users
            WHERE email = #{email}
            """)
    @Results(id = "userMapper", value = {
            @Result(property = "userId", column = "user_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "credentialType", column = "credential_type"),
            @Result(property = "role", column = "role_id",
                    one = @One(select = "getRoleName")
            ),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "isApprove", column = "is_approve"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "updatedAt", column = "updated_at"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "isDelete", column = "is_delete")

    })
    AppUser getUserByEmail(String email);

    @Select("""
            SELECT * from users
            WHERE user_id = #{appUserId}::UUID
            """)
    @ResultMap("userMapper")
    AppUser getUserById(UUID appUserId);


    @Select("""
            INSERT INTO users(name, email, password, role_id)
            VALUES(#{user.name}, #{user.email}, #{user.password}, #{user.roleId}::UUID)
            RETURNING *
            """)
    @ResultMap("userMapper")
    AppUser registerUser(@Param("user") RegisterRequest registerRequest);

    @Update("""
            UPDATE users
            SET is_verified = true
            WHERE email = #{email}
            """)
    void verifyEmailWithOpt(String email);
}
