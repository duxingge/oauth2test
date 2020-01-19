package com.example.oauth2test.repository;

import com.example.oauth2test.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("select r from t_role r,t_user_role ur where ur.uid=:uid and ur.rid = r.id")
    List<Role> findRolesByUserId(@Param("uid") Integer userId);

}
