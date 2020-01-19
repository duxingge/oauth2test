package com.example.oauth2test.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "t_role")
@Data
public class Role implements Serializable {

    @Id
    private Integer id;

    /**
     *角色名英文,注意角色名有ROLE_前缀，否则无效
     */
    private String name;
    /**
     * 角色名中文
     */
    private String namezh;
}
