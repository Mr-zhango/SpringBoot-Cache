package cn.myfreecloud.cache.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    private Integer id;

    private String lastName;

    private String email;

    private String gender;

    private String departmentId;

}
